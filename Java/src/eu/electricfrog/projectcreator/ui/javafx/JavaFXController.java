package eu.electricfrog.projectcreator.ui.javafx;

import eu.electricfrog.projectcreator.ui.GenericController;
import javafx.stage.Stage;

/**
 * Define values that are important exclusively to JavaFX user interfaces.
 *
 * @author  ScrapsBits
 * @since 1.0
 * @version 1.0
 */
public abstract class JavaFXController extends GenericController {

	/**
	 * Hold a generator for the elements displayed on the user interface.
	 */
	protected JavaFXGenerator generator;
	/**
	 * JavaFX creates a stage for the user interface.
	 */
	protected Stage stage;

	/**
	 * Prepare actions and settings for the JavaFX application.
	 */
	protected JavaFXController() {
		super();
		// TODO: Perform start-up processes related to the business layer of the application.
	}

	/**
	 * Get the JavaFX user interface stage.
	 *
	 * @return Returns the stage reference of the JavaFX application.
	 */
	public final Stage getStage() { return this.stage; }

	/**
	 * Perform JavaFX initial functionality.
	 */
	public abstract void initialize();

	/**
	 * Set the stage used by the controller.
	 *
	 * @param stage The JavaFX stage.
	 */
	public final void setStage(final Stage stage) {
		// TODO: Set the stage ONLY if it hasn't been set yet.
		this.stage = stage;
	}

	/**
	 * Update the user interface elements.
	 */
	public abstract void update();
}
