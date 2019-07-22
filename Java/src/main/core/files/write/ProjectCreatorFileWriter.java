package main.core.files.write;

import main.core.files.ProjectCreatorFileManager;
import main.core.files.enumerations.ConfigStructure;

/**
 * Write a file to storage.
 * @author ScrapsBits
 */
public abstract class ProjectCreatorFileWriter {
	
	/**
	 * The location where the file will be written.
	 */
	private String writeLocation;
	
	/**
	 * Keep track of all default file information.
	 */
	protected final ProjectCreatorFileManager fileManager;

	/**
	 * Define in which way the configurations need to be written down.
	 */
	protected ConfigStructure configStructure;
	
	/**
	 * Initialize the File Writer.
	 * @throws IllegalArgumentException Thrown when the location does not exist AND cannot be created by the client device.
	 */
	protected ProjectCreatorFileWriter(final String writeLocation) {
		if(writeLocation == null || writeLocation.contentEquals("")) throw new IllegalArgumentException("The provided location is not allowed.");
		this.fileManager = new ProjectCreatorFileManager();
		this.writeLocation = writeLocation;
	}
	
	/**
	 * Get the location where all default project files will be located.
	 * @return Returns the location where all files will be written.
	 */
	protected final String getWriteLocation() { return this.writeLocation; }
	
	/**
	 * Write the file.
	 */
	public abstract void write();
}
