package main.core.files.read;

import java.io.FileNotFoundException;

import main.core.files.ProjectCreatorFileManager;
import main.core.files.enumerations.ConfigStructure;

/**
 * Read a file from storage.
 *
 * @author ScrapsBits
 */
public abstract class ProjectCreatorFileReader extends ProjectCreatorFileManager {

	/**
	 * Initialize the File Reader.
	 *
	 * @param  fileLocation             The location where existing files will be read.
	 * @param  configurationStructure   The structure used by the files being read.
	 * @throws IllegalArgumentException Thrown when the location does not exist AND cannot be created by the client device.
	 * @throws FileNotFoundException    Thrown when the .config file does not exist.
	 */
	protected ProjectCreatorFileReader(final String fileLocation, final ConfigStructure configStructure) {
		super(fileLocation, configStructure);
		if(fileLocation == null || fileLocation.contentEquals("")) throw new IllegalArgumentException("The provided location is not allowed.");
	}

	/**
	 * Read a file. Return what was read.
	 *
	 * @throws FileNotFoundException
	 */
	public abstract Object read() throws FileNotFoundException;
}
