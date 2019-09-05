package eu.electricfrog.projectcreator.core.files.type.xml;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import eu.electricfrog.projectcreator.core.files.type.FileHandler;

/**
 * Handle XML files.
 * 
 * @author  ScrapsBits
 * @since 1.1
 * @version 1.1
 */
public abstract class XmlFileHandler extends FileHandler {
	public XmlFileHandler(final File file) { super(file); }

	// TODO: Turn buildDocument into static functions.
	/**
	 * Build the XML document reader/writer.
	 * 
	 * @return                              Returns a Document object containing elements from the XML file.
	 * @throws ParserConfigurationException Thrown if a DocumentBuildercannot be created which satisfies the configuration requested.
	 * @throws SAXException                 Thrown if any parse errors occur.
	 * @throws IOException                  Thrown if any IO errors occur.
	 */
	public final Document buildDocument() throws ParserConfigurationException, SAXException, IOException { return this.buildDocument(false); }

	/**
	 * Build the XML document reader/writer.
	 * 
	 * @param  validating                   If true, set the XML file to validate based on the .dtd file reference included in the XML file.
	 * @return                              Returns a Document object containing elements from the XML file.
	 * @throws ParserConfigurationException Thrown if a DocumentBuildercannot be created which satisfies the configuration requested.
	 * @throws SAXException                 Thrown if any parse errors occur.
	 * @throws IOException                  Thrown if any IO errors occur.
	 */
	public final Document buildDocument(final boolean validating) throws ParserConfigurationException, SAXException, IOException {
		final DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		documentBuilderFactory.setIgnoringElementContentWhitespace(true);
		// TODO: Set ErrorHandler.
		documentBuilderFactory.setValidating(validating);
		final DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		final Document document = documentBuilder.parse(super.file());
		document.getDocumentElement().normalize();
		return document;
	}
}
