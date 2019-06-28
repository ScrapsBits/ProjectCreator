package main.ui.controllers;

import java.util.List;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
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
	 * Initialize the user interface and define actions.
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
		System.out.println("Delegating events.");
		TabPane tbpMenu = (TabPane) stpFrame.getChildren().get(0);
		List<Tab> tabs = tbpMenu.getTabs();
		for (Tab tab : tabs) {
			List<Node> elements = ((AnchorPane) (tab.getContent())).getChildren();
			for (Node element : elements) {
				switch (tab.getId()) {
				case "tabProject":
					delegateProjectTabActions(element);
					break;
				case "tabFinalize":
					delegateFinalizeTabActions(element);
					break;
				}
			}
		}
	}

	/**
	 * Define all actions for elements on the Project tab. Refer each action to the
	 * appropriate handler.
	 * 
	 * @param element An element displayed on the Project tab. Not all elements get
	 *                an event handler.
	 */
	private void delegateProjectTabActions(Node element) {
		switch (element.getId()) {
		case "chbProgramming":
			System.out.println("Delegating events for chbProgramming.");
			System.out.println("Delegating mouse click event.");
			element.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> handleChbProgrammingClick(event));
			break;
		case "chbDocumentation":
			System.out.println("Delegating events for chbDocumentation.");
			System.out.println("Delegating mouse click event.");
			element.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> handleChbDocumentationClick(event));
			break;
		case "chbDiagrams":
			System.out.println("Delegating events for chbDocuments.");
			System.out.println("Delegating mouse click event.");
			element.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> handleChbDiagramsClick(event));
			break;
		case "chbAdditionalSources":
			System.out.println("Delegating events for chbAdditionalSources.");
			System.out.println("Delegating mouse click event.");
			element.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> handleChbAdditionalSourcesClick(event));
			break;
		}
	}
	
	private void delegateFinalizeTabActions(Node element) {
		switch(element.getId()) {
			case "btnFinalize":
				System.out.println("Delegating events for btnFinalize.");
				System.out.println("Delegating mouse click event.");
				element.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> handleBtnFinalizeClick(event));
		}
	}

	private void handleChbProgrammingClick(MouseEvent event) {
		System.out.println("Handling a click on checkbox " + ((Node)(event.getSource())).getId());
		if (event.getSource() instanceof CheckBox) {
			CheckBox chb = (CheckBox) event.getSource();
			for(Tab tab : ((TabPane) (chb.getScene().lookup("#" + UIElements.TABPANE.getPrefix() + "Menu"))).getTabs()) {
				if(tab.getId().contentEquals(UIElements.TAB.getPrefix() + "Programming")) {
					if(ProjectCreator.bootMode() == BootMode.DEVELOPMENT) {
					tab.setDisable(!chb.isSelected());
					}
				}
			}
		}
	}
	
	private void handleBtnFinalizeClick(MouseEvent event) {
		System.out.println("Handling a click on button " + ((Node)(event.getSource())).getId());
		if(event.getSource() instanceof Button) {
			Button btn = (Button) event.getSource();
			// TODO: Set writing section.
		}
	}
	
	private void handleChbDocumentationClick(MouseEvent event) {
		System.out.println("Handling a click on checkbox " + ((Node)(event.getSource())).getId());
		if (event.getSource() instanceof CheckBox) {
			CheckBox chb = (CheckBox) event.getSource();
			for(Tab tab : ((TabPane) (chb.getScene().lookup("#" + UIElements.TABPANE.getPrefix() + "Menu"))).getTabs()) {
				if(tab.getId().contentEquals(UIElements.TAB.getPrefix() + "Documentation")) {
					if(ProjectCreator.bootMode() == BootMode.DEVELOPMENT) {
					tab.setDisable(!chb.isSelected());
				}
				}
			}
		}
	}
	
	private void handleChbDiagramsClick(MouseEvent event) {
		System.out.println("Handling a click on checkbox " + ((Node)(event.getSource())).getId());
		if (event.getSource() instanceof CheckBox) {
			CheckBox chb = (CheckBox) event.getSource();
			for(Tab tab : ((TabPane) (chb.getScene().lookup("#" + UIElements.TABPANE.getPrefix() + "Menu"))).getTabs()) {
				if(tab.getId().contentEquals(UIElements.TAB.getPrefix() + "Diagrams")) {
					if(ProjectCreator.bootMode() == BootMode.DEVELOPMENT) {
					tab.setDisable(!chb.isSelected());
					}
				}
			}
		}
	}
	
	private void handleChbAdditionalSourcesClick(MouseEvent event) {
		System.out.println("Handling a click on checkbox " + ((Node)(event.getSource())).getId());
		if (event.getSource() instanceof CheckBox) {
			CheckBox chb = (CheckBox) event.getSource();
			for(Tab tab : ((TabPane) (chb.getScene().lookup("#" + UIElements.TABPANE.getPrefix() + "Menu"))).getTabs()) {
				if(tab.getId().contentEquals(UIElements.TAB.getPrefix() + "AdditionalSources")) {
					if(ProjectCreator.bootMode() == BootMode.DEVELOPMENT) {
					tab.setDisable(!chb.isSelected());
					}
				}
			}
		}
	}
}
