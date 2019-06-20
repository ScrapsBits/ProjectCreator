package main.ui.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import main.ui.generator.ElementGenerator;

/**
 * Define controls and actions for a user interface.
 * 
 * @author ScrapsBits
 *
 */
public final class ProjectCreatorController extends Controller {

	@FXML
	private StackPane stpFrame;

	/**
	 * Initialize the user interface and define actions.
	 */
	@Override
	public void initialize() {
		super.initialize();
		initializeTabs();
		fillTabs();
	}

	/**
	 * Initialize all components on the user interface and define styling, position
	 * and actions.
	 */
	private void initializeTabs() {
		System.out.println("Generating tabs."); // TODO: Replace with log component.
		ElementGenerator generator = new ElementGenerator();
		stpFrame.getChildren().add(generator.generateTabMenu());
		System.out.println("All tabs generated."); // TODO: Replace with log component.
	}

	/**
	 * Initialize the components for every tab.
	 */
	private void fillTabs() {
		System.out.println("Generating components."); // TODO: Replace with log component.
		ElementGenerator generator = new ElementGenerator();
		TabPane menu = (TabPane) stpFrame.getChildren().filtered((node) -> node.getId().equals("tbpMenu")).get(0);
		for (Tab tab : menu.getTabs()) {
			switch (tab.getId()) {
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
		}
		System.out.println("All components generated."); // TODO: Replace with log component.
	}
}
