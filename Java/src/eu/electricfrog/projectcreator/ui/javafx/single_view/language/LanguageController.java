package eu.electricfrog.projectcreator.ui.javafx.single_view.language;

import eu.electricfrog.projectcreator.core.models.ProgrammingLanguage;
import eu.electricfrog.projectcreator.ui.javafx.JavaFXController;

/**
 * A controller to display the settings of a single Programming Language.
 * @author ScrapsBits
 * @since 1.1
 * @version 1.1
 */
public abstract class LanguageController extends JavaFXController {
	/**
	 * The programming language to be displayed on the User Interface.
	 */
	private ProgrammingLanguage language;
	
	/**
	 * Link the provided programming language to the controller.
	 * @param language The language from which the settings need to be displayed.
	 */
	protected LanguageController(ProgrammingLanguage language) {
		super();
		this.language = language;
	}
	
	/**
	 * Get the language linked to the User Interface.
	 * @return Returns the reference to the linked Programming Language.
	 */
	public final ProgrammingLanguage language() {
		return this.language;
	}
}
