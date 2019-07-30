package main.core.files.read;

import java.io.FileNotFoundException;

/**
 * Handle reading files.
 * @author ScrapsBits
 */
public interface AppFileReader {
	/**
	 * Read a file on the system.
	 * @return Returns the object retrieved from the read file.
	 * @throws FileNotFoundException Thrown when the application cannot read the file or when the expected file does not exist.
	 */
	Object read() throws FileNotFoundException; }
