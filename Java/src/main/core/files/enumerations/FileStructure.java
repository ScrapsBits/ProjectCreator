package main.core.files.enumerations;

/**
 * Define the structure used by a file.
 * 
 * @author ScrapsBits
 */
public enum FileStructure {
	/**
	 * Read or write a plain text file.
	 */
	PLAIN,
	/**
	 * Read or write the file using the key-value pair method. Key value pairs must be separated by the "equals" character '='.
	 */
	KEY_VALUE,
	/**
	 * Read or write the file using an XML structure.
	 */
	XML;
}
