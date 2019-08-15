package eu.electricfrog.projectcreator.ui.javafx;

import javafx.application.Application;

/**
 * Launch a JavaFX application.
 *
 * @author  ScrapsBits
 * @version 1.0
 */
public abstract class JavaFXLauncher extends Application {

	/**
	 * The controller used by the application.
	 */
	private final JavaFXController controller;

	/**
	 * Initialize the launcher and use the provided controller.
	 * 
	 * @param controller The controller used by the application.
	 */
	public JavaFXLauncher(final JavaFXController controller) { this.controller = controller; }

	/**
	 * Get the controller used by the application.
	 * 
	 * @return Returns the controller used by the application.
	 */
	protected final JavaFXController getController() { return this.controller; }
}
