package main.ui.controllers;

import java.util.List;

import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import main.core.enumerations.ProgrammingLanguage;
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
	
	/**
	 * Set the project name to match user input.
	 * @param name The name given to the project.
	 */
	protected void setProjectName(String name) {
		name = name.trim();
		if(name != null && name.isEmpty()) {
			configuration.setProjectName(name);
		} else {
			System.out.println("The provided name is not valid.");
		}
	}
	
	protected void setProjectLanguages(List<ProgrammingLanguage> languages) {
		
	}
}
