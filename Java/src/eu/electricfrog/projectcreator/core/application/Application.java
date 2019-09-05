package eu.electricfrog.projectcreator.core.application;

import eu.electricfrog.projectcreator.core.application.configuration.Configuration;
import eu.electricfrog.projectcreator.core.application.configuration.ProjectCreatorConfiguration;
import eu.electricfrog.projectcreator.core.application.configuration.boot.BootMode;
import eu.electricfrog.projectcreator.core.application.configuration.permissions.Permission;
import eu.electricfrog.projectcreator.core.application.data.Data;
import eu.electricfrog.projectcreator.core.application.data.ProjectCreatorData;

/**
 * A manager class keeping track of all application related information.
 *
 * @author  ScrapsBits
 * @since   1.1
 * @version 1.1
 */
public class Application {
	/**
	 * A Singleton reference to itself.
	 */
	private static Application application;
	/**
	 * A Singleton reference to the configuration instance.
	 */
	private static Configuration configuration;

	/**
	 * Get the application class instance. If none exists, it creates one.
	 *
	 * @return Returns a single instance of the Application class.
	 */
	private static final Application application() {
		if(Application.application == null) Application.application = new Application();
		return Application.application;
	}

	/**
	 * Get the application's boot mode.
	 *
	 * @return Returns the active boot mode of the application.
	 */
	public static final BootMode bootMode() { return Application.application().configuration().getBootMode(); }

	/**
	 * Get the copyright owner of the application.
	 *
	 * @return Returns the name of the owner of the copyright for this application.
	 */
	public static final String getCopyright() { return Application.application().data().getCopyright(); }

	/**
	 * Get the name of the application.
	 *
	 * @return Returns the name of the application.
	 */
	public static final String getName() { return Application.application().data().getName(); }

	/**
	 * Get the permissions granted to the application.
	 *
	 * @return Returns an array of all permissions
	 */
	public static final Permission[] getPermissions() { return Application.application().configuration().getPermissions(); }

	/**
	 * Get the version number of the application.
	 *
	 * @return Returns a string with the version number of the application in its current state.
	 */
	public static final String getVersion() { return Application.application().data().getVersion(); }

	/**
	 * Verify if the application runs with a specific permission.
	 *
	 * @param  permission The permission tested.
	 * @return            Returns true if the application has been granted the specified permission, otherwise false.
	 */
	public static final boolean hasPermission(final Permission permission) { return Application.application().configuration().hasPermission(permission); }

	/**
	 * A hidden constructor, used to create a Singleton instance of this class.
	 */
	private Application() {}

	/**
	 * Get an instance of the application configuration.
	 * @return Returns a consistent instance keeping track of application configuration.
	 */
	private final Configuration configuration() {
		if(configuration == null) {
			configuration = new ProjectCreatorConfiguration();
		}
		return configuration;
	}

	/**
	 * Get an instance of the application data.
	 *
	 * @return Returns a temporary instance keeping track of the application data.
	 */
	private final Data data() { return new ProjectCreatorData(); }
}
