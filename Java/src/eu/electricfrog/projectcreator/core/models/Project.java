package eu.electricfrog.projectcreator.core.models;

import java.util.Collections;
import java.util.List;

/**
 * Resemble a programming project.
 *
 * @author  ScrapsBits
 * @since   1.0
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
	private final String configFileDirectory;
	/**
	 * The language connected to this project.
	 */
	private final List<? extends ProgrammingLanguage> programmingLanguages;

	/**
	 * Initialize a new project.
	 *
	 * @param directory  The top-level directory where this project is stored.
	 * @param name       The project's name.
	 * @param configFile The directory where this project's .config file is stored.
	 */
	public Project(final String directory, final String name, final String configFile, final List<? extends ProgrammingLanguage> programmingLanguage) {
		this.directory = directory;
		this.name = name;
		this.configFileDirectory = configFile;
		// TODO: NULL check.
		if(programmingLanguage == null)
			this.programmingLanguages = Collections.emptyList();
		else
			this.programmingLanguages = programmingLanguage;
	}

	/**
	 * Get the configuration file's directory.
	 *
	 * @return Returns the location of the configuration file.
	 */
	public String getConfigFile() { return this.configFileDirectory; }

	/**
	 * Get the directory where this project is stored.
	 *
	 * @return Returns the root directory where this location is stored.
	 */
	public String getDirectory() { return this.directory; }

	/**
	 * Get the name of this project.
	 *
	 * @return Returns the name of this project.
	 */
	public String getName() { return this.name; }

	/**
	 * Get the language this project is written in.
	 *
	 * @return Returns the language of the project.
	 */
	public final List<? extends ProgrammingLanguage> getProgrammingLanguages() { return this.programmingLanguages; }

	/**
	 * Get the name of the project in safe characters.
	 *
	 * @return
	 */
	public String getSafeName() {
		String safeName = this.name.trim();
		safeName = safeName.replaceAll("\\\\", "-");
		safeName = safeName.replaceAll(" ", "-");
		safeName = safeName.replaceAll("/", "-");
		safeName = safeName.replaceAll("\\s", "");
		safeName = safeName.replaceAll("#", "Sharp");
		// TODO: Number to text converter.
		safeName = safeName.replaceAll("0", "Zero");
		safeName = safeName.replaceAll("1", "One");
		safeName = safeName.replaceAll("2", "Two");
		safeName = safeName.replaceAll("3", "Three");
		safeName = safeName.replaceAll("4", "Four");
		safeName = safeName.replaceAll("5", "Five");
		safeName = safeName.replaceAll("6", "Six");
		safeName = safeName.replaceAll("7", "Seven");
		safeName = safeName.replaceAll("8", "Eight");
		safeName = safeName.replaceAll("9", "Nine");
		return safeName;
	}
}
