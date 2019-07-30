package main.ui.single_view.boot;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;

import main.core.boot.AppBootCommands;
import main.core.boot.enums.BootMode;

/**
 * A class to link boot commands to supported boot modes.
 *
 * @author ScrapsBits
 */
public final class SingleViewBootCommands implements AppBootCommands {
	/**
	 * Keep a link between a boot command and its corresponding boot mode.
	 */
	private final HashMap<String, BootMode> bootCommands;

	public SingleViewBootCommands() { this.bootCommands = new HashMap<>(); }

	@Override
	public void addBootCommand(final String command, final BootMode bootMode) { this.bootCommands.put(command, bootMode); }

	@Override
	public BootMode[] getAllBootModes() {
		final Collection<BootMode> values = this.bootCommands.values();
		return Arrays.copyOf(values.toArray(), values.size(), BootMode[].class);
	}

	@Override
	public String[] getAllCommands() {
		final Collection<String> keys = this.bootCommands.keySet();
		return Arrays.copyOf(keys.toArray(), keys.size(), String[].class);
	}

	@Override
	public BootMode getBootMode(final String command) { return this.bootCommands.get(command); }

	@Override
	public int getBootModeCount() { return this.bootCommands.values().size(); }

	@Override
	public int getCommandCount() { return this.bootCommands.keySet().size(); }

	@Override
	public int getCommandCount(final BootMode bootMode) {
		int i = 0;
		for(final String key : this.bootCommands.keySet()) if(this.bootCommands.get(key).equals(bootMode)) i += 1;
		return i;
	}

	@Override
	public String[] getCommands(final BootMode bootMode) {
		final HashSet<String> keys = new HashSet<>();
		for(final String key : this.bootCommands.keySet()) if(this.bootCommands.get(key).equals(bootMode)) keys.add(key);
		return Arrays.copyOf(keys.toArray(), keys.size(), String[].class);
	}

	@Override
	public boolean hasBootCommand(final String command) { return this.bootCommands.containsKey(command); }

	@Override
	public boolean hasBootMode(final BootMode bootMode) { return this.bootCommands.containsValue(bootMode); }

	@Override
	public void removeBootCommand(final String command) { this.bootCommands.remove(command); }

	@Override
	public void removeBootMode(final BootMode bootMode) { for(final String key : this.bootCommands.keySet()) if(this.bootCommands.get(key).equals(bootMode)) this.bootCommands.remove(key); }
}
