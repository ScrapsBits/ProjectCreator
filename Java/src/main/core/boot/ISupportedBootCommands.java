package main.core.boot;

import main.ui.enumerations.BootMode;

/**
 * Manage all boot commands.
 * @author ScrapsBits
 */
public interface ISupportedBootCommands {
	/**
	 * Add a new boot command to the application.
	 * @param command The command used to run the application in the provided boot mode.
	 * @param bootMode Defines which boot mode the application must run in.
	 */
	void addBootCommand(String command, BootMode bootMode);
	/**
	 * Get a collection of all boot modes linked to a command.
	 * @return
	 */
	BootMode[] getAllBootModes();
	/**
	 * Get a collection of all supported commands.
	 * @return Returns a string array of all commands supported by the application.
	 */
	String[] getAllCommands();
	/**
	 * Get the boot mode linked to the given command.
	 * @param command The command linked to the requested boot mode.
	 * @return Returns the boot mode linked to the given command.
	 */
	BootMode getBootMode(String command);
	/**
	 * Get a collection of supported commands linked to the provided boot mode.
	 * @param bootMode The boot mode called on by the requested commands.
	 * @return returns a string array of all commands related to the provided boot mode.
	 */
	String[] getCommands(BootMode bootMode);
	/**
	 * Check if the application supports the given command.
	 * @param command The command used to run the application in a specific boot mode.
	 * @return Returns true if the command is supported by th application. Returns false if the application does not support the command.
	 */
	boolean hasBootCommand(String command);
	/**
	 * Check if the application supports the given boot mode.
	 * @param bootMode Defines which boot mode the application must run in.
	 * @return Returns true if the boot mode is linked to at least one command. Returns false if the boot mode is not linked to any command.
	 */
	boolean hasBootMode(BootMode bootMode);
	/**
	 * Remove a command from the list of commands supported by the application.
	 * @param command The command to be removed from the application boot.
	 */
	void removeBootCommand(String command);
	/**
	 * Remove all commands related to the provided boot mode from the list of commands supported by the application.
	 * @param bootMode The boot mode related to the boot commands that will be removed from the list of commands supported by the application.
	 */
	void removeBootMode(BootMode bootMode);
}
