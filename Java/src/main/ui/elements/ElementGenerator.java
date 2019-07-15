package main.ui.elements;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import main.core.enumerations.ProgrammingLanguage;
import main.models.Configuration;
import main.ui.enumerations.MenuItems;
import main.ui.enumerations.UIElements;

/**
 * Generate elements for the UI.
 *
 * @author ScrapsBits
 */
public final class ElementGenerator {

	/**
	 * Store a reference to the config object.
	 */
	private final Configuration config;

	/**
	 * Instantiate the element generator.
	 */
	public ElementGenerator(final Configuration config) { this.config = config; }

	/**
	 * Generate and populate content for the Additional Sources tab.
	 *
	 * @param  tab The tab "AdditionalSources".
	 * @return     Returns the child AnchorPane of the AdditionalSources tab.
	 */
	public AnchorPane generateAdditionalSourcesTabContent(final Tab tab) {
		if(!tab.isDisabled()) {
			System.out.println("Generating Additional Sources tab components."); // TODO: Replace with log component.
			final AnchorPane anchorPane = (AnchorPane)tab.getContent();
			final List<Node> nodes = new ArrayList<>();
			// TODO: Generate elements for the Additional Sources tab.
			anchorPane.getChildren().addAll(nodes);
			return anchorPane;
		}
		return (AnchorPane)tab.getContent();
	}

	/**
	 * Generate an AnchorPane element.
	 *
	 * @param  id The (unique) ID name of the AnchorPane.
	 * @return    Returns an AnchorPane element.
	 */
	private AnchorPane generateAnchorPane(final String id) {
		final AnchorPane anchorPane = new AnchorPane();
		anchorPane.setId(UIElements.ANCHORPANE.getPrefix() + id);
		return anchorPane;
	}

	/**
	 * Generate a Button element.
	 *
	 * @param  id   The (unique) ID name of the Button.
	 * @param  text The text to display on the button.
	 * @return      Returns a Button element.
	 */
	private Button generateButton(final String id, final String text) {
		final Button button = new Button();
		button.setId(UIElements.BUTTON.getPrefix() + id);
		button.setText(text);
		return button;
	}

	/**
	 * Generate a CheckBox element.
	 *
	 * @param  id   The (unique) ID name of the CheckBox.
	 * @param  text The text to display with the checkbox.
	 * @return      Returns a CheckBox element.
	 */
	private CheckBox generateCheckBox(final String id, final String text) {
		final CheckBox checkBox = new CheckBox();
		checkBox.setId(UIElements.CHECKBOX.getPrefix() + id);
		checkBox.setText(text);
		checkBox.setAllowIndeterminate(false);
		return checkBox;
	}

	/**
	 * Generate a CheckBox element.
	 *
	 * @param  id        The (unique) ID name of the CheckBox.
	 * @param  text      The text to display with the checkbox.
	 * @param  isChecked Define if the checkbox has to be checked or not.
	 * @return           Returns a CheckBox element.
	 */
	private CheckBox generateCheckBox(final String id, final String text, final boolean isChecked) {
		final CheckBox checkBox = this.generateCheckBox(id, text);
		checkBox.setSelected(isChecked);
		return checkBox;
	}

	/**
	 * Generate content for the Diagrams tab.
	 *
	 * @param  tab The Diagrams tab.
	 * @return     Returns the AnchorPane to be placed on the Diagrams tab.
	 */
	public AnchorPane generateDiagramsTabContent(final Tab tab) {
		if(!tab.isDisabled()) {
			System.out.println("Generating Diagrams tab components."); // TODO: Replace with log component.
			final AnchorPane anchorPane = (AnchorPane)tab.getContent();
			final List<Node> nodes = new ArrayList<>();
			anchorPane.getChildren().addAll(nodes);
			return anchorPane;
		}
		return (AnchorPane)tab.getContent();
	}

