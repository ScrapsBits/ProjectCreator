package main.core.boot;

import main.core.boot.enums.AppPermission;
import main.core.boot.enums.BootMode;

public abstract class BootModeManager implements AppBootMode {
	private BootMode bootMode;
	private final BootMode defaultBootMode;
	private boolean isDefault;

	protected BootModeManager() {
		this.defaultBootMode = BootMode.DEVELOPMENT;
		this.bootMode = this.defaultBootMode;
		this.isDefault = true;
	}

	/**
	 * Add a new boot mode to the application.
	 *
	 * @param bootMode    The boot mode added to the application.
	 * @param commands    All console arguments accepted to run the provided boot mode.
	 * @param permissions All permissions the new boot mode will have.
	 */
	protected abstract void addBootMode(BootMode bootMode, String[] commands, AppPermission[] permissions);

	@Override
	public final BootMode getBootMode() { return this.bootMode; }

	@Override
	public final BootMode getDefaultBootMode() { return this.defaultBootMode; }

	@Override
	public final boolean isDefault() { return this.isDefault; }

	/**
	 * Set the boot mode to the provided mode.
	 *
	 * @param bootMode The boot mode to be used by the application.
	 */
	public final void setBootMode(final BootMode bootMode) {
		if(!this.isDefault) throw new IllegalArgumentException("Cannot change the boot mode more than once.");
		System.out.println("Setting application boot mode to " + bootMode + ".");
		this.isDefault = false;
		this.bootMode = bootMode;
	}
}
