package main.core.files.write;

import main.core.files.ProjectCreatorFileManager;
import main.core.files.enumerations.ConfigStructure;

/**
 * Write a file to storage.
 *
 * @author ScrapsBits
 */
public abstract class ProjectCreatorFileWriter extends ProjectCreatorFileManager {

	/**
	 * Initialize the File Writer.
	 *
	 * @param  fileLocation             The location where new files will be stored.
	 * @throws IllegalArgumentException Thrown when the location does not exist AND cannot be created by the client device.
	 */
	protected ProjectCreatorFileWriter(final String fileLocation, final ConfigStructure configStructure) {
		super(fileLocation, configStructure);
		if(fileLocation == null || fileLocation.contentEquals("")) throw new IllegalArgumentException("The provided location is not allowed.");
	}

	/**
	 * Write the file.
	 */
	public abstract void write();
}
