package main.ui.single_view;

import java.io.File;
import java.io.IOException;

import javafx.beans.Observable;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.stage.DirectoryChooser;
import main.ProjectCreator;
import main.core.boot.enums.BootMode;
import main.core.enumerations.ProgrammingLanguage;
import main.ui.Controller;
import main.ui.ElementGenerator;
import main.ui.enumerations.UIElements;

/**
 * Define controls and actions for a user interface.
 *
 * @author ScrapsBits
 */
public final class SingleViewController extends Controller {

	/**
	 * The StackPane that contains all elements on the User Interface. It will be injected by the FXML loader.
	 */
	@FXML
	private StackPane stpFrame;

	/**
	 * Handle a click on the Finalize button.
	 *
	 * @param event The event triggering this function.
	 */
	public void handleBtnFinalizeClick(final MouseEvent event) {
		System.out.println("Handling a click on button " + ((Node)event.getSource()).getId());
		if(event.getSource() instanceof Button) try {
			super.getConfig().safe(((TextField)((Button)event.getSource()).getScene().lookup("#" + UIElements.TEXTFIELD.getPrefix() + "ProjectLocation")).getText());
		} catch(final IllegalArgumentException e) {
			System.out.println(e.getMessage());
		}
	}

	/**
	 * Handle a click on the Location button.
	 *
	 * @param event The event triggering this function.
	 */
	public void handleBtnLocationClick(final MouseEvent event) {
		System.out.println("Handling a click on button " + ((Node)event.getSource()).getId());
		if(event.getSource() instanceof Button) {
			final Button btn = (Button)event.getSource();
			final DirectoryChooser directoryChooser = new DirectoryChooser();
			final File selectedDirectory = directoryChooser.showDialog(this.stpFrame.getScene().getWindow());
			if(selectedDirectory != null) {
				final TextField txf = (TextField)btn.getScene().lookup("#" + UIElements.TEXTFIELD.getPrefix() + "ProjectLocation");
				try {
					final String directory = selectedDirectory.getCanonicalPath();
					txf.setText(directory);
				} catch(final IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Handle a click on the Additional Sources checkbox.
	 *
	 * @param event The event triggering this function.
	 */
	public void handleChbAdditionalSourcesClick(final MouseEvent event) {
		System.out.println("Handling a click on checkbox " + ((Node)event.getSource()).getId()); // TODO: Replace with log component.
		if(event.getSource() instanceof CheckBox) {
			final CheckBox chb = (CheckBox)event.getSource();
			for(final Tab tab : ((TabPane)chb.getScene().lookup("#" + UIElements.TABPANE.getPrefix() + "Menu")).getTabs())
				if(tab.getId().contentEquals(UIElements.TAB.getPrefix() + "AdditionalSources")) if(ProjectCreator.bootMode() == BootMode.DEVELOPMENT) tab.setDisable(!chb.isSelected());
		}
	}

	/**
	 * Handle a click on the Diagrams checkbox.
	 *
	 * @param event The event triggering this function.
	 */
	public void handleChbDiagramsClick(final MouseEvent event) {
		System.out.println("Handling a click on checkbox " + ((Node)event.getSource()).getId()); // TODO: Replace with log component.
		if(event.getSource() instanceof CheckBox) {
			final CheckBox chb = (CheckBox)event.getSource();
			for(final Tab tab : ((TabPane)chb.getScene().lookup("#" + UIElements.TABPANE.getPrefix() + "Menu")).getTabs())
				if(tab.getId().contentEquals(UIElements.TAB.getPrefix() + "Diagrams")) if(ProjectCreator.bootMode() == BootMode.DEVELOPMENT) tab.setDisable(!chb.isSelected());
		}
	}

	/**
	 * Handle a click on the Documentation checkbox.
	 *
	 * @param event The event triggering this function.
	 */
	public void handleChbDocumentationClick(final MouseEvent event) {
		System.out.println("Handling a click on checkbox " + ((Node)event.getSource()).getId()); // TODO: Replace with log component.
		if(event.getSource() instanceof CheckBox) {
			final CheckBox chb = (CheckBox)event.getSource();
			for(final Tab tab : ((TabPane)chb.getScene().lookup("#" + UIElements.TABPANE.getPrefix() + "Menu")).getTabs())
				if(tab.getId().contentEquals(UIElements.TAB.getPrefix() + "Documentation")) if(ProjectCreator.bootMode() == BootMode.DEVELOPMENT) tab.setDisable(!chb.isSelected());
		}
	}

	/**
	 * Handle a click on the Programming checkbox.
	 *
	 * @param event The event triggering this function.
	 */
	public void handleChbProgrammingClick(final MouseEvent event) {
		System.out.println("Handling a click on checkbox " + ((Node)event.getSource()).getId()); // TODO: Replace with log component.
		if(event.getSource() instanceof CheckBox) {
			final CheckBox chb = (CheckBox)event.getSource();
			for(final Tab tab : ((TabPane)chb.getScene().lookup("#" + UIElements.TABPANE.getPrefix() + "Menu")).getTabs())
				if(tab.getId().contentEquals(UIElements.TAB.getPrefix() + "Programming")) if(ProjectCreator.bootMode() == BootMode.DEVELOPMENT) tab.setDisable(!chb.isSelected());
		}
	}

	/**
	 * Handle a click on a programming language checkbox.
	 *
	 * @param event The event triggering this function.
	 */
	public void handleProgrammingLanguageClick(final MouseEvent event) {
		final CheckBox source = (CheckBox)event.getSource();
		System.out.println("Handling a click on checkbox " + source.getId() + ".");
		final String id = source.getId().substring(3);
		for(final ProgrammingLanguage language : ProgrammingLanguage.values()) if(language.getId().contentEquals(id)) if(source.isSelected())
			try {
				this.getConfig().addProgrammingLanguage(language);
			} catch(final IllegalArgumentException e) {
				source.setDisable(true);
				source.setSelected(false);
			}
		else
			this.getConfig().removeProgrammingLanguage(language);
	}

	/**
	 * Initialize the user interface and define actions.
	 */
	@Override
	public void initialize() {
		System.out.println("Initializing user interface..."); // TODO: Replace with log component.
		System.out.println("Generating user interface."); // TODO: Replace with log component.
		final ElementGenerator generator = new SingleViewElementGenerator(this);
		generator.populate(this.stpFrame);
		System.out.println("User interface generated."); // TODO: Replace with log component.
	}

	/**
	 * Triggers when the selected menu changes. Performs some input checks and saves them to configuration.
	 *
	 * @param tabPane The Observable object, listening to the changes.
	 * @param tabMenu The tab pane object that triggers the function.
	 */
	public void listenMenuTabChange(final Observable tabPane, final TabPane tabMenu) {
		final Tab newTab = tabMenu.getSelectionModel().getSelectedItem();
		switch(newTab.getId()) {
			case "tabProject":
				System.out.println("Switched to tab Project"); // TODO: Replace with log component.
				break;
			case "tabProgramming":
				System.out.println("Switched to tab Programming"); // TODO: Replace with log component.
				break;
			case "tabDocumentation":
				System.out.println("Switched to tab Documentation"); // TODO: Replace with log component.
				break;
			case "tabDiagrams":
				System.out.println("Switched to tab Diagrams"); // TODO: Replace with log component.
				break;
			case "tabAdditionalSources":
				System.out.println("Switched to tab Additional Sources"); // TODO: Replace with log component.
				break;
			case "tabFinalize":
				System.out.println("Switched to tab Finalization"); // TODO: Replace with log component.
				break;
		}
	}
}
