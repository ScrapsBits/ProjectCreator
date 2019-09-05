package eu.electricfrog.projectcreator.core.application.configuration;

import eu.electricfrog.projectcreator.core.application.configuration.boot.BootMode;
import eu.electricfrog.projectcreator.core.application.configuration.permissions.Permission;

/**
 * Keep track of the current application configuration.
 * @author ScrapsBits
 * @since 1.1
 * @version 1.1
 */
public interface Configuration {
	/**
	 * Get the boot mode this application was launched in.
	 * @return Returns the application's current boot mode.
	 */
	BootMode getBootMode();
	/**
	 * Get the permissions granted to this application upon launch.
	 * @return Returns an array of permissions given to the application upon launch.
	 */
	Permission[] getPermissions();
	/**
	 * Check if the application was given the provided permission.
	 * @param permission This represents the permission requested by the application.
	 * @return Returns true if the application is running with the provided permission, otherwise false.
	 */
	boolean hasPermission(Permission permission);
}
