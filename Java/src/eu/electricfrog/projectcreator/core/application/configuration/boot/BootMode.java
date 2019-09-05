package eu.electricfrog.projectcreator.core.application.configuration.boot;

/**
 * Define in which way an application should start.
 *
 * @author  ScrapsBits
 * @since   1.0
 * @version 1.0
 */
public enum BootMode {
	/**
	 * Experimental version. This will be used for beta test releases as well as for internal development and testing.
	 */
	DEVELOPMENT,
	/**
	 * Launch the application as normal.
	 */
	NORMAL,
	/**
	 * Launch the application in safe mode. Safe mode reduces the application Permissions to the absolute minimum.
	 */
	SAFE;
	// TODO: Add OFFLINE boot mode.
	// TODO: Add COMPATIBILITY boot mode.
}
