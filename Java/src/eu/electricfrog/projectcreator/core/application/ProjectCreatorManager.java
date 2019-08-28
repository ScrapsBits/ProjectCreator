package eu.electricfrog.projectcreator.core.application;

import eu.electricfrog.projectcreator.core.application.boot.ApplicationBoot;
import eu.electricfrog.projectcreator.core.application.boot.ProjectCreatorBoot;
import eu.electricfrog.projectcreator.core.application.data.ApplicationData;
import eu.electricfrog.projectcreator.core.application.data.ProjectCreatorData;
import eu.electricfrog.projectcreator.core.application.permissions.ApplicationPermissions;
import eu.electricfrog.projectcreator.core.application.permissions.ProjectCreatorPermissions;

/**
 * Keep track of various aspects related to the ProjectCreator application.
 *
 * @author  ScrapsBits
 * @version 1.0
 */
public class ProjectCreatorManager implements ApplicationManager {
	// TODO: Change interface references to ProjectCreator specific references.
	/**
	 * References the boot manager of the application.
	 */
	private final ApplicationBoot appBoot;
	/**
	 * References the data manager of the application.
	 */
	private final ApplicationData appData;
	/**
	 * References the permissions manager of the application.
	 */
	private final ApplicationPermissions appPermissions;

	/**
	 * Handle the received arguments and initialize the core of the application.
	 *
	 * @param args Console arguments provided with the application being executed.
	 */
	public ProjectCreatorManager(final String[] args) {
		// TODO: Handle boot arguments.
		// TODO: Handle permission arguments.
		this.appBoot = new ProjectCreatorBoot(ProjectCreatorBoot.DEFAULT_BOOT_MODE);
		this.appData = new ProjectCreatorData();
		this.appPermissions = new ProjectCreatorPermissions();
	}

	@Override
	public ApplicationBoot boot() { return this.appBoot; }

	@Override
	public ApplicationData data() { return this.appData; }

	@Override
	public ApplicationPermissions permissions() { return this.appPermissions; }

}
