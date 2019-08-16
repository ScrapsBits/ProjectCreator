package eu.electricfrog.projectcreator.core.files.read.project;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import eu.electricfrog.projectcreator.core.files.read.FileReader;
import eu.electricfrog.projectcreator.core.models.ProgrammingLanguage;
import eu.electricfrog.projectcreator.core.models.ProgrammingLanguageType;
import eu.electricfrog.projectcreator.core.models.Project;

/**
 * A reader class to read an XML file into a project.
 * 
 * @author  ScrapsBits
 * @version 1.0
 */
public class ConfigFileReader implements FileReader {
	private final File file;
	private Project project;

	public ConfigFileReader(File file) { this.file = file; }

	@Override
	public File getFile() { return this.file; }
	
	/**
	 * Get the project from the reader. 
	 * @return Returns the project as it was read from the file. Returns null if the project hasn't been read yet.
	 */
	public Project getProject() { return this.project; }

	@Override
	public void read() {
		// Placeholder fields to use for making the Project instance later.
		String name = null;
		String configLocation = file.getAbsolutePath();
		String directory = null;
		List<ProgrammingLanguage> languages = new ArrayList<>();
		// TODO: Read the selected config file and load in a project.
		try {
			final DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			documentBuilderFactory.setIgnoringElementContentWhitespace(true);
			final DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
			final Document document = documentBuilder.parse(this.file);
			document.getDocumentElement().normalize();
			System.out.println("Found root node " + document.getDocumentElement().getNodeName()); // TODO: Replace with log component.

			name = document.getDocumentElement().getAttribute("name");

			final NodeList nodes = document.getDocumentElement().getChildNodes();
			for(int i = 0; i < nodes.getLength(); i += 1) {
				final Node node = nodes.item(i);
				if(node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element)node;
					switch(element.getNodeName()) {
						case "programming-languages":
							final NodeList languageNodes = element.getChildNodes();
							for(int r = 0; r < languageNodes.getLength(); r += 1) {
								final Node languageNode = languageNodes.item(r);
								if(languageNode.getNodeType() == Node.ELEMENT_NODE) {
								final Element languageElement = (Element)languageNode;
								String languageName = languageElement.getAttribute("name");
								String languageType = languageElement.getAttribute("type");
								String languageVersion = languageElement.getAttribute("version");
								languages.add(new ProgrammingLanguage(languageName, languageVersion, ProgrammingLanguageType.valueOf(languageType.toUpperCase())));
								}
							}
							break;
					}
				}
			}
			this.project = new Project(directory, name, configLocation, languages);
		} catch(ParserConfigurationException|SAXException|IOException e) {
			e.printStackTrace();
		}
	}
}
