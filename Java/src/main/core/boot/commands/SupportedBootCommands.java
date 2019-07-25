package main.core.boot.commands;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import main.core.boot.ISupportedBootCommands;
import main.ui.enumerations.BootMode;

/**
 * A class to link boot commands to supported boot modes.
 * @author ScrapsBits
 */
public final class SupportedBootCommands implements ISupportedBootCommands {
	/**
	 * Keep a link between a boot command and its corresponding boot mode.
	 */
	private final HashMap<String, BootMode> bootCommands;
	
	public SupportedBootCommands() {
		this.bootCommands = new HashMap<>();
	}

	@Override
	public void addBootCommand(String command, BootMode bootMode) {
		this.bootCommands.put(command, bootMode);
	 }

	@Override
	public BootMode[] getAllBootModes() {
		return Arrays.copyOf(this.bootCommands.values().toArray(), this.bootCommands.values().size(), BootMode[].class);
	}

	@Override
	public String[] getAllCommands() { 
		return Arrays.copyOf(this.bootCommands.keySet().toArray(), this.bootCommands.keySet().size(), String[].class);
	}

	@Override
	public BootMode getBootMode(String command) {
		return this.bootCommands.get(command);
	}

	@Override
	public String[] getCommands(BootMode bootMode) {
		HashSet<String> keys = new HashSet<>();
		for(String key : this.bootCommands.keySet()) {
			if(this.bootCommands.get(key).equals(bootMode)) keys.add(key);
		}
		return Arrays.copyOf(keys.toArray(), keys.size(), String[].class);
	}

	@Override
	public boolean hasBootCommand(String command) {
		return this.bootCommands.containsKey(command);
	}

	@Override
	public boolean hasBootMode(BootMode bootMode) {
		return this.bootCommands.containsValue(bootMode);
	}

	@Override
	public void removeBootCommand(String command) {
		this.bootCommands.remove(command);
	 }

	@Override
	public void removeBootMode(BootMode bootMode) {
		for(String key : this.bootCommands.keySet()) {
			if(this.bootCommands.get(key).equals(bootMode)) this.bootCommands.remove(key);
		}
	 }
}
