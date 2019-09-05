package eu.electricfrog.projectcreator.ui;

/**
 * Define values that are important for all user interfaces.
 *
 * @author  ScrapsBits
 * @since   1.0
 * @version 1.0
 */
public abstract class GenericController {
	/**
	 * Perform generic functions while the application is booting up.
	 */
	protected GenericController() {
		// TODO: Perform start-up processes related to the business layer of the application. This may include loading in the configuration file.
		System.out.println("Performing start-up processes.");
	}
}
