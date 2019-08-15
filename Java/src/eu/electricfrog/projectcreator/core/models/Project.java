package eu.electricfrog.projectcreator.core.models;

import java.util.List;

/**
 * Resemble a programming project.
 * @author ScrapsBits
 * @version 1.0
 */
public class Project {
	/**
	 * The top-level directory where this project is stored.
	 */
	private final String directory;
	/**
	 * The name of this project.
	 */
	private final String name;
	/**
	 * The directory of the project's config file.
	 */
	private final String configFile;
	/**
	 * The language connected to this project.
	 */
	private final List<ProgrammingLanguage> programmingLanguages;
	
	/**
	 * Initialize a new project.
	 * @param directory The top-level directory where this project is stored.
	 * @param name The project's name.
	 * @param configFile The directory where this project's .config file is stored.
	 */
	public Project(String directory, String name, String configFile, List<ProgrammingLanguage> programmingLanguage) {
		this.directory = directory;
		this.name = name;
		this.configFile = configFile;
		// TODO: NULL check.
		this.programmingLanguages = programmingLanguage;
	}
	
	/**
	 * Get the directory where this project is stored.
	 * @return Returns the root directory where this location is stored.
	 */
	public String getDirectory() {
		return this.directory;
	}
	
	/**
	 * Get the name of this project.
	 * @return Returns the name of this project.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Get the configuration file's directory.
	 * @return Returns the location of the configuration file.
	 */
	public String getConfigFile() {
		return this.configFile;
	}
	
	/**
	 * Get the language this project is written in.
	 * @return Returns the language of the project.
	 */
	public final List<ProgrammingLanguage> getProgrammingLanguages() {
		return this.programmingLanguages;
	}
}
