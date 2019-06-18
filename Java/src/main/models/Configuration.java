package main.models;

import java.util.ArrayList;
import java.util.List;

import main.enums.SupportedProgrammingLanguages;

/**
 * Keep track of the various settings turned off and on by user input.
 * @author Scraps
 *
 */
public final class Configuration {
	/**
	 * The name provided by the user to give to the projects created.
	 */
	private String projectName;
	/**
	 * A list of all programming languages of which to make a software project.
	 */
	private List<SupportedProgrammingLanguages> selectedProgrammingLanguages;
	
	/**
	 * Initialize configuration settings.
	 */
	public Configuration() {
		selectedProgrammingLanguages = new ArrayList<>();
	}
}
