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
				File configFile = new File(this.getFileLocation());

				try {
					DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
					DocumentBuilder documentBuilder;
					documentBuilder = documentBuilderFactory.newDocumentBuilder();
					Document document = documentBuilder.parse(configFile);

					document.getDocumentElement().normalize();

					NodeList nodes = document.getChildNodes();
					for(int i = 0; i < nodes.getLength(); i += 1) {
						Node node = nodes.item(i);

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
								for(int r = 0; r < languages.getLength(); r += 1) {
									NamedNodeMap languagesMap = languages.item(r).getAttributes();
									for(ProgrammingLanguage programmingLanguage : ProgrammingLanguage.values()) {
										if(languagesMap.getNamedItem("name").getNodeValue().equals(programmingLanguage.getName())) { config.addProgrammingLanguage(programmingLanguage); }
									}
								}
								break;
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
