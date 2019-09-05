package eu.electricfrog.projectcreator.ui.javafx.single_view.language.java;

import eu.electricfrog.projectcreator.core.models.ProgrammingLanguage;
import eu.electricfrog.projectcreator.core.models.Project;
import eu.electricfrog.projectcreator.ui.javafx.single_view.language.LanguageController;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * The controller handling actions from the User Interface for the settings of the C# language.
 *
 * @author  ScrapsBits
 * @since   1.1
 * @version 1.1
 */
public final class JavaController extends LanguageController {
	/**
	 * The scene StackPane is the root element for the JavaFX user interface.
	 */
	AnchorPane acpScene;
	/**
	 * Buttons on the C# UI.
	 */
	Button btnSave, btnDirectory;
	/**
	 * Labels being displayed on the User Interface.
	 */
	Label lblName, lblDirectory, lblPackage;
	/**
	 * Text input fields.
	 */
	TextField txfName, txfDirectory, txfPackage;

	/**
	 * Load in the settings provided with the C# language.
	 *
	 * @param language The C# language object reference.
	 */
	public JavaController(final ProgrammingLanguage language) {
		super(language);
		if(!language.getName().contentEquals("Java")) throw new IllegalArgumentException("The provided language is not a Java language.");
		System.out.println("Start-up processes performed."); // TODO: Replace with log component.
	}

	/**
	 * Fill in the default values for the various input fields.
	 *
	 * @param project The project containing the values for the various input fields.
	 */
	// TODO: Replace Project with a generic language object, that holds these same values.
	public void fillDefaults(final Project project) {
		this.txfName.setText(project.getName());
		this.txfDirectory.setText(project.getDirectory());
		this.txfPackage.setText(project.getSafeName().toLowerCase().replaceAll("-", ""));
	}

	@Override
	public void initialize() {
		super.generator = new JavaGenerator(this);

		System.out.println("Generating user interface."); // TODO: Replace with log component.
		super.generator.generate();
		System.out.println("User interface generated."); // TODO: Replace with log component.
	}

	@Override
	public void update() {
		System.out.println("Updating user interface."); // TODO: Replace with log component.
		// TODO: Update stuff?
		super.generator.position();
		System.out.println("User interface updated."); // TODO: Replace with log component.
	}
}
