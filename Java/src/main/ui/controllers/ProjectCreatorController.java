package main.ui.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.input.MouseEvent;

/**
 * Define controls and actions for a user interface.
 * @author ScrapsBits
 *
 */
public class ProjectCreatorController extends Controller {
	
	@FXML
	private Button btnSubmit;
	@FXML
	private Tab tbmProject;
	@FXML
	private Tab tbmProgrammingLanguages;
	@FXML
	private Tab tbmDocumentation;
	@FXML
	private Tab tbmDiagrams;
	@FXML
	private Tab tbmAdditionalSources;
	@FXML
	private Tab tbmComplete;
	
	/**
	 * Initialize the user interface and define actions.
	 */
	public void initialize() {
		super.initialize();
		System.out.println("Adding handlers to user interface elements."); // TODO: Replace with log component.
		
		System.out.println("Adding handler to submit button."); // TODO: Replace with log component.
		btnSubmit.setOnMouseClicked((arg0) -> handleSubmitClick(arg0));
	} 
	
	/**
	 * Handle what should happen when a user clicks the button named "Submit".
	 * @param e The event data.
	 */
	private void handleSubmitClick(MouseEvent e) {
		System.out.println("Submitted all data."); // TODO: Replace with log component.
	}
}
