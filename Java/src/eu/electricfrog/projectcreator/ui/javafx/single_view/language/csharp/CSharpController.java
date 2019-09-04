package eu.electricfrog.projectcreator.ui.javafx.single_view.language.csharp;

import eu.electricfrog.projectcreator.core.models.ProgrammingLanguage;
import eu.electricfrog.projectcreator.core.models.Project;
import eu.electricfrog.projectcreator.ui.javafx.single_view.language.LanguageController;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

/**
 * The controller handling actions from the User Interface for the settings of the C# language.
 * @author ScrapsBits
 * @version 1.1
 */
public final class CSharpController extends LanguageController {
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
	Label lblName, lblDirectory, lblSolution;
	/**
	 * Text input fields.
	 */
	TextField txfName, txfDirectory, txfSolution;

	/**
	 * Load in the settings provided with the C# language.
	 * @param language The C# language object reference.
	 */
	public CSharpController(ProgrammingLanguage language) {
		super(language);
		if(!language.getName().contentEquals("C#")) throw new IllegalArgumentException("The provided language is not a C# language.");
		System.out.println("Start-up processes performed."); // TODO: Replace with log component.
	}

	@Override
	public final void initialize() {
		super.generator = new CSharpGenerator(this);

		System.out.println("Generating user interface."); // TODO: Replace with log component.
		super.generator.generate();
		System.out.println("User interface generated."); // TODO: Replace with log component.
	}

	@Override
	public final void update() { 
		System.out.println("Updating user interface."); // TODO: Replace with log component.
		// TODO: Update stuff?
		super.generator.position();
		System.out.println("User interface updated."); // TODO: Replace with log component.
	}
	
	public final void fillDefaults(Project project) {
		this.txfName.setText(project.getName());
		this.txfDirectory.setText(project.getDirectory());
		this.txfSolution.setText(project.getSafeName());
	}
}
