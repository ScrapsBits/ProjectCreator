package eu.electricfrog.projectcreator.core.application.data;

/**
 * Keep track of standard application data.
 *
 * @author  ScrapsBits
 * @since 1.0
 * @version 1.0
 */
public interface ApplicationData {
	/**
	 * Get the person who owns this application's copyright.
	 *
	 * @return Returns the name of the copyright owner.
	 */
	String getCopyright();

	/**
	 * Get the name held by the application.
	 *
	 * @return Returns the name of the application.
	 */
	String getName();

	/**
	 * Get the version number of the application.
	 *
	 * @return Returns a string containing the version number of the application.
	 */
	String getVersion();
}
