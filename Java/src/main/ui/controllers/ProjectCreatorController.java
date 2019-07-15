package main.ui.controllers;

import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import main.core.ProjectCreator;
import main.core.enumerations.BootMode;
import main.ui.elements.ElementGenerator;
import main.ui.enumerations.UIElements;

/**
 * Define controls and actions for a user interface.
 *
 * @author ScrapsBits
 */
public final class ProjectCreatorController extends Controller {

	@FXML
	private StackPane stpFrame;

	/**
	 * Initialize the controller for the Single View user interface.
	 */
	public ProjectCreatorController() { super(); }

	/**
	 * Initialize the components for every tab.
	 */
	private void fillTabs() {
		System.out.println("Generating components."); // TODO: Replace with log component.
		final ElementGenerator generator = new ElementGenerator();
		final TabPane menu = (TabPane)stpFrame.getChildren().filtered((node) -> node.getId().equals("tbpMenu")).get(0);
		for(final Tab tab : menu.getTabs()) switch(tab.getId()) {
			case "tabProject":
				tab.setContent(generator.generateProjectTabContent(tab));
				break;
			case "tabProgramming":
				tab.setContent(generator.generateProgrammingTabContent(tab));
				break;
			case "tabDocumentation":
				tab.setContent(generator.generateDocumentationTabContent(tab));
				break;
			case "tabDiagrams":
				tab.setContent(generator.generateDiagramsTabContent(tab));
				break;
			case "tabAdditionalSources":
				tab.setContent(generator.generateAdditionalSourcesTabContent(tab));
				break;
			case "tabFinalize":
				tab.setContent(generator.generateFinalizeTabContent(tab));
				break;
			default:
				tab.setContent(new AnchorPane());
				break;
		}
		System.out.println("All components generated."); // TODO: Replace with log component.
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void initialize() {
		super.initialize();
		initializeTabs();
		fillTabs();
		delegateActions();
	}

	/**
	 * Initialize all components on the user interface and define styling, position and actions.
	 */
	private void initializeTabs() {
		System.out.println("Generating tabs."); // TODO: Replace with log component.
		final ElementGenerator generator = new ElementGenerator();
		stpFrame.getChildren().add(generator.generateTabMenu());
		System.out.println("All tabs generated."); // TODO: Replace with log component.
	}

	/**
	 * Delegate event actions from elements to their handler methods.
	 */
	private void delegateActions() {
		System.out.println("Delegating events."); // TODO: Replace with log component.
		final TabPane tbpMenu = (TabPane)stpFrame.getChildren().get(0);
		final List<Tab> tabs = tbpMenu.getTabs();
		for(final Tab tab : tabs) {
			final List<Node> elements = ((AnchorPane)tab.getContent()).getChildren();
			for(final Node element : elements) switch(tab.getId()) {
				case "tabProject":
					delegateProjectTabActions(element);
					break;
				case "tabFinalize":
					delegateFinalizeTabActions(element);
					break;
			}
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
				System.out.println("Delegating events for chbProgramming."); // TODO: Replace with log component.
				System.out.println("Delegating mouse click event."); // TODO: Replace with log component.
				element.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> handleChbProgrammingClick(event));
				break;
			case "chbDocumentation":
				System.out.println("Delegating events for chbDocumentation."); // TODO: Replace with log component.
				System.out.println("Delegating mouse click event."); // TODO: Replace with log component.
				element.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> handleChbDocumentationClick(event));
				break;
			case "chbDiagrams":
				System.out.println("Delegating events for chbDocuments."); // TODO: Replace with log component.
				System.out.println("Delegating mouse click event."); // TODO: Replace with log component.
				element.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> handleChbDiagramsClick(event));
				break;
			case "chbAdditionalSources":
				System.out.println("Delegating events for chbAdditionalSources."); // TODO: Replace with log component.
				System.out.println("Delegating mouse click event."); // TODO: Replace with log component.
				element.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> handleChbAdditionalSourcesClick(event));
				break;
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
				System.out.println("Delegating events for btnFinalize."); // TODO: Replace with log component.
				System.out.println("Delegating mouse click event."); // TODO: Replace with log component.
				element.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> handleBtnFinalizeClick(event));
		}
	}

	/**
	 * Handle a click on the Programming checkbox.
	 * 
	 * @param event The event referring to the click on the checkbox.
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
	 * Handle a click on the Finalize button.
	 * @param event The event referring to the click on the button.
	 */
	private void handleBtnFinalizeClick(final MouseEvent event) {
		System.out.println("Handling a click on button " + ((Node)event.getSource()).getId()); // TODO: Replace with log component.
		if(event.getSource() instanceof Button) { Button btn = (Button) event.getSource(); }
		// TODO: Set writing section.
	}

	/**
	 * Handle a click on the Documentation checkbox.
	 * 
	 * @param event The event referring to the click on the checkbox.
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
	 * Handle a click on the Diagrams checkbox.
	 * 
	 * @param event The event referring to the click on the checkbox.
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
	 * Handle a click on the AdditionalSources checkbox.
	 * 
	 * @param event The event referring to the click on the checkbox.
	 */
	private void handleChbAdditionalSourcesClick(final MouseEvent event) {
		System.out.println("Handling a click on checkbox " + ((Node)event.getSource()).getId()); // TODO: Replace with log component.
		if(event.getSource() instanceof CheckBox) {
			final CheckBox chb = (CheckBox)event.getSource();
			for(final Tab tab : ((TabPane)chb.getScene().lookup("#" + UIElements.TABPANE.getPrefix() + "Menu")).getTabs())
				if(tab.getId().contentEquals(UIElements.TAB.getPrefix() + "AdditionalSources")) if(ProjectCreator.bootMode() == BootMode.DEVELOPMENT) tab.setDisable(!chb.isSelected());
		}
	}
}
