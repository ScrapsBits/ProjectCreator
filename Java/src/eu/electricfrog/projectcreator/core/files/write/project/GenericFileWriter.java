package eu.electricfrog.projectcreator.core.files.write.project;

import java.io.File;

import eu.electricfrog.projectcreator.core.files.write.FileWriter;
import eu.electricfrog.projectcreator.core.models.Project;

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
	 * The project being saved to the system.
	 */
	private Project project;

	/**
	 * Initialize a new FileWriter instance.
	 * 
	 * @param project The project related to the file writing.
	 */
	protected GenericFileWriter(Project project) { this.project = project; }

	/**
	 * Get the project of this writer.
	 * 
	 * @return Returns the project linked to this writer.
	 */
	protected Project project() { return this.project; }

	@Override
	public final File getFile() { return this.file; }
	
	/**
	 * Set the file of the file writer.
	 * @param file The file to be written.
	 */
	protected final void setFile(File file) { this.file = file; }
}
