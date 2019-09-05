package eu.electricfrog.projectcreator.core.application.permissions;

/**
 * Defines a permission for the application. This does not necessarily match the system permissions.
 *
 * @author  ScrapsBits
 * @since   1.0
 * @version 1.0
 */
public enum Permission {
	/**
	 * Allow the application to read a file from the system memory.
	 */
	FILE_READ,
	/**
	 * Allow the application to write a file to the system memory.
	 */
	FILE_WRITE,
	/**
	 * Allow the application to read a file from the system memory and to write a file to the system memory.
	 */
	FILE_READ_WRITE;
	// TODO: Add a permission for Internet connectivity.
	// TODO: Add a permission for automated application updates. (Requires Internet connection permission)
}
