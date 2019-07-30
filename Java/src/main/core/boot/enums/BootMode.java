package main.core.boot.enums;

/**
 * Define the boot mode of the application.
 *
 * @author ScrapsBits
 */
public enum BootMode {
	/**
	 * Development boot mode. Generally used for testing and development code. Should not appear in released code.
	 */
	DEVELOPMENT,
	/**
	 * The normal boot mode. This will launch everything as "normal".
	 */
	NORMAL,
	/**
	 * Similar to normal boot mode, but without using Internet connections.
	 */
	OFFLINE,
	/**
	 * Safe boot mode. Risk-y or system dependent elements and actions will not be accepted.
	 */
	SAFE;
}
