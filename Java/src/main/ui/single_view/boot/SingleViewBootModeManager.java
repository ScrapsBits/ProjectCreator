package main.ui.single_view.boot;

import main.core.boot.AppBootCommands;
import main.core.boot.AppBootPermissions;
import main.core.boot.BootModeManager;
import main.core.boot.enums.AppPermission;
import main.core.boot.enums.BootMode;

/**
 * Store all boot modes supported by the application.
 *
 * @author ScrapsBits
 */
public final class SingleViewBootModeManager extends BootModeManager {
	private final AppBootCommands bootCommands;
	private final AppBootPermissions bootPermissions;

	/**
	 * Initialize the boot mode.
	 */
	public SingleViewBootModeManager() {
		super();
		this.bootCommands = new SingleViewBootCommands();
		this.bootPermissions = new SingleViewBootPermissions();

		this.addBootMode(super.getDefaultBootMode(), new String[] {
				"default "
		}, new AppPermission[] {}); // Default mode doesn't get additional permissions.
		this.addBootMode(BootMode.NORMAL, new String[] {
				"normal"
		}, new AppPermission[] {
				AppPermission.FILE_READ_WRITE, AppPermission.INTERNET_CONNECTION
		});
		this.addBootMode(BootMode.OFFLINE, new String[] {
				"offline"
		}, new AppPermission[] {
				AppPermission.FILE_READ_WRITE
		});
		this.addBootMode(BootMode.SAFE, new String[] {
				"safe", "safemode"
		}, new AppPermission[] {
				AppPermission.FILE_READ
		});
		this.addBootMode(BootMode.DEVELOPMENT, new String[] {
				"development"
		}, new AppPermission[] {
				AppPermission.FILE_READ_WRITE, AppPermission.INTERNET_CONNECTION
		});
	}

	@Override
	protected void addBootMode(final BootMode bootMode, final String[] commands, final AppPermission[] permissions) {
		for(final String command : commands) this.bootCommands.addBootCommand(command, bootMode);
		for(final AppPermission permission : permissions) this.bootPermissions.addBootPermission(bootMode, permission);
	}

	/**
	 * Get the boot mode linked to the provided command.
	 *
	 * @param  command The command used by a boot mode.
	 * @return         Returns the Boot Mode linked to the provided command.
	 */
	public BootMode getBootMode(final String command) { return this.bootCommands.getBootMode(command); }

	@Override
	public AppPermission[] getPermissions() { return this.bootPermissions.getAppPermissions(super.getBootMode()); }

	@Override
	public boolean isAllowed(final AppPermission permission) { return this.bootPermissions.isAllowed(permission); }

	@Override
	public boolean supportsCommand(final String command) { return this.bootCommands.hasBootCommand(command); }
}
