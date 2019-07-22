package main.core.files.read;

import main.core.files.ProjectCreatorFileManager;
import main.core.files.enumerations.ConfigStructure;

/**
 * Read a file from storage.
 *
 * @author ScrapsBits
 */
public abstract class ProjectCreatorFileReader {
	/**
	 * The location where files will be read from.
	 */
	private final String fileLocation;

	/**
	 * Keep track of all default file information.
	 */
	protected final ProjectCreatorFileManager fileManager;

	/**
	 * Define in which way the configurations need to be written down.
	 */
	protected ConfigStructure configStructure;

	/**
	 * Initialize the File Reader.
	 *
	 * @param  fileLocation             The location where existing files will be read.
	 * @param  configurationStructure   The structure used by the files being read.
	 * @throws IllegalArgumentException Thrown when the location does not exist AND cannot be created by the client device.
	 */
	protected ProjectCreatorFileReader(final String fileLocation, final ConfigStructure configurationStructure) {
		if(fileLocation == null || fileLocation.contentEquals("")) throw new IllegalArgumentException("The provided location is not allowed.");
		this.fileLocation = fileLocation;
		this.fileManager = new ProjectCreatorFileManager();
		this.configStructure = configurationStructure;
	}

	/**
	 * Get the location where all files will be located.
	 *
	 * @return Returns the location where all files will be read from.
	 */
	public final String getFileLocation() { return this.fileLocation; }

	/**
	 * Read a file. Return what was read.
	 */
	public abstract Object read();
}
