package main.core.boot.enums;

/**
 * Allows the application to scan for its permissions in certain boot modes.
 *
 * @author ScrapsBits
 */
public enum AppPermission {
	/**
	 * Allows the application to read files.
	 */
	FILE_READ,
	/**
	 * Allows the application to read and write files.
	 */
	FILE_READ_WRITE,
	/**
	 * Allows the application to write files.
	 */
	FILE_WRITE,
	/**
	 * Allows the application to connect to the Internet.
	 */
	INTERNET_CONNECTION;
}
