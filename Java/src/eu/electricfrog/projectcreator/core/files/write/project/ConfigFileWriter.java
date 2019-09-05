package eu.electricfrog.projectcreator.core.files.write.project;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import eu.electricfrog.projectcreator.core.application.Application;
import eu.electricfrog.projectcreator.core.application.configuration.permissions.Permission;
import eu.electricfrog.projectcreator.core.files.FileManager;
import eu.electricfrog.projectcreator.core.files.type.xml.ConfigFileHandler;
import eu.electricfrog.projectcreator.core.files.type.xml.XmlFileHandler;
import eu.electricfrog.projectcreator.core.models.ProgrammingLanguage;
import eu.electricfrog.projectcreator.core.models.Project;

/**
 * A writer class to write an XML file for a project.
 *
 * @author  ScrapsBits
 * @since   1.0
 * @version 1.0
 */
public final class ConfigFileWriter extends ProjectFileWriter {
	/**
	 * Set the project for this file writer.
	 *
	 * @param project The project to be written into a file.
	 */
	public ConfigFileWriter(final Project project) {
		super(project);
		if(project.getConfigFile().contains(".config"))
			super.setFile(new File(project.getConfigFile()));
		else
			super.setFile(new File(project.getConfigFile() + "/.config"));
	}

	@Override
	public void write() {
		System.out.println("Writing .config file for project " + this.project().toString() + "."); // TODO: Replace with log component.
		try {
			if(Application.hasPermission(Permission.FILE_WRITE)) {
				final XmlFileHandler fileHandler = new ConfigFileHandler(super.getFile());
				final Document document = fileHandler.buildDocument(true);

				final Element root = document.createElement("project");
				root.setAttribute("name", this.project().getName());
				document.appendChild(root);

				if(this.project().getProgrammingLanguages().size() > 0) {
					final Element programmingLanguages = document.createElement("programming_languages");
					root.appendChild(programmingLanguages);
					for(final ProgrammingLanguage programmingLanguage : this.project().getProgrammingLanguages()) {
						final Element language = document.createElement("programming_language");
						language.setAttribute("name", programmingLanguage.getName());
						language.setAttribute("version", programmingLanguage.getVersion());
						language.setAttribute("type", programmingLanguage.getType().toString().toLowerCase());
						programmingLanguages.appendChild(language);
					}
				}

				final TransformerFactory transformerFactory = TransformerFactory.newInstance();
				final Transformer transformer = transformerFactory.newTransformer();
				transformer.setOutputProperty(OutputKeys.METHOD, "xml");
				transformer.setOutputProperty(OutputKeys.INDENT, "yes");
				transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
				final DOMImplementation domImplementation = document.getImplementation();
				// TODO: Replace hardcoded path with online file.
				final DocumentType docType = domImplementation.createDocumentType("doctype", "-//Project//DTD Project V1.0//EN",
						FileManager.getApplicationDataDirectory() + "/resources/config.dtd");
				transformer.setOutputProperty(OutputKeys.DOCTYPE_PUBLIC, docType.getPublicId());
				transformer.setOutputProperty(OutputKeys.DOCTYPE_SYSTEM, docType.getSystemId());
				final DOMSource domSource = new DOMSource(document);
				final StreamResult streamResult = new StreamResult(super.getFile());
				transformer.transform(domSource, streamResult);

				System.out.println("File written at " + this.project().getConfigFile() + "."); // TODO: Replace with log component.
			} else // TODO: Add "No permission" exception.
				System.out.println("No permission to write files."); // TODO: Replace with log component.
			// TODO: Throw exception.
		} catch(ParserConfigurationException | TransformerException e) {
			e.printStackTrace();
		} catch(final SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(final IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
