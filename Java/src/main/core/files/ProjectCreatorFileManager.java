package main.core.files;

import java.io.File;

import main.ProjectCreator;

/**
 * Contains default information about all files.
 *
 * @author ScrapsBits
 */
public final class ProjectCreatorFileManager {
	/**
	 * Contains the directory to application related files.
	 */
	private final String applicationFilesDirectory;

	/**
	 * Initialize the file location where the application should look to find the active configuration file.
	 */
	public ProjectCreatorFileManager() {
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
		directory += "/" + ProjectCreator.getApplicationName();
		this.applicationFilesDirectory = directory;
		final File fileDirectory = new File(directory);
		System.out.println("Located application data location at: " + fileDirectory.getAbsolutePath() + "."); // TODO: Replace with log component.
		if(!fileDirectory.isDirectory()) fileDirectory.mkdir();
	}

	public String getApplicationFilesDirectory() { return this.applicationFilesDirectory; }
}
