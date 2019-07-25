package main.ui;

import java.io.FileNotFoundException;

import main.ProjectCreator;
import main.core.files.read.ProjectsFileReader;
import main.models.Configuration;
import main.models.Project;

/**
 * Hold fields and values important to all controllers.
 *
 * @author ScrapsBits
 */
public abstract class Controller {

	/**
	 * Keep a reference to the configuration object.
	 */
	private final Configuration config;
	/**
	 * Keep a reference to a currently opened project.
	 */
	private Project project;

	/**
	 * Initialize a controller. Load in a configuration file.
	 */
	protected Controller() {
		// TODO: Check if the boot mode allows file reading. If yes, search and read the "projects" file.
		
		Configuration configHolder;
		switch(ProjectCreator.bootMode()) {
			case SAFE:
				System.out.println("SAFE mode detected. Using default values."); // TODO: Replace with log component.
				configHolder = new Configuration();
				break;
			default:
				try {
					// TODO: Move code to "load configuration".
					configHolder = new Configuration().read(new ProjectsFileReader().read()[0].getLocation());
				} catch(NullPointerException | FileNotFoundException | IllegalArgumentException e) {
					System.out.println(e.getMessage() + " Applying default values."); // TODO: Replace with log component.
					configHolder = new Configuration();
				}
				break;
		}
		this.config = configHolder;
	}

	public final Configuration getConfig() { return this.config; }

	/**
	 * Perform default initialization processes.
	 */
	public abstract void initialize();
}
