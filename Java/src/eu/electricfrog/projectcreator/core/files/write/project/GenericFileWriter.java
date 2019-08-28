package eu.electricfrog.projectcreator.core.files.write.project;

import java.io.File;

import eu.electricfrog.projectcreator.core.files.write.FileWriter;

/**
 * Generic functionality for any file writer.
 *
 * @author  ScrapsBits
 * @version 1.0
 */
abstract class GenericFileWriter implements FileWriter {
	/**
	 * Resembles the file to be written for the project.
	 */
	private File file;

	/**
	 * Initialize a new FileWriter instance.
	 *
	 * @param project The project related to the file writing.
	 */
	protected GenericFileWriter() {}

	@Override
	public final File getFile() { return this.file; }

	/**
	 * Set the file of the file writer.
	 * 
	 * @param file The file to be written.
	 */
	protected final void setFile(final File file) { this.file = file; }
}
