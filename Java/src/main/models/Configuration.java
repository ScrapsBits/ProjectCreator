package main.models;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import main.core.enumerations.ProgrammingLanguage;
import main.core.files.enumerations.FileStructure;
import main.core.files.read.ConfigFileReader;
import main.core.files.read.ProjectCreatorFileReader;
import main.core.files.write.ConfigFileWriter;
import main.core.files.write.ProjectCreatorFileWriter;

/**
 * Keep track of the various settings turned off and on by user input.
 *
 * @author ScrapsBits
 */
public final class Configuration {
	/**
	 * Read and write the configuration using this structure.
	 */
	private final FileStructure fileStructure;
	/**
	 * A list of all programming languages of which to make a software project.
	 */
	private final List<ProgrammingLanguage> selectedProgrammingLanguage;

	/**
	 * Initialize configuration settings.
	 */
	public Configuration() {
		this.selectedProgrammingLanguage = new ArrayList<>();
		this.fileStructure = FileStructure.XML;
	}

	/**
	 * Initialize configuration settings from a configuration source.
	 *
	 * @param project                      The project object keeping the name and location of a project.
	 * @param selectedProgrammingLanguages The various programming languages that have been selected in the source.
	 */
	public Configuration(final List<ProgrammingLanguage> selectedProgrammingLanguages) {
		this();
		if(selectedProgrammingLanguages != null) Collections.copy(this.selectedProgrammingLanguage, selectedProgrammingLanguages);
	}

	/**
	 * Add a new language to the list of programming languages.
	 *
	 * @param  programmingLanguage      The language added to the list.
	 * @throws IllegalArgumentException Thrown when the language is unknown or when it's marked as "not supported".
	 */
	public void addProgrammingLanguage(final ProgrammingLanguage programmingLanguage) {
		if(programmingLanguage.equals(ProgrammingLanguage.UNKNOWN))
			throw new IllegalArgumentException("Cannot add UNKNOWN. Please select another language.");
		else if(!programmingLanguage.isSupported()) throw new IllegalArgumentException("Cannot add unsupported language " + programmingLanguage.getName() + ".");

		this.selectedProgrammingLanguage.add(programmingLanguage);
	}

	/**
	 * Get the file structure used by the files for this configuration.
	 *
	 * @return Returns the file structure of this configuration file.
	 */
	public FileStructure getFileStructure() { return this.fileStructure; }

	/**
	 * Get a list of selected programming languages.
	 *
	 * @return Returns a list of selected programming languages.
	 */
	public List<ProgrammingLanguage> getSelectedProgrammingLanguages() { return this.selectedProgrammingLanguage; }

	public Configuration read(final String location) throws FileNotFoundException {
		try {
			final ProjectCreatorFileReader configReader = new ConfigFileReader(location, this.fileStructure);
			return (Configuration)configReader.read();
		} catch(final FileNotFoundException e) {
			throw new FileNotFoundException("Could not read configuration file.");
		}
	}

	/**
	 * Remove a language from the list of programming languages.
	 *
	 * @param programmingLanguage The language added to the list.
	 */
	public void removeProgrammingLanguage(final ProgrammingLanguage programmingLanguage) { this.selectedProgrammingLanguage.remove(programmingLanguage); }

	/**
	 * Safe the configuration into a file at the provided location.
	 *
	 * @throws IllegalArgumentException Thrown when the provided input is invalid.
	 */
	public void safe(final String location) {
		if(this.validate()) {
			// TODO: Write the configuration information into a file.
			final ProjectCreatorFileWriter fileWriter = new ConfigFileWriter(this, location);
			fileWriter.write();
		} else
			throw new IllegalArgumentException("Could not write file. Please make sure the given input is valid.");
	}

	/**
	 * Set the list of programming languages.
	 *
	 * @param selectedProgrammingLanguages The list of programming languages.
	 */
	public void setSelectedProgrammingLanguages(final List<ProgrammingLanguage> selectedProgrammingLanguages) {
		if(selectedProgrammingLanguages != null && selectedProgrammingLanguages.size() > 0) {
			this.selectedProgrammingLanguage.clear();
			Collections.copy(this.selectedProgrammingLanguage, selectedProgrammingLanguages);
		}
	}

	/**
	 * Validate if all input follows the expected pattern.
	 *
	 * @return Returns true if the configuration is valid. Returns false if any input is invalid.
	 */
	public boolean validate() {
		boolean isValid = true;
		try {
			if(this.selectedProgrammingLanguage.size() < 1) throw new IllegalArgumentException("At least one programming language must be selected.");
		} catch(final IllegalArgumentException e) {
			System.out.println(e.getMessage()); // TODO: Replace with log component.
			isValid = false;
		}
		return isValid;
	}
}
