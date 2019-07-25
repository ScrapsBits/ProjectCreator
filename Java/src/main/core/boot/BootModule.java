package main.core.boot;

import main.core.boot.commands.SupportedBootCommands;
import main.ui.enumerations.BootMode;

/**
 * Store all boot modes supported by the application.
 * 
 * @author ScrapsBits
 */
public final class BootModule {
	private final ISupportedBootCommands supportedBootCommands;
	private final BootMode defaultBootMode = BootMode.DEVELOPMENT;
	private BootMode bootMode = defaultBootMode;
	private boolean isDefault = true;

	/**
	 * Initialize the boot mode.
	 */
	public BootModule() {
		this.supportedBootCommands = new SupportedBootCommands();

		this.supportedBootCommands.addBootCommand("default", this.defaultBootMode);
		this.supportedBootCommands.addBootCommand("normal", BootMode.NORMAL);
		this.supportedBootCommands.addBootCommand("safe", BootMode.SAFE);
		this.supportedBootCommands.addBootCommand("safemode", BootMode.SAFE);
		this.supportedBootCommands.addBootCommand("development", BootMode.DEVELOPMENT);
	}
	
	public final void setBootMode(String[] bootCommands) {
		try {
			String selectedBootCommand = null;
			for(final String bootCommand : bootCommands) {
				if(this.supportsCommand(bootCommand)) {
					
					if(selectedBootCommand != null) throw new IllegalArgumentException("Too many boot mode arguments have been provided.");
					selectedBootCommand = bootCommand;
				}
			}
			if(selectedBootCommand == null) throw new IllegalArgumentException("No boot mode arguments have been provided."); // TODO: Replace with log component.
			this.setBootMode(selectedBootCommand);
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage() + " Applying default boot mode."); // TODO: Replace with log component.
		} finally {
			if(this.isDefault()) System.out.println("Default boot mode is " + this.getDefaultBootMode() + "."); // TODO: Replace with log component.
			System.out.println("Launching app in " + this.getCurrentBootMode() + " boot mode."); // TODO: Replace with log component.
		}
	}

	/**
	 * Get the currently selected boot mode.
	 * 
	 * @return Returns the boot mode used by the application to start.
	 */
	public final BootMode getCurrentBootMode() { return this.bootMode; }

	/**
	 * Check if the default value has been changed.
	 * 
	 * @return Returns true if the value has not been changed from the default. Returns false if the boot mode has changed from the default value, even if it has been set to the original value.
	 */
	public final boolean isDefault() { return this.isDefault; }

	/**
	 * Get the default boot mode.
	 * 
	 * @return Returns the default boot mode.
	 */
	public final BootMode getDefaultBootMode() { return this.defaultBootMode; }

	/**
	 * Check if the boot mode command is supported.
	 * 
	 * @param  command The command given at launch.
	 * @return         Returns true if the command is supported. Returns false if the command is unknown.
	 */
	public final boolean supportsCommand(String command) { return this.supportedBootCommands.hasBootCommand(command); }

	/**
	 * Set the selected boot mode based on the provided boot command.
	 * 
	 * @param  command                  The boot mode command used by the application to start.
	 * @throws IllegalArgumentException Thrown when the boot mode command is not recognized.
	 */
	public final void setBootMode(String command) throws IllegalArgumentException {
		if(command == null || command.isEmpty() || !supportsCommand(command)) throw new IllegalArgumentException("The provided command is not recognized.");
		this.isDefault = false;
		System.out.println("Setting boot mode to " + (this.bootMode = this.supportedBootCommands.getBootMode(command)) + ".");
	}
}
