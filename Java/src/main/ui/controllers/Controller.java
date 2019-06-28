package main.ui.controllers;

import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import main.models.Configuration;

/**
 * Hold fields and values important to all controllers.
 *
 * @author ScrapsBits
 */
public abstract class Controller {

	@FXML
	protected StackPane stpFrame;
	
	private Configuration configuration;

	/**
	 * Initialize a controller with default settings.
	 */
	protected Controller() {
		configuration = new Configuration(); // TODO: Check if a configuration file can be located.
	}

	/**
	 * Perform default initialization processes.
	 */
	protected void initialize() {
		System.out.println("Initializing user interface..."); // TODO: Replace with log component.
	}
}
