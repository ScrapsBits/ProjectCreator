package main.ui;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Set;

import main.ui.enumerations.BootMode;

/**
 * Store all boot modes supported by the application.
 * @author ScrapsBits
 */
public class BootModule {
	/**
	 * Store all boot modes in a HashMap. HashMap is faster than a normal ArrayList.
	 */
	private final HashMap<String, BootMode> bootMode;
	
	/**
	 * Initialize the boot mode.
	 */
	public BootModule() {
		this(new HashMap<>());
	}
	
	public BootModule(HashMap<String, BootMode> bootModes) {
		this.bootMode = bootModes;
	}
	
	/**
	 * Get the correct boot mode, that contains the given command.
	 * @param command The command given at launch.
	 * @return Returns the boot mode.
	 * @throws IllegalArgumentException Thrown when the command is not specified properly.
	 */
	public BootMode getBootMode(String command) {
		BootMode bootMode = this.bootMode.get(command);
		if(bootMode == null) throw new IllegalArgumentException("The given command is not supported.");
		return bootMode;
	}
	
	/**
	 * Check if the boot mode command is supported.
	 * @param command The command given at launch.
	 * @return Returns true if the command is supported. Returns false if the command is unknown.
	 */
	public boolean hasCommand(String command) {
		return this.bootMode.containsKey(command);
	}
	
	/**
	 * Add a new boot mode to the list.
	 * @param command The command with which the boot mode is called.
	 * @param bootMode The boot mode called with the given command. Can be duplicate.
	 * @throws IllegalArgumentException Thrown when the command or boot mode is not set properly.
	 */
	public void addBootCommand(String command, BootMode bootMode) {
		if(command == null || command.isEmpty()) throw new IllegalArgumentException("The given command cannot be empty.");
		if(bootMode == null) throw new IllegalArgumentException("BootMode not specified.");
		this.bootMode.put(command, bootMode);
	}
	
	/**
	 * Get a string array of all supported commands.
	 * @return Returns a string array of all commands added to the boot module.
	 */
	public String[] getAllCommands() {
		Set<String> keys = this.bootMode.keySet();
		return Arrays.copyOf(keys.toArray(), keys.size(), String[].class);
	}
}
