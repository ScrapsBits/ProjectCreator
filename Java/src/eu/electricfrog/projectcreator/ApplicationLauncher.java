package eu.electricfrog.projectcreator;

import eu.electricfrog.projectcreator.core.application.ApplicationManager;
import eu.electricfrog.projectcreator.ui.javafx.single_view.SingleViewLauncher;

/**
 * Run the application.
 *
 * @author  ScrapsBits
 * @version 1.0
 */
public final class ApplicationLauncher {
	/**
	 * Holds the link between the user interface and the application's functionality.
	 */
	private static ApplicationManager manager; // TODO: Move this to the GenericController

	/**
	 * Launch the application. Launches the JavaFX SingleView user interface.
	 *
	 * @param args Console arguments that may be provided upon launch.
	 */
	public static void main(final String[] args) {
		ApplicationLauncher.manager = ApplicationManager.createManager(args);
		SingleViewLauncher.launch();
	}

	/**
	 * Expose the application manager to allow the application to read information.
	 *
	 * @return Returns the manager class of the application data.
	 */
	public static ApplicationManager manager() { return ApplicationLauncher.manager; }

}
