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
	private final Configuration config;

	/**
	 * Represents an in-memory version of the configuration file.
	 */
	private final File configFile;

	/**
	 * Prepare the writing of the configuration into a file.
	 *
	 * @param configuration The configuration settings.
	 * @param structure     The structure used for the writing of the Configuration file.
	 */
	public ConfigFileWriter(final Configuration configuration, final String location) {
		super(location, configuration.getFileStructure());
		this.config = configuration;
		this.configFile = new File(location + "/.config");
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void write() {
		System.out.println("Writing the config file."); // TODO: Replace with log component.
		// FileWriter writer = new FileWriter(configFile);
		// writer.write("This should be line one.\n");
		// writer.write("Will this be line two?");
		// writer.close();

		switch(this.fileStructure) {
			case XML:
				this.writeXML();
				break;
			case KEYVALUE:
				throw new UnsupportedOperationException();
		}
		System.out.println("Config file written."); // TODO: Replace with log component.
	}

	private void writeXML() {
		try {
			final DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
			final DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
			final Document document = documentBuilder.newDocument();

			final Element root = document.createElement("configuration");
			document.appendChild(root);

			final Element programming = document.createElement("languages");
			root.appendChild(programming);

			for(final ProgrammingLanguage language : this.config.getSelectedProgrammingLanguages()) {
				final Element lang = document.createElement("programming-language");
				final Attr langName = document.createAttribute("name");
				langName.setValue(language.getName());
				lang.setAttributeNode(langName);
				final Attr type = document.createAttribute("type");
				type.setValue(language.isFunctional() ? "functional" : "object-oriented");
				lang.setAttributeNode(type);
				programming.appendChild(lang);
			}

			final TransformerFactory transformerFactory = TransformerFactory.newInstance();
			final Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.METHOD, "xml");
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");

			final DOMSource domSource = new DOMSource(document);
			final StreamResult streamResult = new StreamResult(this.configFile);
			transformer.transform(domSource, streamResult);
		} catch(final ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(final TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(final TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
