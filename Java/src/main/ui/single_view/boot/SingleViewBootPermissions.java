package main.ui.single_view.boot;

import java.util.Arrays;
import java.util.HashMap;

import main.ProjectCreator;
import main.core.boot.AppBootPermissions;
import main.core.boot.enums.AppPermission;
import main.core.boot.enums.BootMode;

/**
 * A class to link supported boot modes to permissions.
 *
 * @author ScrapsBits
 */
public class SingleViewBootPermissions implements AppBootPermissions {
	/**
	 * Keep a link between a boot mode and its permissions.
	 */
	private final HashMap<BootMode, AppPermission[]> bootPermissions;

	/**
	 * Initialize a new Boot Permissions object.
	 */
	public SingleViewBootPermissions() { this.bootPermissions = new HashMap<>(); }

	/**
	 * Add a permission to a boot mode.
	 *
	 * @param bootMode      The boot mode that receives a new permission.
	 * @param appPermission The permission granted to the boot mode.
	 */
	@Override
	public void addBootPermission(final BootMode bootMode, final AppPermission appPermission) {
		AppPermission[] permissions;
		if(this.bootPermissions.containsKey(bootMode)) {
			final AppPermission[] existingPermissions = this.bootPermissions.get(bootMode);
			permissions = new AppPermission[existingPermissions.length + 1];
			permissions[existingPermissions.length] = appPermission;
		} else
			permissions = new AppPermission[] {
					appPermission
			};
		this.bootPermissions.put(bootMode, permissions);
	}

	@Override
	public AppPermission[] getAppPermissions(final BootMode bootMode) { return this.bootPermissions.get(bootMode); }

	@Override
	public boolean isAllowed(final AppPermission permission) {
		// If the permission requested is read or write, check if it's covered by FILE_READ_WRITE or its regular value.
		if(AppPermission.FILE_READ.equals(permission) || AppPermission.FILE_WRITE.equals(permission)) {
			return Arrays.stream(this.bootPermissions.get(ProjectCreator.BOOT.getBootMode())).anyMatch((checkPermission) -> checkPermission.equals(permission) || checkPermission.equals(AppPermission.FILE_READ_WRITE));
		}
		return Arrays.stream(this.bootPermissions.get(ProjectCreator.BOOT.getBootMode())).anyMatch(permission::equals); }
}
