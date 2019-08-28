package eu.electricfrog.projectcreator.core.application.permissions;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

import eu.electricfrog.projectcreator.ApplicationLauncher;
import eu.electricfrog.projectcreator.core.application.boot.BootMode;

/**
 * Keep track of all permissions linked to certain boot modes.
 *
 * @author  ScrapsBits
 * @version 1.0
 */
public class ProjectCreatorPermissions implements ApplicationPermissions {
	/**
	 * For each boot mode, keep track of their permissions in a fast-accessible set.
	 */
	private final HashMap<BootMode, HashSet<Permission>> permissionSet;
	// TODO: Add "active permissions" list.
	// TODO: Add "Add permissions" to "active permissions" list.
	// TODO: Add "Remove permissions" to "active permissions" list.

	/**
	 * Fill the permissions currently supported by the application.
	 */
	public ProjectCreatorPermissions() {
		this.permissionSet = new HashMap<>();
		this.addDevelopmentPermissions();
		this.addNormalPermissions();
		this.addSafePermissions();
	}

	/**
	 * Add permissions to the DEVELOPMENT boot mode.
	 */
	private final void addDevelopmentPermissions() {
		final HashSet<Permission> permissions = new HashSet<>();
		permissions.add(Permission.FILE_READ_WRITE);
		this.permissionSet.put(BootMode.DEVELOPMENT, permissions);
	}

	/**
	 * Add permissions to the NORMAL boot mode.
	 */
	private final void addNormalPermissions() {
		final HashSet<Permission> permissions = new HashSet<>();
		permissions.add(Permission.FILE_READ_WRITE);
		this.permissionSet.put(BootMode.NORMAL, permissions);
	}

	/**
	 * Add permissions to the SAFE boot mode.
	 */
	private final void addSafePermissions() {
		final HashSet<Permission> permissions = new HashSet<>();
		this.permissionSet.put(BootMode.SAFE, permissions);
	}

	@Override
	public final Permission[] getPermissions() {
		// TODO: Empty permissions check.
		// TODO: If the BootMode isn't set in the constructor, throw an exception.
		final BootMode bootMode = ApplicationLauncher.manager().boot().getBootMode();
		return Arrays.copyOf(this.permissionSet.get(bootMode).toArray(), this.permissionSet.get(bootMode).size(), Permission[].class);
	}

	@Override
	public final boolean hasPermission(final Permission permission) {
		for(final Permission perm : this.permissionSet.get(ApplicationLauncher.manager().boot().getBootMode())) if(perm.equals(permission)) return true;
		return false;
	}
}
