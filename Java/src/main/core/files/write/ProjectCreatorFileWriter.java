package main.core.files.write;

import java.io.File;

import main.core.files.FileManager;
import main.core.files.enumerations.FileStructure;

/**
 * Write a file to storage.
 *
 * @author ScrapsBits
 */
public abstract class ProjectCreatorFileWriter extends FileManager {

	/**
	 * Initialize the File Writer.
	 *
	 * @param  fileLocation             The location where new files will be stored.
	 * @throws IllegalArgumentException Thrown when the location does not exist AND cannot be created by the client device.
	 */
	protected ProjectCreatorFileWriter(final File file, final FileStructure fileStructure) {
		super(file, fileStructure);
		if(file == null) throw new IllegalArgumentException("The provided location is not allowed.");
	}

	/**
	 * Write the file.
	 */
	public abstract void write();
}
