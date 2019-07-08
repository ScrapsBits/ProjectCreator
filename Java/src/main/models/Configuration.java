package main.models;

import java.util.ArrayList;
import java.util.List;

import main.core.enumerations.ProgrammingLanguage;

/**
 * Keep track of the various settings turned off and on by user input.
 *
 * @author ScrapsBits
 */
public final class Configuration {
	/**
	 * The name provided by the user to give to the projects created.
	 */
	private String projectName;
	/**
	 * The location where files related to configuration are stored.
	 */
	private String configLocation;
	/**
	 * A list of all programming languages of which to make a software project.
	 */
	private List<ProgrammingLanguage> selectedProgrammingLanguage;

	/**
	 * Initialize configuration settings.
	 */
	public Configuration() { selectedProgrammingLanguage = new ArrayList<>(); }

	/**
	 * Get the path to the location where configuration files are stored.
	 * @return Returns the path where the config files are stored.
	 */
	public String getConfigLocation() { return configLocation; }

	/**
	 * Set the path where the configuration files will be stored.
	 * @param configLocation The path where the config files are to be stored.
	 */
	public void setConfigLocation(String configLocation) { this.configLocation = configLocation; }

	/**
	 * Get the project name.
	 * @return Returns the name of the project.
	 */
	public String getProjectName() { return projectName; }

	/**
	 * Get a list of selected programming languages.
	 * @return Returns a list of selected programming languages.
	 */
	public List<ProgrammingLanguage> getSelectedProgrammingLanguages() { return selectedProgrammingLanguage; }

	/**
	 * Set the name of the project.
	 * @param projectName The project's name.
	 */
	public void setProjectName(final String projectName) { this.projectName = projectName; }

	/**
	 * Set the list of programming languages.
	 * @param selectedProgrammingLanguages The list of programming languages.
	 */
	public void setSelectedProgrammingLanguages(final List<ProgrammingLanguage> selectedProgrammingLanguages) { this.selectedProgrammingLanguage = selectedProgrammingLanguages; }
	
	/**
	 * Safe the configuration into a file at the provided location.
	 */
	public void safe() {
		// TODO: Write the configuration information into a file.
	}
}
