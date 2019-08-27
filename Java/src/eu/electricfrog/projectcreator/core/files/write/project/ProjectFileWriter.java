package eu.electricfrog.projectcreator.core.files.write.project;

import eu.electricfrog.projectcreator.core.models.Project;

public abstract class ProjectFileWriter extends GenericFileWriter {
	public ProjectFileWriter(Project project) {
		super(project);
	}
}
