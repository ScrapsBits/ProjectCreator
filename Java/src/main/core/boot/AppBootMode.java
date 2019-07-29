package main.core.boot;

import main.core.boot.enums.AppPermission;
import main.core.boot.enums.BootMode;

/**
 * Manage various aspects of the booting process of the application.
 *
 * @author ScrapsBits
 */
public interface AppBootMode {
	/**
	 * Get the boot mode currently used by the application.
	 *
	 * @return Returns a value of the BootMode enumeration representing the current boot mode status.
	 */
	BootMode getBootMode();

	/**
	 * Get the default boot mode.
	 *
	 * @return Returns a value of the BootMode enumeration representing the default boot mode.
	 */
	BootMode getDefaultBootMode();

	/**
	 * Get an array of values of the AppPermissions enumeration used to define what permissions the current boot mode has.
	 *
	 * @return Returns an array of the values of the AppPermissions enumeration containing all allowed application permissions.
	 */
	AppPermission[] getPermissions();

	/**
	 * Verify if the given permission is allowed by the current boot mode.
	 *
	 * @param  permission The permission requested to being allowed.
	 * @return            Returns true if the requested permission is allowed. Returns false if the permission provided is not allowed by the current boot mode.
	 */
	boolean isAllowed(AppPermission permission);

	/**
	 * Verify if the default boot mode is currently being used.
	 *
	 * @return Returns true if the application is launching in the default boot mode. Returns false if the application launches in another boot mode.
	 */
	boolean isDefault();

	/**
	 * Verify if the application supports the provided command.
	 *
	 * @param  command The command used by any boot mode to represent the application boot mode.
	 * @return         Returns true if the command is used by the application. Returns false if the command is not supported.
	 */
	boolean supportsCommand(String command);
}
