package main.ui;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

import main.ui.enumerations.BootMode;

/**
 * Store all boot modes supported by the application.
 * @author ScrapsBits
 */
public final class BootModule {
	/**
	 * Store all boot modes in a HashMap. HashMap is faster than a normal ArrayList.
	 */
	private final HashMap<String, BootMode> bootModes;
	private BootMode bootMode;
	private final BootMode defaultBootMode;
	
	/**
	 * Initialize the boot mode.
	 */
	public BootModule() {
		this(new HashMap<>());
	}
	
	/**
	 * Initialize the boot mode with the given commands.
	 * @param bootModes A HashMap of commands, linked with a specific boot mode.
	 */
	public BootModule(HashMap<String, BootMode> bootModes) {
		if(bootModes == null) bootModes = new HashMap<>();
		this.bootModes = bootModes;
		
		this.defaultBootMode = BootMode.DEVELOPMENT;
		this.bootMode = this.defaultBootMode;
		
		addBootCommand("default", this.defaultBootMode);
		addBootCommand("normal", BootMode.NORMAL);
		addBootCommand("safe", BootMode.SAFE);
		addBootCommand("safemode", BootMode.SAFE);
		addBootCommand("development", BootMode.DEVELOPMENT);
	}
	
	/**
	 * Check if the current boot mode is the default value.
	 * @return Returns true if the boot mode is set to DEFAULT or to the same value as the default.
	 */
	public final boolean isDefault() {
		return (this.bootMode.equals(this.defaultBootMode));
	}
	
	/**
	 * Add a new boot mode to the list.
	 * @param command The command with which the boot mode is called.
	 * @param bootMode The boot mode called with the given command. Can be duplicate.
	 * @throws IllegalArgumentException Thrown when the command or boot mode is not set properly.
	 */
	public final void addBootCommand(String command, BootMode bootMode) {
		if(command == null || command.isEmpty()) throw new IllegalArgumentException("The given command cannot be empty.");
		if(bootMode == null) throw new IllegalArgumentException("BootMode not specified.");
		this.bootModes.put(command, bootMode);
	}
	/**
	 * Get an array of all supported boot modes.
	 * @return Returns a BootMode array.
	 */
	public final BootMode[] getAllBootModes() {
		Collection<BootMode> values = this.bootModes.values();
		return Arrays.copyOf(values.toArray(), values.size(), BootMode[].class);
	}
	/**
	 * Get a string array of all supported commands.
	 * @return Returns a string array of all commands added to the boot module.
	 */
	public final String[] getAllCommands() {
		Set<String> keys = this.bootModes.keySet();
		return Arrays.copyOf(keys.toArray(), keys.size(), String[].class);
	}
	
	/**
	 * Get the correct boot mode from the given command.
	 * @param command The command given at launch.
	 * @return Returns the boot mode.
	 * @throws IllegalArgumentException Thrown when the boot mode command is recognized.
	 */
	public final BootMode getBootMode(String command) {
		if(!this.hasCommand(command)) throw new IllegalArgumentException("The given command is not supported.");
		return this.bootModes.get(command);
	}
	
	/**
	 * Get the currently selected boot mode.
	 * @return Returns the boot mode used by the application to start.
	 */
	public final BootMode getCurrentBootMode() { return this.bootMode; }
	
	/**
	 * Get the default boot mode.
	 * @return Returns the default boot mode.
	 */
	public final BootMode getDefaultBootMode() { return this.defaultBootMode; }
	
	/**
	 * Check if the boot mode command is supported.
	 * @param command The command given at launch.
	 * @return Returns true if the command is supported. Returns false if the command is unknown.
	 */
	public final boolean hasCommand(String command) {
		return this.bootModes.containsKey(command);
	}
	
	/**
	 * Check if the boot mode is supported.
	 * @param bootMode The boot mode to check if it's supported.
	 * @return Returns true if the boot mode is supported. Returns false if the boot mode is unknown.
	 */
	public final boolean hasBootMode(BootMode bootMode) {
		return this.bootModes.containsValue(bootMode);
	}
	
	/**
	 * Set the selected boot mode.
	 * @param value The boot mode used by the application to start.
	 * @throws IllegalArgumentException Thrown when the boot mode is unclear.
	 */
	public final void setBootMode(BootMode value) throws IllegalArgumentException {
		if(value == null) throw new IllegalArgumentException("The boot mode cannot be null.");
		this.bootMode = value;
	}
	
	/**
	 * Set the selected boot mode based on the provided boot command.
	 * @param command The boot mode command used by the application to start.
	 * @throws IllegalArgumentException Thrown when the boot mode command is not recognized.
	 */
	public final void setBootMode(String command) throws IllegalArgumentException {
		if(command == null || command.isEmpty() || !hasCommand(command)) throw new IllegalArgumentException("The provided command is not recognized.");
		System.out.println("Setting boot mode to " + (this.bootMode = this.bootModes.get(command)) + ".");
	}
}
