package main.ui.controllers;

import java.util.List;

import main.core.enumerations.ProgrammingLanguage;
import main.models.Configuration;

/**
 * Hold fields and values important to all controllers.
 *
 * @author ScrapsBits
 */
public abstract class Controller {
	
	protected Configuration configuration;

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
		if(name != null && !name.isEmpty()) {
			configuration.setProjectName(name);
		} else {
			System.out.println("The provided name is not valid.");
		}
	}
	
	/**
	 * Set the location for the configuration files. Also sets the default location for projects.
	 * @param location The location where the configuration files will be stored. It will also be the default location for projects.
	 */
	protected void setProjectLocation(String location) {
		location = location.trim();
		if(location != null && !location.isEmpty()) {
			configuration.setConfigLocation(location);
		} else {
			System.out.println("The location is not valid.");
		}
	}
	
	/**
	 * Set the list of programming languages selected by the user.
	 * @param languages A list of all languages for which a software project will be created.
	 */
	protected void setProjectLanguages(List<ProgrammingLanguage> languages) {
		if(languages != null && !languages.isEmpty()) {
			configuration.setSelectedProgrammingLanguages(languages);
		} else {
			System.out.println("The provided list of languages is empty. At least one language must be selected.");
		}
	}
}
