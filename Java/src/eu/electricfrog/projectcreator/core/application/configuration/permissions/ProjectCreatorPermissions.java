package eu.electricfrog.projectcreator.core.application.configuration.permissions;

import java.util.Arrays;
import java.util.List;

import eu.electricfrog.projectcreator.core.application.Application;

/**
 * Keep track of all permissions linked to certain boot modes.
 *
 * @author  ScrapsBits
 * @since   1.0
 * @version 1.1
 */
public class ProjectCreatorPermissions implements Permissions {
	private Permission[] activePermissions;
	// TODO: Add "Add permissions" to "active permissions" list.
	// TODO: Add "Remove permissions" to "active permissions" list.

	/**
	 * Fill the permissions currently supported by the application.
	 */
	public ProjectCreatorPermissions() {
		Object[] permissions = new PermissionSets().getPermissions(Application.bootMode()).toArray();
		this.activePermissions = Arrays.copyOf(permissions, permissions.length, Permission[].class);
	}
	
	/**
	 * Add a permission to the application's active permissions.
	 * @param permission This permission is added to the application's active permissions.
	 */
	public final void addPermission(Permission permission) {
		if(permission != null) {
			this.activePermissions = Arrays.copyOf(Arrays.asList(this.activePermissions, permission).toArray(), this.activePermissions.length, Permission[].class);
		}
	}
	
	/**
	 * Remove a permission from the application's active permissions.
	 * @param permission This permission is removed from the application's active permissions.
	 */
	public final void removePermission(Permission permission) {
		if(permission != null) {
			List<Permission> permissions = Arrays.asList(this.activePermissions);
			permissions.remove(permission);
			this.activePermissions = Arrays.copyOf(permissions.toArray(), this.activePermissions.length - 1, Permission[].class);
		}
	}

	@Override
	public final Permission[] getPermissions() { return this.activePermissions; }

	@Override
	public final boolean hasPermission(final Permission permission) {
		for(Permission perm : this.activePermissions) {
			if(permission.equals(perm)) { return true; }
		}
		return false;
	}
}
