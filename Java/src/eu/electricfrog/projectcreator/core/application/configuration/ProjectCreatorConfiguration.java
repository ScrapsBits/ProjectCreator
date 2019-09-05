package eu.electricfrog.projectcreator.core.application.configuration;

import eu.electricfrog.projectcreator.core.application.configuration.boot.Boot;
import eu.electricfrog.projectcreator.core.application.configuration.boot.ProjectCreatorBoot;
import eu.electricfrog.projectcreator.core.application.configuration.boot.BootMode;
import eu.electricfrog.projectcreator.core.application.configuration.permissions.Permission;
import eu.electricfrog.projectcreator.core.application.configuration.permissions.Permissions;
import eu.electricfrog.projectcreator.core.application.configuration.permissions.ProjectCreatorPermissions;

/**
 * Keep track of this application's configuration.
 * @author ScrapsBits
 * @since 1.1
 * @version 1.1
 */
public class ProjectCreatorConfiguration implements Configuration {
	/**
	 * Get information about the various boot options.
	 */
	private final Boot boot;
	/**
	 * Keep track of the application's active permissions.
	 */
	private final Permissions permissions;
	
	/**
	 * Initialize the configurator.
	 */
	public ProjectCreatorConfiguration() {
		this.boot = new ProjectCreatorBoot();
		this.permissions = new ProjectCreatorPermissions();
	}

	@Override
	public BootMode getBootMode() {
		return boot.getBootMode(); 
	}

	@Override
	public Permission[] getPermissions() {
		return permissions.getPermissions();
	}

	@Override
	public boolean hasPermission(Permission permission) {
		return permissions.hasPermission(permission);
	}
}
