package eu.electricfrog.projectcreator.core.application;

import eu.electricfrog.projectcreator.core.application.boot.ApplicationBoot;
import eu.electricfrog.projectcreator.core.application.data.ApplicationData;
import eu.electricfrog.projectcreator.core.application.data.system.SystemData;
import eu.electricfrog.projectcreator.core.application.permissions.ApplicationPermissions;

/**
 * Keep track of various aspects of the application, such as boot mode or application permissions.
 *
 * @author  ScrapsBits
 * @version 1.0
 */
public interface ApplicationManager {
	/**
	 * Create a new instance of the ProjectCreatorManager class.
	 *
	 * @param  args Commands args.
	 * @return      Returns a new instance of the ProjectCreatorManager class.
	 */
	static ApplicationManager createManager(final String[] args) { return new ProjectCreatorManager(args); }

	/**
	 * Get the boot mode manager of the application.
	 *
	 * @return Returns the boot manager.
	 */
	ApplicationBoot boot();

	/**
	 * Get the data manager of the application.
	 *
	 * @return Returns the data manager.
	 */
	ApplicationData data();

	/**
	 * Get the permissions manager of the application.
	 *
	 * @return Returns the permissions manager.
	 */
	ApplicationPermissions permissions();
	
	/**
	 * Get information of the system the application is running on.
	 * @return Returns an object keeping track of system information.
	 */
	SystemData systemData();
}
