package main.core.files.write;

/**
 * Write a file to storage.
 * @author ScrapsBits
 */
public abstract class ProjectCreatorFileWriter {
	
	private String writeLocation;
	
	/**
	 * Initialize the File Writer.
	 */
	protected ProjectCreatorFileWriter(final String writeLocation) {
		if(writeLocation == null || writeLocation.contentEquals("")) throw new IllegalArgumentException("The provided location is not allowed.");
		this.writeLocation = writeLocation;
	}
	
	protected String writeLocation() { return this.writeLocation; }
	
	/**
	 * Write the file.
	 */
	public abstract void write();
}
