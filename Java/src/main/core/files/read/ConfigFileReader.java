package main.core.files.read;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import main.core.enumerations.ProgrammingLanguage;
import main.core.files.enumerations.ConfigStructure;
import main.models.Configuration;

public class ConfigFileReader extends ProjectCreatorFileReader {

	/**
	 * Read a file from the provided location.
	 *
	 * @param fileLocation           The location where the files are stored.
	 * @param configurationStructure The structure used by the files being read.
	 */
	public ConfigFileReader(final String fileLocation, final ConfigStructure configurationStructure) { super(fileLocation, configurationStructure); }

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Configuration read() {
		Configuration config = new Configuration();
		switch(this.configStructure) {
			case XML:
				File configFile = new File(this.getFileLocation() + "\\.config");

				try {
					DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
					documentBuilderFactory.setIgnoringElementContentWhitespace(true);
					DocumentBuilder documentBuilder;
					documentBuilder = documentBuilderFactory.newDocumentBuilder();
					Document document = documentBuilder.parse(configFile);
					System.out.println("Opening file " + document.getLocalName() + "."); // TODO: Replace with log component.

					document.getDocumentElement().normalize();
					System.out.println("Found node " + document.getDocumentElement().getNodeName() + "."); // TODO: Replace with log component.

					NodeList nodes = document.getDocumentElement().getChildNodes();
					System.out.println("Found " + nodes.getLength() + " children.");
					for(int i = 0; i < nodes.getLength(); i += 1) {
						Node node = nodes.item(i);
						if(node.getNodeType() == Node.ELEMENT_NODE) {
							System.out.println("Reading child node " + node.getNodeName() + "."); // TODO: Replace with log component.

							switch(node.getNodeName()) {
								case "project":
									NamedNodeMap projectMap = node.getAttributes();
									Node projectLocationNode = projectMap.getNamedItem("location");
									config.setConfigLocation(projectLocationNode.getNodeValue());
									Node projectNameNode = projectMap.getNamedItem("name");
									config.setProjectName(projectNameNode.getNodeValue());
									break;
								case "languages":
									NodeList languages = node.getChildNodes();
									System.out.println("Found " + languages.getLength() + " languages.");
									for(int r = 0; r < languages.getLength(); r += 1) {
										if(languages.item(r).getNodeType() == Node.ELEMENT_NODE) {
											NamedNodeMap languagesMap = languages.item(r).getAttributes();
											for(ProgrammingLanguage programmingLanguage : ProgrammingLanguage.values()) {
												if(languagesMap.getNamedItem("name").getNodeValue().contentEquals(programmingLanguage.getName())) {
													System.out.println("Found " + (programmingLanguage.isFunctional() ? "functional" : "object-oriented") + " language " + programmingLanguage.getName() + ".");
													config.addProgrammingLanguage(programmingLanguage);
												}
											}
										}
									}
									break;
							}
						}
					}

				} catch(SAXException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch(IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch(ParserConfigurationException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				return config;
		}
		return null;
	}
}
