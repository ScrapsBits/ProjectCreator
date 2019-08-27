package eu.electricfrog.projectcreator.core.files.read;

import eu.electricfrog.projectcreator.core.files.FileManager;

/**
 * Allows classes to read files if the application has read permissions.
 * @author ScrapsBits
 * @version 1.0
 */
public interface FileReader extends FileManager {
	/**
	 * Read a file from the system memory.
	 */
	void read();
}
