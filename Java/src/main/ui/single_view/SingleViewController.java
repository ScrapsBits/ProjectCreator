package main.ui.single_view;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
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
	 * Delegate event actions from elements to their handler methods.
	 */
	private void delegateActions() {
		System.out.println("Delegating events.");
		final TabPane tbpMenu = (TabPane)this.stpFrame.getChildren().get(0);
		final List<Tab> tabs = tbpMenu.getTabs();
		for(final Tab tab : tabs) {
			final List<Node> elements = ((AnchorPane)tab.getContent()).getChildren();
			for(final Node element : elements) switch(tab.getId()) {
				case "tabProject":
					this.delegateProjectTabActions(element);
					break;
				case "tabProgramming":
					this.delegateProgrammingTabActions(element);
					break;
				case "tabFinalize":
					this.delegateFinalizeTabActions(element);
					break;
			}
		}
	}

	/**
	 * Define all actions for elements on the Finalize tab. Refer each action to the appropriate handler.
	 *
	 * @param element An element displayed on the Finalize tab. Not all elements get an event handler.
	 */
	private void delegateFinalizeTabActions(final Node element) {
		switch(element.getId()) {
			case "btnFinalize":
				System.out.println("Delegating events for btnFinalize.");
				System.out.println("Delegating mouse click event.");
				element.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> this.handleBtnFinalizeClick(event));
				break;
		}
	}

	/**
	 * Define all actions for elements on the Programming tab. Refer each action to the appropriate handler.
	 *
	 * @param element An element displayed on the Programming tab. Not all elements get an event handler.
	 */
	private void delegateProgrammingTabActions(final Node element) {
		switch(element.getId()) {
			case "chbCPlusPlus":
				System.out.println("Delegating events for chbCPlusPlus.");
				System.out.println("Delegating mouse click event.");
				element.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> this.handleProgrammingLanguageClick(event));
				break;
			case "chbCSharp":
				System.out.println("Delegating events for chbCSharp.");
				System.out.println("Delegating mouse click event.");
				element.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> this.handleProgrammingLanguageClick(event));
				break;
			case "chbJava":
				System.out.println("Delegating events for chbJava.");
				System.out.println("Delegating mouse click event.");
				element.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> this.handleProgrammingLanguageClick(event));
				break;
		}
	}

	/**
	 * Define all actions for elements on the Project tab. Refer each action to the appropriate handler.
	 *
	 * @param element An element displayed on the Project tab. Not all elements get an event handler.
	 */
	private void delegateProjectTabActions(final Node element) {
		switch(element.getId()) {
			case "chbProgramming":
				System.out.println("Delegating events for chbProgramming.");
				System.out.println("Delegating mouse click event.");
				element.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> this.handleChbProgrammingClick(event));
				break;
			case "chbDocumentation":
				System.out.println("Delegating events for chbDocumentation.");
				System.out.println("Delegating mouse click event.");
				element.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> this.handleChbDocumentationClick(event));
				break;
			case "chbDiagrams":
				System.out.println("Delegating events for chbDocuments.");
				System.out.println("Delegating mouse click event.");
				element.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> this.handleChbDiagramsClick(event));
				break;
			case "chbAdditionalSources":
				System.out.println("Delegating events for chbAdditionalSources.");
				System.out.println("Delegating mouse click event.");
				element.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> this.handleChbAdditionalSourcesClick(event));
				break;
			case "btnLocation":
				System.out.println("Delegating events for btnLocation.");
				System.out.println("Delegating mouse click event.");
				element.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> this.handleBtnLocationClick(event));
				break;
		}
	}

	/**
	 * Handle a click on the Finalize button.
	 *
	 * @param event The event triggering this function.
	 */
	private void handleBtnFinalizeClick(final MouseEvent event) {
		System.out.println("Handling a click on button " + ((Node)event.getSource()).getId());
		if(event.getSource() instanceof Button) {}
	}

	/**
	 * Handle a click on the Location button.
	 *
	 * @param event The event triggering this function.
	 */
	private void handleBtnLocationClick(final MouseEvent event) {
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
	private void handleChbAdditionalSourcesClick(final MouseEvent event) {
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
	private void handleChbDiagramsClick(final MouseEvent event) {
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
	private void handleChbDocumentationClick(final MouseEvent event) {
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
	private void handleChbProgrammingClick(final MouseEvent event) {
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
	private void handleProgrammingLanguageClick(final MouseEvent event) {
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
		final SingleViewElementGenerator generator = new SingleViewElementGenerator(this.config, this);
		generator.populate(this.stpFrame);
		System.out.println("User interface generated."); // TODO: Replace with log component.
		
		this.delegateActions();
	}
}
