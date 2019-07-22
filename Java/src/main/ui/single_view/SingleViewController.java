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
	 * The tab that's currently open.
	 */
	private Tab activeTab;

	/**
	 * Initialize the controller for the Single View user interface.
	 */
	public SingleViewController() {
		super();
	}
	
	/**
	 * Replace the active tab with the one that's currently open.
	 * @param newTab The newly opened tab.
	 */
	public void setActiveTab(Tab newTab) {
		this.activeTab = newTab;
	}

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

	/**
	 * Triggers when the selected menu changes. Performs some input checks and saves them to configuration.
	 * 
	 * @param tabPane The Observable object, listening to the changes.
	 * @param tabMenu The tab pane object that triggers the function.
	 */
	public void listenMenuTabChange(Observable tabPane, TabPane tabMenu) {
		// Input checks from the previous tab.
		switch(activeTab.getId()) {
			case "tabProject":
				super.getConfig().setProjectName(((TextField)this.stpFrame.lookup("#" + UIElements.TEXTFIELD.getPrefix() + "ProjectName")).getText());
				super.getConfig().setConfigLocation(((TextField)this.stpFrame.lookup("#" + UIElements.TEXTFIELD.getPrefix() + "ProjectLocation")).getText());
				break;
			case "tabProgramming":
				break;
			case "tabDocumentation":
				break;
			case "tabDiagrams":
				break;
			case "tabAdditionalSources":
				break;
			case "tabFinalize":
				break;
		}
		
		Tab newTab = tabMenu.getSelectionModel().getSelectedItem();
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

//		if("tabProject".contentEquals(activeTab.getId()) && !"tabProject".contentEquals(newTab.getId())) {
//			Node[] inputs = new Node[2];
//			boolean[] validInputs = new boolean[inputs.length];
//			for(int i = 0; i < inputs.length; i += 1) {
//				validInputs[i] = false;
//			}
//			Tab projectTab = (Tab)((TabPane)this.stpFrame.getScene().lookup("#" + UIElements.TABPANE.getPrefix() + "Menu")).getTabs().filtered((tab) -> "tabProject".contentEquals(tab.getId()))
//					.get(0);
//			AnchorPane projectTabContent = (AnchorPane)projectTab.getContent();
//			try {
//				int inputSlot = 0;
//				TextField txfProjectName = (TextField)projectTabContent.lookup("#" + UIElements.TEXTFIELD.getPrefix() + "ProjectName");
//				this.config.setProjectName(txfProjectName.getText());
//				inputs[inputSlot] = txfProjectName;
//				validInputs[inputSlot] = true;
//			} catch(IllegalArgumentException e) {
//				System.out.println(e.getMessage());
//			}
//
//			try {
//				int inputSlot = 1;
//				TextField txfConfigLocation = (TextField)projectTabContent.lookup("#" + UIElements.TEXTFIELD.getPrefix() + "ProjectLocation");
//				this.config.setConfigLocation(txfConfigLocation.getText());
//				inputs[inputSlot] = txfConfigLocation;
//				validInputs[inputSlot] = true;
//			} catch(IllegalArgumentException e) {
//				System.out.println(e.getMessage());
//			}
//
//			boolean isValid = true;
//			for(int i = 0; i < inputs.length; i += 1) {
//				if(!validInputs[i]) {
//					// TODO: Mark input[i] as invalid.. Somehow
//					isValid = false;
//				}
//			}
//			if(!isValid) { tabMenu.getSelectionModel().select(projectTab); }
//		}
		this.setActiveTab(newTab);
		System.out.println("Active tab: " + this.activeTab.getId());
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
