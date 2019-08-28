package eu.electricfrog.projectcreator.core.files.type;

import java.io.File;

/**
 * Generic functionality to handle files reading and writing.
 * 
 * @author  ScrapsBits
 * @version 1.1
 */
public abstract class FileHandler {
	private File file;

	protected FileHandler(File file) { this.file = file; }
	
	protected File file() {
		return this.file;
	}
}
