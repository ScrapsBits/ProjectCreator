package main.ui.controllers;

/**
 * Hold fields and values important to all controllers.
 * @author ScrapsBits
 *
 */
public abstract class Controller {
	
	/**
	 * Initialize a controller with default settings.
	 */
	protected Controller() {
	}
	
	/**
	 * Perform default initialization processes.
	 */
	protected void initialize() {
		System.out.println("Initializing user interface..."); // TODO: Replace with log component.
	}
}
