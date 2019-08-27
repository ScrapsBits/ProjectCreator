package eu.electricfrog.projectcreator.core.files.write.project;

import java.io.File;

import eu.electricfrog.projectcreator.core.files.write.FileWriter;
import eu.electricfrog.projectcreator.core.models.Project;

abstract class GenericFileWriter implements FileWriter {
	/**
	 * Resembles the file to be written for the project.
	 */
	protected File file;
	/**
	 * The project being saved to the system.
	 */
	protected Project project;

	protected GenericFileWriter(Project project) {
		this.project = project;
	}
	
	@Override
	public final File getFile() { return this.file; }
}