	/**
	 * Generate content for the Documentation tab.
	 *
	 * @param  tab The Documentation tab.
	 * @return     Returns the AnchorPane to be placed on the Documentation tab.
	 */
	public AnchorPane generateDocumentationTabContent(final Tab tab) {
		if(!tab.isDisabled()) {
			System.out.println("Generating Documentation tab components."); // TODO: Replace with log component.
			final AnchorPane anchorPane = (AnchorPane)tab.getContent();
			final List<Node> nodes = new ArrayList<>();
			anchorPane.getChildren().addAll(nodes);
			return anchorPane;
		}
		return (AnchorPane)tab.getContent();
	}

	/**
	 * Generate content for the Finalize tab.
	 *
	 * @param  tab The Finalize tab.
	 * @return     Returns the AnchorPane to be placed on the Finalize tab.
	 */
	public AnchorPane generateFinalizeTabContent(final Tab tab) {
		if(!tab.isDisabled()) {
			System.out.println("Generating Finalization tab components."); // TODO: Replace with log component.
			final AnchorPane anchorPane = (AnchorPane)tab.getContent();
			final List<Node> nodes = new ArrayList<>();
			System.out.println("Generating Button components."); // TODO: Replace with log component.
			nodes.add(this.generateButton("Finalize", "Create projects"));

			anchorPane.getChildren().addAll(nodes);
			return anchorPane;
		}
		return (AnchorPane)tab.getContent();
	}

	/**
	 * Generate a Label element.
	 *
	 * @param  id   The (unique) ID name of the Label.
	 * @param  text The text to display with the label.
	 * @return      Returns a Label element.
	 */
	private Label generateLabel(final String id, final String text) {
		final Label label = new Label();
		label.setId(UIElements.LABEL.getPrefix() + id);
		label.setText(text);
		label.setWrapText(true);
		return label;
	}

	/**
	 * Generate content for the Programming tab.
	 *
	 * @param  tab The Programming tab.
	 * @return     Returns the AnchorPane to be placed on the Programming tab.
	 */
	public AnchorPane generateProgrammingTabContent(final Tab tab) {
		if(!tab.isDisabled()) {
			System.out.println("Generating Programming tab components.");
			final AnchorPane anchorPane = (AnchorPane)tab.getContent();
			final List<Node> nodes = new ArrayList<>();

			System.out.println("Generating StackPane components."); // TODO: Replace with log component.
			nodes.add(this.generateStackPane("ProgrammingLanguages"));

			System.out.println("Generating Label components."); // TODO: Replace with log component.
			nodes.add(this.generateLabel("Functional", "Functional Languages"));
			nodes.add(this.generateLabel("ObjectOriented", "Object Oriented Languages"));

			System.out.println("Generating CheckBox components."); // TODO: Replace with log component.
			for(final ProgrammingLanguage language : ProgrammingLanguage.values()) if(language != ProgrammingLanguage.UNKNOWN) try {
				nodes.add(this.generateCheckBox(language.getId(), language.getName(), this.config.getSelectedProgrammingLanguages().contains(language)));
			} catch(final NullPointerException e) {
				nodes.add(this.generateCheckBox(language.getId(), language.getName()));
			}

			anchorPane.getChildren().addAll(nodes);
			return anchorPane;
		}
		return (AnchorPane)tab.getContent();
	}

