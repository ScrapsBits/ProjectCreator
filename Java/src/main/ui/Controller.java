package main.ui;

import java.util.List;

import main.core.enumerations.ProgrammingLanguage;
import main.models.Configuration;

/**
 * Hold fields and values important to all controllers.
 *
 * @author ScrapsBits
 */
public abstract class Controller {

	/**
	 * Keep a reference to the configuration object.
	 */
	protected Configuration config;

	/**
	 * Initialize a controller with default settings.
	 */
	protected Controller() {
		this.config = new Configuration(); // TODO: Check if a configuration file can be located.
	}

	/**
	 * Perform default initialization processes.
	 */
	protected void initialize() {
		try {
			// TODO: Read CONFIG file.
			System.out.println("Attempting to read .config file at the default location."); // TODO: Replace with log component.
			// TODO: Fill configuration values.
			throw new UnsupportedOperationException();
		} catch(final Exception e) {
			System.out.println("No .config file found. Proceeding with default values."); // TODO: Replace with log component.
		} finally {
			System.out.println("Initializing user interface..."); // TODO: Replace with log component.
		}
	}

	/**
	 * Set the list of programming languages selected by the user.
	 *
	 * @param languages A list of all languages for which a software project will be created.
	 */
	protected void setProjectLanguages(final List<ProgrammingLanguage> languages) {
		if(languages != null && !languages.isEmpty())
			this.config.setSelectedProgrammingLanguages(languages);
		else
			System.out.println("The provided list of languages is empty. At least one language must be selected.");
	}

	/**
	 * Set the location for the configuration files. Also sets the default location for projects.
	 *
	 * @param location The location where the configuration files will be stored. It will also be the default location for projects.
	 */
	protected void setProjectLocation(String location) {
		location = location.trim();
		if(location != null && !location.isEmpty())
			this.config.setConfigLocation(location);
		else
			System.out.println("The location is not valid.");
	}

	/**
	 * Set the project name to match user input.
	 *
	 * @param name The name given to the project.
	 */
	protected void setProjectName(String name) {
		name = name.trim();
		if(name != null && !name.isEmpty())
			this.config.setProjectName(name);
		else
			System.out.println("The provided name is not valid.");
	}
}
