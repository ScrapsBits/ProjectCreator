package main.models;

/**
 * Represents a project stored on the client's computer.
 *
 * @author ScrapsBits
 */
public class Project {
	/**
	 * Keep track of the configuration of the project.
	 */
	private final Configuration config;
	/**
	 * The location where the project configuration can be found.
	 */
	private final String location;

	/**
	 * The name given to the project by the client.
	 */
	private final String name;

	/**
	 * Represents a project as stored on the client's computer.
	 *
	 * @param name     The name of the project.
	 * @param location The location where the project configuration is stored.
	 */
	public Project(final String name, final String location) { this(name, location, new Configuration()); }

	/**
	 * Represents a project as stored on the client's computer.
	 *
	 * @param name     The name of the project.
	 * @param location The location where the project configuration is stored.
	 * @param config   The configuration settings of the project.
	 */
	public Project(final String name, final String location, final Configuration config) {
		this.name = name;
		this.location = location;
		this.config = config;
	}

	/**
	 * Get the configuration settings of this project.
	 *
	 * @return Returns the configuration settings related to this project.
	 */
	public Configuration getConfiguration() { return this.config; }

	/**
	 * Get the location where the configuration file is stored.
	 *
	 * @return Returns the location where the configuration file is stored.
	 */
	public String getLocation() { return this.location; }

	/**
	 * Get the name of the project.
	 *
	 * @return Returns the name of the project.
	 */
	public String getName() { return this.name; }
}
