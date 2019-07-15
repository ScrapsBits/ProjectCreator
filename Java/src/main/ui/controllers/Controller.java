package main.ui.controllers;

import main.models.Configuration;

/**
 * Hold fields and values important to all controllers.
 *
 * @author ScrapsBits
 */
public abstract class Controller {

	protected Configuration config;

	/**
	 * Initialize a controller with default settings.
	 */
	protected Controller() { this.config = new Configuration(); }

	/**
	 * Perform default initialization processes.
	 */
	protected void initialize() {
		try {
			// TODO: Read CONFIG file.
			System.out.println("Attempting to read .config file at the default location."); // TODO: Replace with log component.
			// TODO: Fill configuration values.
			throw new UnsupportedOperationException();
		} catch(Exception e) {
			System.out.println("No .config file found. Proceeding with default values."); // TODO: Replace with log component.
		} finally {
			System.out.println("Initializing user interface..."); // TODO: Replace with log component.
		}
	}
}
