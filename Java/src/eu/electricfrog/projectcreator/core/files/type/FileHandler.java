package eu.electricfrog.projectcreator.core.files.type;

import java.io.File;

/**
 * Generic functionality to handle files reading and writing.
 *
 * @author  ScrapsBits
 * @since 1.1
 * @version 1.1
 */
public abstract class FileHandler {
	/**
	 * The file being handled.
	 */
	private final File file;

	/**
	 * Initialize a new handler for the provided file.
	 * 
	 * @param file The file being handled.
	 */
	protected FileHandler(final File file) { this.file = file; }

	/**
	 * Get the file of this handler.
	 * 
	 * @return Returns the handled file.
	 */
	protected File file() { return this.file; }
}
