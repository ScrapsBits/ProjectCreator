package eu.electricfrog.projectcreator.core.files.write;

import eu.electricfrog.projectcreator.core.files.FileManager;

/**
 * Allows classes to write files to the file system if the application has permission to write.
 *
 * @author  ScrapsBits
 * @since   1.0
 * @version 1.0
 */
public interface FileWriter extends FileManager {
	/**
	 * Write the file to the system memory.
	 */
	void write();
}
