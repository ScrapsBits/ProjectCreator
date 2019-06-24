package main.models;

import java.util.ArrayList;
import java.util.List;

import main.ui.enumerations.ProgrammingLanguages;

/**
 * Keep track of the various settings turned off and on by user input.
 *
 * @author ScrapsBits
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
	private List<ProgrammingLanguages> selectedProgrammingLanguages;

	/**
	 * Initialize configuration settings.
	 */
	public Configuration() {
		selectedProgrammingLanguages = new ArrayList<>();
	}

	public String getProjectName() {
		return projectName;
	}

	public List<ProgrammingLanguages> getSelectedProgrammingLanguages() {
		return selectedProgrammingLanguages;
	}

	public void setProjectName(final String projectName) {
		this.projectName = projectName;
	}

	public void setSelectedProgrammingLanguages(final List<ProgrammingLanguages> selectedProgrammingLanguages) {
		this.selectedProgrammingLanguages = selectedProgrammingLanguages;
	}
}
