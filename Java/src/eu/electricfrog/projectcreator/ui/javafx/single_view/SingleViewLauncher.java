package eu.electricfrog.projectcreator.ui.javafx.single_view;

import java.util.ArrayList;
import java.util.List;

import eu.electricfrog.projectcreator.core.application.Application;
import eu.electricfrog.projectcreator.core.models.ProgrammingLanguageType;
import eu.electricfrog.projectcreator.ui.javafx.JavaFXLauncher;
import eu.electricfrog.projectcreator.ui.javafx.single_view.models.ObservableProgrammingLanguage;
import javafx.stage.Stage;

/**
 * Launch a JavaFX application with the SingleView user interface.
 *
 * @author  ScrapsBits
 * @since 1.0
 * @version 1.1
 */
public final class SingleViewLauncher extends JavaFXLauncher {

	/**
	 * Launch the SingleViewLauncher user interface for the application. This function starts a new thread for the JavaFX user interface, which may run separately from any other thread.
	 */
	public static void launch() { javafx.application.Application.launch(); }

	/**
	 * Initialize the user interface and link it to a new instance of the SingleViewController.
	 */
	public SingleViewLauncher() { super(new SingleViewController()); }

	/**
	 * Performs actions required to properly display the user interface.
	 */
	@Override
	public void start(final Stage stage) {
		final SingleViewController controller = (SingleViewController)super.getController();
		System.out.println("Loading in user interface."); // TODO: Replace with log component.
		controller.setStage(stage);
		stage.setMinWidth(471);
		stage.setMinHeight(290);
		stage.setWidth(700);
		stage.setHeight(300);
		System.out.println("Loaded user interface successfully."); // TODO: Replace with log component.

		controller.initialize(); // Generate elements onto the user interface.

		System.out.println("Displaying user interface."); // TODO: Replace with log component
		stage.setTitle(Application.getName());
		stage.sizeToScene();
		stage.show();
		stage.centerOnScreen();
		System.out.println("User interface displayed."); // TODO: Replace with log component.

		// TODO: Load in various data sets and display them on the controller.
		// TODO: Move this to a more appropriate location.
		final List<ObservableProgrammingLanguage> availableLanguages = new ArrayList<>();
		availableLanguages.add(new ObservableProgrammingLanguage("C#", "7.3", ProgrammingLanguageType.OBJECT_ORIENTED));
		availableLanguages.add(new ObservableProgrammingLanguage("PHP", "7.0.0", ProgrammingLanguageType.FUNCTIONAL));
		availableLanguages.add(new ObservableProgrammingLanguage("Java", "11", ProgrammingLanguageType.OBJECT_ORIENTED));
		for(ObservableProgrammingLanguage checkableLanguage : availableLanguages) {
			checkableLanguage.getObservableProperty().addListener((one, two, three) -> controller.onLanguageCheck(checkableLanguage));
		}
		controller.fillAvailableLanguages(availableLanguages);
	}
}
