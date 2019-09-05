package eu.electricfrog.projectcreator.core.files.write.project;

import eu.electricfrog.projectcreator.core.models.Project;

/**
 * Write new files related to the given project.
 *
 * @author  ScrapsBits
 * @since   1.0
 * @version 1.0
 */
public abstract class ProjectFileWriter extends GenericFileWriter {
	/**
	 * The project being saved to the system.
	 */
	private Project project;

	/**
	 * Keep track of the project written by the writer.
	 *
	 * @param project The project to write.
	 */
	public ProjectFileWriter(final Project project) { super(); }

	/**
	 * Get the project of this writer.
	 *
	 * @return Returns the project linked to this writer.
	 */
	protected Project project() { return this.project; }
}
