package eu.electricfrog.projectcreator.core.files;

import java.io.File;

import eu.electricfrog.projectcreator.core.application.Application;
import eu.electricfrog.projectcreator.core.device.Device;;

/**
 * The file manager enforces specific file related methods.
 *
 * @author  ScrapsBits
 * @since 1.0
 * @version 1.1
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
		// TODO: Check for explicit OS version (major version).
		String upperOS = Device.getOS().toUpperCase();
		if(upperOS.contains("WIN"))
			directory = System.getenv("AppData");
		else {
			directory = System.getProperty("user.home");
			if(upperOS.contains("MAC")) directory += "/Library/Application Support";
		}
		directory += "\\" + Application.getName();
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
