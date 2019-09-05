package eu.electricfrog.projectcreator.core.application.configuration.permissions;

/**
 * Keep track of the permissions given to the current ApplicationBoot.
 *
 * @author  ScrapsBits
 * @since   1.0
 * @version 1.0
 */
public interface Permissions {
	/**
	 * Get an array of all permissions with the application's boot mode.
	 *
	 * @return Returns an array of all granted permissions.
	 */
	Permission[] getPermissions();

	/**
	 * Check if the application is allowed to use the provided permission.
	 *
	 * @param  permission The permission to verify.
	 * @return            Returns true if the application is allowed to use the permission. Otherwise, returns false.
	 */
	boolean hasPermission(Permission permission);
}
