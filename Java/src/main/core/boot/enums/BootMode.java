package main.core.boot.enums;

/**
 * Define the boot mode of the application.
 *
 * @author ScrapsBits
 */
public enum BootMode {
	/**
	 * Development boot mode. Generally used for testing and development code.
	 */
	DEVELOPMENT,
	/**
	 * The normal boot mode. This will launch everything as "normal".
	 */
	NORMAL,
	/**
	 * Safe boot mode. Risk-y or system dependent elements and actions will not be accepted.
	 */
	SAFE;
}
