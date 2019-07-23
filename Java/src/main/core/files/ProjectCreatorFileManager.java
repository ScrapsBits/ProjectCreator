package main.core.files;

import java.io.File;

import main.ProjectCreator;
import main.core.files.enumerations.ConfigStructure;

/**
 * Contains default information about all files.
 *
 * @author ScrapsBits
 */
public abstract class ProjectCreatorFileManager {
	public static String getApplicationFilesDirectory() {
		System.out.println("Locating application data location..."); // TODO: Replace with log component.
		String directory;
		final String os = System.getProperty("os.name").toUpperCase();
		System.out.println("Detected OS: " + os); // TODO: Replace with log component.
		if(os.contains("WIN"))
			directory = System.getenv("AppData");
		else {
			directory = System.getProperty("user.home");
			if(os.contains("MAC")) directory += "/Library/Application Support";
		}
		directory += "\\" + ProjectCreator.getApplicationName();
		final File fileDirectory = new File(directory);
		System.out.println("Located application data location at: " + fileDirectory.getAbsolutePath() + "."); // TODO: Replace with log component.
		if(!fileDirectory.isDirectory()) fileDirectory.mkdir();
		return directory;
	}

	/**
	 * The location where files will be read from.
	 */
	private final String fileLocation;

	/**
	 * Define in which way the configurations need to be written down.
	 */
	protected final ConfigStructure configStructure;

	/**
	 * Initialize the file location where the application should look to find the active configuration file.
	 */
	protected ProjectCreatorFileManager(final String fileLocation, final ConfigStructure configStructure) {
		this.fileLocation = fileLocation;
		this.configStructure = configStructure;
	}

	/**
	 * Get the location where all files will be located.
	 *
	 * @return Returns the location where all files will be written.
	 */
	protected final String getFileLocation() { return this.fileLocation; }
}
