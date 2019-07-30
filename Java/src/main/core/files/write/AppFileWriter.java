package main.core.files.write;

import java.io.FileNotFoundException;

/**
 * Handle writing files.
 * @author ScrapsBits
 */
public interface AppFileWriter {
	/**
	 * Write a file to the system.
	 * @param object The object to be written, including its location.
	 * @throws FileNotFoundException Thrown when the file cannot be written or when the file is of a wrong format.
	 */
	void write(Object object) throws FileNotFoundException; }
