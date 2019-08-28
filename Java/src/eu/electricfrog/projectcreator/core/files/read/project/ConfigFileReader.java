package eu.electricfrog.projectcreator.core.files.read.project;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import eu.electricfrog.projectcreator.core.files.read.GenericFileReader;
import eu.electricfrog.projectcreator.core.files.type.xml.ConfigFileHandler;
import eu.electricfrog.projectcreator.core.files.type.xml.XmlFileHandler;
import eu.electricfrog.projectcreator.core.models.ProgrammingLanguage;
import eu.electricfrog.projectcreator.core.models.Project;

/**
 * A reader class to read an XML file into a project.
 * 
 * @author  ScrapsBits
 * @version 1.0
 */
public final class ConfigFileReader extends GenericFileReader {
	/**
	 * Initialize a reader for the configuration file.
	 * 
	 * @param file The configuration file to read. This file is generally selected by the user.
	 */
	public ConfigFileReader(File file) { super(file); }

	/**
	 * {@inheritDoc}
	 * @return Returns a project read from the reader's file. Returns null if the project could not be read properly.
	 */
	@Override
	public final Project read() {
		// Placeholder fields to use for making the Project instance later.
		String name = null;
		String configLocation = super.getFile().getAbsolutePath();
		String directory = null;

		List<ProgrammingLanguage> languages = new ArrayList<>();
		try {
			XmlFileHandler fileHandler = new ConfigFileHandler(super.getFile());
			Document document = fileHandler.buildDocument(true);
			System.out.println("Found root node " + document.getDocumentElement().getNodeName()); // TODO: Replace with log component.

			name = document.getDocumentElement().getAttribute("name");

			final NodeList nodes = document.getDocumentElement().getChildNodes();
			for(int i = 0; i < nodes.getLength(); i += 1) {
				final Node node = nodes.item(i);
				if(node.getNodeType() == Node.ELEMENT_NODE) {
					Element element = (Element)node;
					switch(element.getNodeName()) {
						// TODO: Replace hard-coded values with more flexible values.
						case "programming_languages":
							languages.addAll(this.readLanguages(element));
							break;
					}
				}
			}
			return new Project(directory, name, configLocation, languages);
		} catch(ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Read the languages from an element containing programming languages.
	 * @param element The element containing a list of programming languages.
	 * @return Returns a list of all found programming languages. Returns an empty list if no programming languages could be read.
	 */
	private final List<ProgrammingLanguage> readLanguages(Element element) {
		List<ProgrammingLanguage> languages = new ArrayList<>();
		final NodeList languageNodes = element.getChildNodes();
		for(int i = 0; i < languageNodes.getLength(); i += 1) {
			final Node languageNode = languageNodes.item(i);
			if(languageNode.getNodeType() == Node.ELEMENT_NODE) {
				final Element languageElement = (Element)languageNode;
				// TODO: Add "Settings" for each language, if present.
				languages.add(new ProgrammingLanguage(languageElement.getAttribute("name"), languageElement.getAttribute("type"), languageElement.getAttribute("version")));
			}
		}
		return languages;
	}
}
