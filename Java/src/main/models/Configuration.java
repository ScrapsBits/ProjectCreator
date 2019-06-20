package main.models;

import java.util.ArrayList;
import java.util.List;

import main.ui.generator.enumerations.ProgrammingLanguages;

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

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	/**
	 * Initialize configuration settings.
	 */
	public Configuration() {
		selectedProgrammingLanguages = new ArrayList<>();
	}

	public List<ProgrammingLanguages> getSelectedProgrammingLanguages() {
		return selectedProgrammingLanguages;
	}

	public void setSelectedProgrammingLanguages(List<ProgrammingLanguages> selectedProgrammingLanguages) {
		this.selectedProgrammingLanguages = selectedProgrammingLanguages;
	}
}
