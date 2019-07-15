package main.core.enumerations;

/**
 * Define the boot mode of the application.
 *
 * @author ScrapsBits
 */
public enum BootMode {
	/**
	 * The default boot mode. This must be defined upon boot.
	 */
	DEFAULT("default", "default"),
	/**
	 * The normal boot mode. This will launch everything as "normal".
	 */
	NORMAL("Normal", "", "normal"),
	/**
	 * Safe boot mode. Risk-y or dependent elements and actions will not be accepted.
	 */
	SAFE("Safe", "safe", "safemode"),
	/**
	 * Development boot mode. Generally used for testing and development code.
	 */
	DEVELOPMENT("Development", "development");

	/**
	 * The command(s) required for the mode to be launched.
	 */
	private String[] bootCommands;
	/**
	 * The name of the boot mode.
	 */
	private String bootName;

	/**
	 * Set the values related to the boot mode.
	 *
	 * @param bootName     The boot mode name.
	 * @param bootCommands All supported boot mode commands.
	 */
	private BootMode(final String bootName, final String... bootCommands) {
		this.bootName = bootName;
		this.bootCommands = bootCommands;
	}

	/**
	 * Get all accepted commands to launch the application in this boot mode.
	 *
	 * @return Returns a string array with all accepted boot mode commands.
	 */
	public String[] getBootCommands() { return bootCommands; }

	/**
	 * Get the boot mode name.
	 *
	 * @return Returns the name of the boot mode.
	 */
	public String getBootName() { return bootName; }
}
