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
import main.core.enumerations.BootMode;
import main.core.enumerations.ProgrammingLanguage;
import main.ui.Controller;
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
	 * Initialize the controller for the Single View user interface.
	 */
	public SingleViewController() { super(); }

	/**
	 * Handle a click on the Finalize button.
	 *
	 * @param event The event triggering this function.
	 */
	public void handleBtnFinalizeClick(final MouseEvent event) {
		System.out.println("Handling a click on button " + ((Node)event.getSource()).getId());
		if(event.getSource() instanceof Button) {
			try {
				super.config.safe();
			} catch(IllegalArgumentException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public void listenMenuTabChange(Observable tab) {
		System.out.println("I listened!");
		System.out.println(tab);
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
					this.setProjectLocation(directory);
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
				this.config.addProgrammingLanguage(language);
			} catch(final IllegalArgumentException e) {
				source.setDisable(true);
				source.setSelected(false);
			}
		else
			this.config.removeProgrammingLanguage(language);
	}

	/**
	 * Initialize the user interface and define actions.
	 */
	@Override
	public void initialize() {
		super.initialize();
		System.out.println("Generating user interface."); // TODO: Replace with log component.
		final SingleViewElementGenerator generator = new SingleViewElementGenerator(this);
		generator.populate(this.stpFrame);
		System.out.println("User interface generated."); // TODO: Replace with log component.
	}
}
