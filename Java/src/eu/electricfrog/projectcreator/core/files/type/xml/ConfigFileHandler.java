package eu.electricfrog.projectcreator.core.files.type.xml;

import java.io.File;

/**
 * Handle the .config file.
 * @author ScrapsBits
 * @version 1.1
 */
public class ConfigFileHandler extends XmlFileHandler {
	
	/**
	 * Receive a .config file.
	 * @param file The configuration file of a certain project.
	 */
	public ConfigFileHandler(File file) {
		super(file);
		if(!file.getAbsolutePath().endsWith(".config")) throw new IllegalArgumentException("The provided file is not a config file.");
	}
}
