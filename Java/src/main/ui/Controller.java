package main.ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import main.core.enumerations.ProgrammingLanguage;
import main.core.files.ProjectCreatorFileManager;
import main.core.files.enumerations.ConfigStructure;
import main.core.files.read.ConfigFileReader;
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
	protected final Configuration config;

	/**
	 * Initialize a controller with default settings.
	 */
	protected Controller() {
		Configuration configuration = null;
		try {
			System.out.println("Attempting to read projects file."); // TODO: Replace with log component.
			String[] projects = readProjectsFile();
			System.out.println("Read " + projects.length + " lines."); // TODO: Replace with log component.
			// TODO: Loop through all key-value pair projects. Pick the most recent one by default.. Somehow.
			String[] location = new String[projects.length];
			for(int i = 0; i < projects.length; i += 1) {
				String[] projectData = projects[i].split("=");
				location[i] = projectData[1]; 
			}
			System.out.println("Loading in first found project."); // TODO: Replace with log component.
			ConfigFileReader reader = new ConfigFileReader(location[0], ConfigStructure.XML);
			configuration = reader.read();
		} catch(final UnsupportedOperationException e) {
			System.out.println(e.getMessage()); // TODO: Replace with log component.
			System.out.println("No projects file found. Proceeding with default values."); // TODO: Replace with log component. this.config = new Configuration(); }
			configuration = new Configuration();
		}
		this.config = configuration;
	}

	public Configuration getConfig() { return this.config; }

	/**
	 * Perform default initialization processes.
	 */
	protected void initialize() {
			System.out.println("Initializing user interface..."); // TODO: Replace with log component.
	}

	private String[] readProjectsFile() {
		// TODO: Read CONFIG file.
		String projectsFileLocation = ProjectCreatorFileManager.getApplicationFilesDirectory();
		System.out.println("Reading projects file at " + projectsFileLocation + ".");
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(projectsFileLocation + "\\projects"));
			List<String> lines = new ArrayList<>();
			while(scanner.hasNextLine()) {
				lines.add(scanner.nextLine());
			}
			return Arrays.copyOf(lines.toArray(), lines.size(), String[].class);
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			scanner.close();
		}
		return new String[0];
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