	/**
	 * Generate content for the Project tab.
	 *
	 * @param  tab The Project tab.
	 * @return     Returns the AnchorPane to be placed on the Project tab.
	 */
	public AnchorPane generateProjectTabContent(final Tab tab) {
		if(!tab.isDisabled()) {
			System.out.println("Generating Project tab components."); // TODO: Replace with log component.
			final AnchorPane anchorPane = (AnchorPane)tab.getContent();
			final List<Node> nodes = new ArrayList<>();

			System.out.println("Generating StackPane components."); // TODO: Replace with log component.
			nodes.add(this.generateStackPane("GenerationOptions"));

			System.out.println("Generating Label components."); // TODO: Replace with log component.
			nodes.add(this.generateLabel("ProjectName", "Name: "));
			nodes.add(this.generateLabel("ProjectLocation", "Location (Default): "));
			nodes.add(this.generateLabel("ProjectGenerationOptions", "Create files for: "));

			System.out.println("Generating TextField components."); // TODO: Replace with log component.
			try {
				nodes.add(this.generateTextField("ProjectName", "My New Project", this.config.getProjectName()));
			} catch(final NullPointerException e) {
				nodes.add(this.generateTextField("ProjectName", "My New Project"));
			} finally {
				nodes.add(this.generateTextField("ProjectLocation", "Documents/"));
			}

			System.out.println("Generating CheckBox components."); // TODO: Replace with log component.
			nodes.add(this.generateCheckBox("Programming", "Programming", true));
			nodes.add(this.generateCheckBox("Documentation", "Documentation"));
			nodes.add(this.generateCheckBox("Diagrams", "Diagrams"));
			nodes.add(this.generateCheckBox("AdditionalSources", "Other"));

			System.out.println("Generating Button components."); // TODO: Replace with log component.
			nodes.add(this.generateButton("Location", "Select Folder"));

			anchorPane.getChildren().addAll(nodes);
			return anchorPane;
		}
		return (AnchorPane)tab.getContent();
	}

	/**
	 * Generate a StackPane element.
	 *
	 * @param  id The (unique) ID name of the StackPane.
	 * @return    Returns a StackPane element.
	 */
	private StackPane generateStackPane(final String id) {
		final StackPane stackPane = new StackPane();
		stackPane.setId(UIElements.STACKPANE.getPrefix() + id);
		return stackPane;
	}

	/**
	 * Generate a Tab element.
	 *
	 * @param  id         The (unique) ID name of the Tab.
	 * @param  name       The text to display with the label.
	 * @param  isDisabled Define if the tab is disabled.
	 * @return            Returns a Tab element.
	 */
	private Tab generateTab(final String id, final String name, final boolean isDisabled) {
		final Tab tab = new Tab();
		tab.setId(UIElements.TAB.getPrefix() + id);
		tab.setText(name);
		tab.setClosable(false);
		tab.setDisable(isDisabled);
		tab.setContent(this.generateAnchorPane(id));
		return tab;
	}

	/**
	 * Generate the tab menu.
	 *
	 * @return Returns a menu of various empty tabs.
	 */
	public TabPane generateTabMenu() {
		final TabPane tabPane = this.generateTabPane("Menu");

		// Generate and add all tabs to the tab pane.
		final List<Tab> tabs = new ArrayList<>();
		for(final MenuItems menuItem : MenuItems.values()) {
			final Tab generateTab = this.generateTab(menuItem.getId(), menuItem.getName(), !menuItem.isSupported());
			tabs.add(generateTab);
			System.out.println("Generated tab " + menuItem.getName() + "."); // TODO: Replace with log component.
		}
		tabPane.getTabs().addAll(tabs);

		return tabPane;
	}

	/**
	 * Generate a TabPane element.
	 *
	 * @param  id The (unique) ID name of the TabPane.
	 * @return    Returns a TabPane element.
	 */
	private TabPane generateTabPane(final String id) {
		final TabPane tabPane = new TabPane();
		tabPane.setId(UIElements.TABPANE.getPrefix() + id);
		return tabPane;
	}

	/**
	 * Generate a TextField element.
	 *
	 * @param  id         The (unique) ID name of the TextField.
	 * @param  promptText The text to display with the label when it has no value.
	 * @return            Returns a TextField element.
	 */
	private TextField generateTextField(final String id, final String promptText) {
		final TextField textField = new TextField();
		textField.setId(UIElements.TEXTFIELD.getPrefix() + id);
		textField.setPromptText(promptText);
		return textField;
	}

	/**
	 * Generate a TextField element.
	 *
	 * @param  id         The (unique) ID name of the TextField.
	 * @param  promptText The text to display with the label when it has no value.
	 * @param  text       The text to display with the label.
	 * @return            Returns a TextField element.
	 */
	private TextField generateTextField(final String id, final String promptText, final String text) {
		final TextField textField = this.generateTextField(id, promptText);
		textField.setText(text);
		return textField;
	}
}
