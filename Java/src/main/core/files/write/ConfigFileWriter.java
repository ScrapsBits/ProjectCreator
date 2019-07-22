package main.core.files.write;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import main.core.enumerations.ProgrammingLanguage;
import main.core.files.enumerations.ConfigStructure;
import main.models.Configuration;

/**
 * Write the configuration file.
 * 
 * @author ScrapsBits
 */
public final class ConfigFileWriter extends ProjectCreatorFileWriter {
	/**
	 * Keep a reference to the configuration model.
	 */
	private Configuration config;

	/**
	 * Represents an in-memory version of the configuration file.
	 */
	private File configFile;

	/**
	 * Prepare the writing of the configuration into a file.
	 * 
	 * @param configuration The configuration settings.
	 */
	public ConfigFileWriter(Configuration configuration, ConfigStructure structure) {
		super(configuration.getConfigLocation());
		this.config = configuration;
		super.configStructure = structure;
		this.configFile = new File(config.getConfigLocation() + "/.config");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void write() {
		// FileWriter writer = new FileWriter(configFile);
		// writer.write("This should be line one.\n");
		// writer.write("Will this be line two?");
		// writer.close();

		switch(this.configStructure) {
			case XML:
				writeXML();
				break;
		}
	}

	private void writeXML() {
		try {
			DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
			Document document = documentBuilder.newDocument();
			
			Element root = document.createElement("configuration");
			document.appendChild(root);

			Element project = document.createElement("project");
			Attr projectName = document.createAttribute("name");
			projectName.setValue(this.config.getProjectName());
			project.setAttributeNode(projectName);
			Attr projectLocation = document.createAttribute("location");
			projectLocation.setValue(this.config.getConfigLocation());
			project.setAttributeNode(projectLocation);
			root.appendChild(project);
			
			Element programming = document.createElement("languages");
			root.appendChild(programming);
			
			for(ProgrammingLanguage language : this.config.getSelectedProgrammingLanguages()) {
				Element lang = document.createElement("programming-language");
				Attr langName = document.createAttribute("name");
				langName.setValue(language.getName());
				lang.setAttributeNode(langName);
				Attr type = document.createAttribute("type");
				type.setValue(language.isFunctional() ? "functional" : "object-oriented");
				lang.setAttributeNode(type);
				programming.appendChild(lang);
			}

			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.METHOD, "xml");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
			
			DOMSource domSource = new DOMSource(document);
			StreamResult streamResult = new StreamResult(configFile);
			transformer.transform(domSource, streamResult);
		} catch(ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
