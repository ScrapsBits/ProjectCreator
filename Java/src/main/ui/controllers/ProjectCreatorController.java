package main.ui.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.TabPane;
import javafx.scene.layout.StackPane;
import main.ui.generator.ElementGenerator;

/**
 * Define controls and actions for a user interface.
 * @author ScrapsBits
 *
 */
public final class ProjectCreatorController extends Controller {
	
	@FXML
	private StackPane stpFrame;
	
	/**
	 * Initialize the user interface and define actions.
	 */
	public void initialize() {
		super.initialize();
		initializeTabs();
		System.out.println("All components initialized."); // TODO: Replace with log component.
	}
	
	/**
	 * Initialize all components on the user interface and define styling, position and actions.
	 */
	private void initializeTabs() {
		ElementGenerator generator = new ElementGenerator();
		TabPane tapMenu = generator.generateTabMenu();
		stpFrame.getChildren().add(tapMenu);
	}
}
