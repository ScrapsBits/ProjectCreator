package main.models;

/**
 * Represents a project stored on the client's computer.
 * 
 * @author ScrapsBits
 */
public class Project {
	/**
	 * The name given to the project by the client.
	 */
	private final String name;
	/**
	 * The location where the project configuration can be found.
	 */
	private final String location;

	/**
	 * Keep track of the configuration of the project.
	 */
	private final Configuration config;

	/**
	 * Represents a project as stored on the client's computer.
	 * 
	 * @param name     The name of the project.
	 * @param location The location where the project configuration is stored.
	 */
	public Project(String name, String location) { this(name, location, new Configuration()); }

	/**
	 * Represents a project as stored on the client's computer.
	 * 
	 * @param name     The name of the project.
	 * @param location The location where the project configuration is stored.
	 * @param config   The configuration settings of the project.
	 */
	public Project(String name, String location, Configuration config) {
		this.name = name;
		this.location = location;
		this.config = config;
	}

	/**
	 * Get the name of the project.
	 * 
	 * @return Returns the name of the project.
	 */
	public String getName() { return this.name; }

	/**
	 * Get the location where the configuration file is stored.
	 * 
	 * @return Returns the location where the configuration file is stored.
	 */
	public String getLocation() { return this.location; }

	/**
	 * Get the configuration settings of this project.
	 * 
	 * @return Returns the configuration settings related to this project.
	 */
	public Configuration getConfiguration() { return this.config; }
}
