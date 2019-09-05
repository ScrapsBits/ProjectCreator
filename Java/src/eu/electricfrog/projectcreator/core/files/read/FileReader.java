package eu.electricfrog.projectcreator.core.files.read;

import eu.electricfrog.projectcreator.core.files.FileManager;

/**
 * Allows classes to read files if the application has read permissions.
 * 
 * @author  ScrapsBits
 * @since 1.0
 * @version 1.0
 */
public interface FileReader extends FileManager {
	/**
	 * Read a file from the system memory.
	 * 
	 * @returns Returns an object from the read file.
	 */
	Object read();
}
