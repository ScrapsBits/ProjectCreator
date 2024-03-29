package eu.electricfrog.projectcreator.core.files.write.project;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import eu.electricfrog.projectcreator.ApplicationLauncher;
import eu.electricfrog.projectcreator.core.application.boot.BootMode;
import eu.electricfrog.projectcreator.core.models.ProgrammingLanguage;
import eu.electricfrog.projectcreator.core.models.Project;

/**
 * A writer class to write an XML file for a project.
 * 
 * @author  ScrapsBits
 * @version 1.0
 */
public class ConfigFileWriter extends GenericFileWriter {
	/**
	 * Set the project for this file writer.
	 * 
	 * @param project The project to be written into a file.
	 */
	public ConfigFileWriter(Project project) {
		super(project);
		if(project.getConfigFile().contains(".config")) {
			this.file = new File(project.getConfigFile());
		} else {
			this.file = new File(project.getConfigFile() + "/.config");
		}
	}

	@Override
	public void write() {
		System.out.println("Writing .config file for project " + project.toString() + "."); // TODO: Replace with log component.
		try {
			// TODO: Check for writing permissions.
			boolean hasPermission = false;
			if(ApplicationLauncher.manager().boot().getBootMode().equals(BootMode.DEVELOPMENT)) { hasPermission = true; }
			if(hasPermission) {
				final DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
				final DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
				final Document document = documentBuilder.newDocument();

				final Element root = document.createElement("project");
				root.setAttribute("name", this.project.getName());
				document.appendChild(root);

				if(this.project.getProgrammingLanguages().size() > 0) {
					final Element programmingLanguages = document.createElement("programming-languages");
					root.appendChild(programmingLanguages);
					for(ProgrammingLanguage programmingLanguage : this.project.getProgrammingLanguages()) {
						final Element language = document.createElement("programming-language");
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

				final DOMSource domSource = new DOMSource(document);
				final StreamResult streamResult = new StreamResult(this.file);
				transformer.transform(domSource, streamResult);

				System.out.println("File written at " + project.getConfigFile() + "."); // TODO: Replace with log component.
			} else {
				System.out.println("No permission to write files."); // TODO: Replace with log component.
				// TODO: Throw exception.
			}
			// TODO: Catch exceptions when the file cannot be written.
		} catch(ParserConfigurationException | TransformerException e) {
			e.printStackTrace();
		}
	}

}
