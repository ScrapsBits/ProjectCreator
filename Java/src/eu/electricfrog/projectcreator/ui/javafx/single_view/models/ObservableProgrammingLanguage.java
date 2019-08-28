package eu.electricfrog.projectcreator.ui.javafx.single_view.models;

import eu.electricfrog.projectcreator.core.models.ProgrammingLanguage;
import eu.electricfrog.projectcreator.core.models.ProgrammingLanguageType;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;

/**
 * Extend the ProgrammingLanguage model to allow the user interface to mark it as checked.
 * 
 * @author  ScrapsBits
 * @version 1.0
 */
public class ObservableProgrammingLanguage extends ProgrammingLanguage {
	/**
	 * Keep track of the observable property.
	 */
	private final BooleanProperty isChecked = new SimpleBooleanProperty();

	/**
	 * Initialize the ProgrammingLanguage object and set the checkmark for this object to false.
	 * 
	 * @param name    The name of the programming language.
	 * @param version The programming language version.
	 * @param type    The type of language this is.
	 */
	public ObservableProgrammingLanguage(final String name, final String version, final ProgrammingLanguageType type) {
		super(name, version, type);
		this.isChecked.set(false);
	}

	/**
	 * Get the reference to the boolean property.
	 * 
	 * @return Returns a reference to the boolean property.
	 */
	public final BooleanProperty getObservableProperty() { return this.isChecked; }

	/**
	 * Read if the language is checked.
	 * 
	 * @return Returns true if the language has been checked. Returns false if it has not been checked.
	 */
	public final boolean isChecked() { return this.isChecked.get(); }
}
