package main.ui.enumerations;

/**
 * Define the boot mode of the application.
 *
 * @author ScrapsBits
 */
public enum BootMode {
	/**
	 * The default boot mode. This must be defined upon boot.
	 */
	DEFAULT,
	/**
	 * The normal boot mode. This will launch everything as "normal".
	 */
	NORMAL,
	/**
	 * Safe boot mode. Risk-y or dependent elements and actions will not be accepted.
	 */
	SAFE,
	/**
	 * Development boot mode. Generally used for testing and development code.
	 */
	DEVELOPMENT;
}
