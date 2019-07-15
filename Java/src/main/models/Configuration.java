package main.models;

import java.util.ArrayList;
import java.util.Collections;
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
	 * Initialize configuration settings from a configuration source.
	 * 
	 * @param projectName                  The name of the project, as loaded from the source.
	 * @param configLocation               The location where the configuration is stored.
	 * @param selectedProgrammingLanguages The various programming languages that have been selected in the source.
	 */
	public Configuration(String projectName, String configLocation, List<ProgrammingLanguage> selectedProgrammingLanguages) {
		this();
		this.setProjectName(projectName);
		this.setConfigLocation(configLocation);
		Collections.copy(this.selectedProgrammingLanguage, selectedProgrammingLanguages);
	}

	/**
	 * Get the path to the location where configuration files are stored.
	 * 
	 * @return Returns the path where the config files are stored.
	 */
	public String getConfigLocation() { return configLocation; }

	/**
	 * Set the path where the configuration files will be stored.
	 * 
	 * @param configLocation The path where the config files are to be stored.
	 */
	public void setConfigLocation(String configLocation) {
		if(configLocation != null) configLocation = configLocation.trim();
		if(!configLocation.contentEquals("")) {
			this.configLocation = configLocation;
			return;
		}
		throw new IllegalArgumentException("The given location is invalid.");

	}

	/**
	 * Get the project name.
	 * 
	 * @return Returns the name of the project.
	 */
	public String getProjectName() { return projectName; }

	/**
	 * Get a list of selected programming languages.
	 * 
	 * @return Returns a list of selected programming languages.
	 */
	public List<ProgrammingLanguage> getSelectedProgrammingLanguages() { return selectedProgrammingLanguage; }

	/**
	 * Set the name of the project.
	 * 
	 * @param projectName The project's name.
	 */
	public void setProjectName(String projectName) {
		if(projectName != null) {
			projectName = projectName.trim();
			if(!projectName.contentEquals("")) {
				this.projectName = projectName;
				return;
			}
		}
		throw new IllegalArgumentException("The given name is invalid.");
	}

	/**
	 * Set the list of programming languages.
	 * 
	 * @param selectedProgrammingLanguages The list of programming languages.
	 */
	public void setSelectedProgrammingLanguages(List<ProgrammingLanguage> selectedProgrammingLanguages) {
		if(selectedProgrammingLanguages != null && selectedProgrammingLanguages.size() > 0) {
		Collections.copy(this.selectedProgrammingLanguage, selectedProgrammingLanguages);
		}
		}

	/**
	 * Add a new language to the list of programming languages.
	 * 
	 * @param  programmingLanguage      The language added to the list.
	 * @throws IllegalArgumentException Thrown when the language is unknown or when it's marked as "not supported".
	 */
	public void addProgrammingLanguage(final ProgrammingLanguage programmingLanguage) {
		if(programmingLanguage.equals(ProgrammingLanguage.UNKNOWN)) {
			throw new IllegalArgumentException("Cannot add UNKNOWN. Please select another language.");
		} else if(!programmingLanguage.isSupported()) { throw new IllegalArgumentException("Cannot add unsupported language " + programmingLanguage.getName() + "."); }

		this.selectedProgrammingLanguage.add(programmingLanguage);
	}

	/**
	 * Remove a language from the list of programming languages.
	 * @param programmingLanguage The language added to the list.
	 */
	public void removeProgrammingLanguage(final ProgrammingLanguage programmingLanguage) { this.selectedProgrammingLanguage.remove(programmingLanguage); }

	/**
	 * Safe the configuration into a file at the provided location.
	 */
	public void safe() {
		// TODO: Write the configuration information into a file.
	}
}
