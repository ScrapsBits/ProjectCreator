package eu.electricfrog.projectcreator.core.application.configuration.permissions;

import java.util.HashMap;
import java.util.HashSet;

import eu.electricfrog.projectcreator.core.application.configuration.boot.BootMode;

/**
 * Assign default permissions to each BootMode.
 * @author ScrapsBits
 * @since 1.1
 * @version 1.1
 */
class PermissionSets {
	/**
	 * Define a list to link permissions to the boot modes.
	 */
	private final HashMap<BootMode, HashSet<Permission>> permissionSet;
	/**
	 * Initialize the list with all permissions.
	 */
	PermissionSets() {
		this.permissionSet = new HashMap<>();
		this.setPermissions();
	}
	/**
	 * Fill the list with boot modes and their permissions.
	 */
	private final void setPermissions() {
		for(BootMode bootMode : BootMode.values()) {
			final HashSet<Permission> permissions = new HashSet<>();
			switch(bootMode) {
				case NORMAL:
					permissions.add(Permission.FILE_READ_WRITE);
					break;
				case SAFE:
					// TODO: Decide which permissions will be given to SAFE mode.
					break;
				case DEVELOPMENT:
					permissions.add(Permission.FILE_READ_WRITE);
					break;
			}
			this.permissionSet.put(bootMode, permissions);
		}
	}
	
	/**
	 * Get all permissions for the provided boot mode.
	 * @param bootMode The boot mode linked to the permissions requested.
	 * @return Returns a HashSet of all permissions linked to the boot mode.
	 */
	public HashSet<Permission> getPermissions(BootMode bootMode) {
		return permissionSet.get(bootMode);
	}
}
