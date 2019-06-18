package main.ui.controllers;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class ProjectCreatorController extends Controller {
	
	@FXML
	private Button btnSubmit;
	
	/**
	 * Initialize the user interface and define actions.
	 */
	public void initialize() {
		System.out.println("Initializing user interface..."); // TODO: Replace with log component.
		System.out.println("Adding handler to submit button."); // TODO: Replace with log component.
		btnSubmit.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent arg0) {
				handleSubmitClick(arg0);
			}
		});
	} 
	
	/**
	 * Handle what should happen when a user clicks the button named "Submit".
	 * @param e The event data.
	 */
	private void handleSubmitClick(MouseEvent e) {
		System.out.println("Submitted all data."); // TODO: Replace with log component.
	}
}
