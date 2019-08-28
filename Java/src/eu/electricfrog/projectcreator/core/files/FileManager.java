package eu.electricfrog.projectcreator.core.files;

import java.io.File;

import eu.electricfrog.projectcreator.ApplicationLauncher;

/**
 * The file manager enforces specific file related methods.
 *
 * @author  ScrapsBits
 * @version 1.0
 */
public interface FileManager {
	/**
	 * Get the AppData directory.
	 *
	 * @return Returns the absolute directory of the Application Data folder.
	 */
	static String getApplicationDataDirectory() {
		// TODO: Move this to a more appropriate location.
		System.out.println("Locating application data location..."); // TODO: Replace with log component.
		String directory;
		final String os = System.getProperty("os.name").toUpperCase();
		System.out.println("Detected OS: " + os); // TODO: Replace with log component.
		// TODO: Check for explicit OS version (major version).
		if(os.contains("WIN"))
			directory = System.getenv("AppData");
		else {
			directory = System.getProperty("user.home");
			if(os.contains("MAC")) directory += "/Library/Application Support";
		}
		directory += "\\" + ApplicationLauncher.manager().data().getName();
		final File appDataDirectory = new File(directory);
		System.out.println("Located application data location at: " + appDataDirectory.getAbsolutePath() + "."); // TODO: Replace with log component.
		if(!appDataDirectory.isDirectory()) appDataDirectory.mkdir();
		return directory;
	}

	/**
	 * Get an object representing a file.
	 *
	 * @return Returns the file representative.
	 */
	File getFile();
}
