package eu.electricfrog.projectcreator.ui.javafx.single_view;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import eu.electricfrog.projectcreator.core.files.read.project.ConfigFileReader;
import eu.electricfrog.projectcreator.core.files.write.project.ConfigFileWriter;
import eu.electricfrog.projectcreator.core.files.write.project.languages.csharp.CSharpProjectFileWriter;
import eu.electricfrog.projectcreator.core.files.write.project.languages.java.JavaProjectFileWriter;
import eu.electricfrog.projectcreator.core.models.ProgrammingLanguage;
import eu.electricfrog.projectcreator.core.models.Project;
import eu.electricfrog.projectcreator.ui.javafx.JavaFXController;
import eu.electricfrog.projectcreator.ui.javafx.single_view.models.ObservableProgrammingLanguage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

/**
 * Define controls and actions for the SingleView user interface.
 *
 * @author  ScrapsBits
 * @version 1.0
 */
public final class SingleViewController extends JavaFXController {
	// TODO: Position all elements here for "injection" purposes. This allows the controller to apply changes to the elements that need changing.
	/**
	 * The scene StackPane is the root element for the JavaFX user interface.
	 */
	StackPane stpScene;
	/**
	 * The menu used to switch between the various topics.
	 */
	TabPane tbpMenu;
	/**
	 * The AnchorPane elements are the root elements for the various tabs.
	 */
	AnchorPane acpProject, acpProgramming, acpDocumentation, acpDiagrams, acpAdditionalSources, acpComplete;
	/**
	 * Labels to explain what is displayed on the Projects tab.
	 */
	Label lblProjectName, lblProjectLocation, lblProjectDate;
	/**
	 * Labels to explain what is displayed on the Programming tab.
	 */
	Label lblProgrammingLanguages;
	/**
	 * Labels to explain what is displayed on the Documentation tab.
	 */
	Label lblDocumentationTypes;
	/**
	 * Labels to explain what is displayed on the Diagrams tab.
	 */
	Label lblDiagramTypes;
	/**
	 * Allow the user to give text input on Project related things.
	 */
	TextField txfProjectName, txfProjectLocation;
	/**
	 * All buttons on the user interface.
	 */
	Button btnDirectory, btnLoad, btnSave, btnGenerateProjects;
	/**
	 * Keeps a list of the programming languages.
	 */
	ListView<ObservableProgrammingLanguage> lsvLanguages;
	/**
	 * Keeps the supported documentation file types.
	 */
	ListView<String> lsvDocumentation;
	/**
	 * Keeps the supported diagram file types.
	 */
	ListView<String> lsvDiagrams;

	/**
	 * Perform processes upon start-up.
	 */
	public SingleViewController() {
		super();
		System.out.println("Start-up processes performed."); // TODO: Replace with log component.
	}

	/**
	 * Fill the list of available languages.
	 *
	 * @param languages A list of languages available to making projects for.
	 */
	public void fillAvailableLanguages(final List<ObservableProgrammingLanguage> languages) { this.lsvLanguages.getItems().addAll(languages); }

	/**
	 * Create the files and folders for the selected programming languages.
	 *
	 * @param event The click event.
	 */
	public void handleBtnGenerateProjectsClick(final MouseEvent event) {
		final List<ProgrammingLanguage> programmingLanguages = new ArrayList<>();
		for(final ObservableProgrammingLanguage programmingLanguage : this.lsvLanguages.getItems()) if(programmingLanguage.isChecked()) programmingLanguages.add(programmingLanguage);
		final Project project = new Project(this.txfProjectLocation.getText(), this.txfProjectName.getText(), this.txfProjectLocation.getText(), programmingLanguages);
		for(final ProgrammingLanguage selectedLanguage : project.getProgrammingLanguages()) switch(selectedLanguage.getName()) {
			case "Java":
				new JavaProjectFileWriter(project).write();
				break;
			case "C#":
				new CSharpProjectFileWriter(project).write();
				break;
		}
	}

	/**
	 * Load in a file keeping track of the config location.
	 *
	 * @param event The click event.
	 */
	public void handleBtnLoadClick(final MouseEvent event) {
		final FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Opening project configuration.");
		final File file = fileChooser.showOpenDialog(this.stage);
		if(file != null) {
			final ConfigFileReader reader = new ConfigFileReader(file);
			final Project project = reader.read();
			if(project != null) {
				this.txfProjectName.setText(project.getName());
				this.txfProjectLocation.setText(project.getConfigFile());

				for(final ObservableProgrammingLanguage observableLanguage : this.lsvLanguages.getItems()) {
					observableLanguage.getObservableProperty().set(false);
					if(project.getProgrammingLanguages().contains(observableLanguage)) observableLanguage.getObservableProperty().set(true);
				}
			} else {
				this.txfProjectName.setText("");
				this.txfProjectLocation.setText("");
				for(final ObservableProgrammingLanguage language : this.lsvLanguages.getItems()) language.getObservableProperty().set(false);
			}
		}
	}

	/**
	 * Select a directory to store the project config file.
	 *
	 * @param event The click event.
	 */
	public void handleBtnLocationClick(final MouseEvent event) {
		final Button btn = (Button)event.getSource();
		final DirectoryChooser chooser = new DirectoryChooser();
		final File directory = chooser.showDialog(btn.getScene().getWindow());
		if(directory != null) try {
			final String selectedDirectory = directory.getCanonicalPath();
			this.txfProjectLocation.setText(selectedDirectory);
		} catch(final IOException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Save the project configuration to the system.
	 *
	 * @param event The click event.
	 */
	public void handleBtnSaveClick(final MouseEvent event) {
		final List<ObservableProgrammingLanguage> observableLanguages = new ArrayList<>();
		for(final ObservableProgrammingLanguage language : this.lsvLanguages.getItems()) if(language.isChecked()) observableLanguages.add(language);
		final Project project = new Project(null, this.txfProjectName.getText(), this.txfProjectLocation.getText(), observableLanguages);
		new ConfigFileWriter(project).write();
	}

	@Override
	public void initialize() {
		super.generator = new SingleViewGenerator(this);

		System.out.println("Generating user interface."); // TODO: Replace with log component.
		super.generator.generate();
		System.out.println("User interface generated."); // TODO: Replace with log component.
	}

	@Override
	public void update() {
		System.out.println("Updating user interface."); // TODO: Replace with log component.
		System.out.println("Stage width: " + super.stage.getWidth()); // TODO: Debug
		System.out.println("Stage height: " + super.stage.getHeight()); // TODO: Debug

		super.generator.position();
		System.out.println("User interface updated."); // TODO: Replace with log component.
	}
}
