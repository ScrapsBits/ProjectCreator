package main.core.boot;

import main.core.boot.enums.AppPermission;
import main.core.boot.enums.BootMode;

/**
 * Manage all boot permissions.
 *
 * @author ScrapsBits
 */
public interface AppBootPermissions {
	/**
	 * Add a new permission to the provided boot mode.
	 *
	 * @param bootMode   The boot mode altered.
	 * @param permission The permission added to the provided boot mode.
	 */
	void addBootPermission(BootMode bootMode, AppPermission permission);

	/**
	 * Get an array of all permissions with the current boot mode.
	 *
	 * @return Returns an array of all permissions linked to the provided boot mode.
	 */
	AppPermission[] getAppPermissions(BootMode bootMode);

	/**
	 * Verify if the provided permission is granted by the application.
	 *
	 * @param  permission The permission to be checked on validity.
	 * @return            Returns true if the application allows the provided permission. Returns false if the provided permission is not allowed.
	 */
	boolean isAllowed(AppPermission permission);
}
