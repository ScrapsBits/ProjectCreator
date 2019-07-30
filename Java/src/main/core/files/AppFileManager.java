package main.core.files;

import java.io.File;

import main.core.files.enumerations.FileStructure;

/**
 * Manage various aspects of file handling by the application.
 * @author ScrapsBits
 */
public interface AppFileManager {
	/**
	 * Verify if the application can read files on the provided directory.
	 * @return Returns true if the application can read files on the provided directory. Returns false if reading is not allowed by either the application or the system.
	 */
	boolean canRead();

	/**
	 * Verify if the application can write files to the provided directory.
	 * @return Returns true if the application can write files to the provided directory. Returns false if writing is not allowed by either the application or the system.
	 */
	boolean canWrite();

	/**
	 * Verify if the file provided exists.
	 * @return Returns true if the file exists on the provided directory. Returns false if the file does not exist on the provided directory.
	 */
	boolean exists();

	/**
	 * Get the provided directory.
	 * @return Returns a string representative of the provided directory.
	 */
	String getDirectory();

	/**
	 * Read the file at the provided directory.
	 * @return Returns a representative of the file at the provided directory.
	 */
	File getFile();
	
	/**
	 * Get the structure used by the provided file.
	 * @return Returns the FileStructure value used by the file.
	 */
	FileStructure getFileStructure();
}
