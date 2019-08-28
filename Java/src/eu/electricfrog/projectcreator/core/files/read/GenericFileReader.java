package eu.electricfrog.projectcreator.core.files.read;

import java.io.File;

/**
 * Generic functionality for any file reader.
 *
 * @author  ScrapsBits
 * @version 1.0
 */
public abstract class GenericFileReader implements FileReader {
	/**
	 * Resemble the file to read.
	 */
	private final File file;

	/**
	 * Initialize a new FileReader instance.
	 * 
	 * @param file The file read by this reader.
	 */
	protected GenericFileReader(final File file) { this.file = file; }

	@Override
	public File getFile() { return this.file; }

}
