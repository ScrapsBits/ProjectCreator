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
import main.models.Configuration;
import main.ui.enumerations.MenuItems;
import main.ui.enumerations.ProgrammingLanguages;
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

	private CheckBox generateCheckBox(final String id, final String text) {
		final CheckBox checkBox = new CheckBox();
		checkBox.setId(UIElements.CHECKBOX.getPrefix() + id);
		checkBox.setText(text);
		checkBox.setAllowIndeterminate(false);
		return checkBox;
	}

	private CheckBox generateCheckBox(final String id, final String text, final boolean isChecked) {
		final CheckBox checkBox = generateCheckBox(id, text);
		checkBox.setSelected(isChecked);
		return checkBox;
	}

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

	public AnchorPane generateFinalizeTabContent(final Tab tab) {
		if(!tab.isDisabled()) {
			System.out.println("Generating Finalization tab components."); // TODO: Replace with log component.
			final AnchorPane anchorPane = (AnchorPane)tab.getContent();
			final List<Node> nodes = new ArrayList<>();
			System.out.println("Generating Button components."); // TODO: Replace with log component.
			nodes.add(generateButton("Finalize", "Create projects"));

			anchorPane.getChildren().addAll(nodes);
			return anchorPane;
		}
		return (AnchorPane)tab.getContent();
	}

	private Label generateLabel(final String id, final String text) {
		final Label label = new Label();
		label.setId(UIElements.LABEL.getPrefix() + id);
		label.setText(text);
		label.setWrapText(true);
		return label;
	}

	public AnchorPane generateProgrammingTabContent(final Tab tab) {
		if(!tab.isDisabled()) {
			System.out.println("Generating Programming tab components.");
			final AnchorPane anchorPane = (AnchorPane)tab.getContent();
			final List<Node> nodes = new ArrayList<>();

			System.out.println("Generating StackPane components."); // TODO: Replace with log component.
			nodes.add(generateStackPane("ProgrammingLanguages"));

			System.out.println("Generating Label components."); // TODO: Replace with log component.
			nodes.add(generateLabel("Functional", "Functional Languages"));
			nodes.add(generateLabel("ObjectOriented", "Object Oriented Languages"));

			System.out.println("Generating CheckBox components."); // TODO: Replace with log component.
			for(final ProgrammingLanguages language : ProgrammingLanguages.values()) {
				try {
					nodes.add(generateCheckBox(language.getId(), language.getName(), this.config.getSelectedProgrammingLanguages().contains(language)));
				} catch(NullPointerException e) {
					nodes.add(generateCheckBox(language.getId(), language.getName()));
				}
			}

			anchorPane.getChildren().addAll(nodes);
			return anchorPane;
		}
		return (AnchorPane)tab.getContent();
	}

	public AnchorPane generateProjectTabContent(final Tab tab) {
		if(!tab.isDisabled()) {
			System.out.println("Generating Project tab components."); // TODO: Replace with log component.
			final AnchorPane anchorPane = (AnchorPane)tab.getContent();
			final List<Node> nodes = new ArrayList<>();

			System.out.println("Generating StackPane components."); // TODO: Replace with log component.
			nodes.add(generateStackPane("GenerationOptions"));

			System.out.println("Generating Label components."); // TODO: Replace with log component.
			nodes.add(generateLabel("ProjectName", "Name: "));
			nodes.add(generateLabel("ProjectLocation", "Location (Default): "));
			nodes.add(generateLabel("ProjectGenerationOptions", "Create files for: "));

			System.out.println("Generating TextField components."); // TODO: Replace with log component.
			try {
				nodes.add(generateTextField("ProjectName", "My New Project", this.config.getProjectName()));
			} catch(NullPointerException e) {
				nodes.add(generateTextField("ProjectName", "My New Project"));
			} finally {
				nodes.add(generateTextField("ProjectLocation", "Documents/"));
			}

			System.out.println("Generating CheckBox components."); // TODO: Replace with log component.
			nodes.add(generateCheckBox("Programming", "Programming", true));
			nodes.add(generateCheckBox("Documentation", "Documentation"));
			nodes.add(generateCheckBox("Diagrams", "Diagrams"));
			nodes.add(generateCheckBox("AdditionalSources", "Other"));

			System.out.println("Generating Button components."); // TODO: Replace with log component.
			nodes.add(generateButton("Location", "Select Folder"));

			anchorPane.getChildren().addAll(nodes);
			return anchorPane;
		}
		return (AnchorPane)tab.getContent();
	}

	private StackPane generateStackPane(final String id) {
		final StackPane stackPane = new StackPane();
		stackPane.setId(UIElements.STACKPANE.getPrefix() + id);
		return stackPane;
	}

	private Tab generateTab(final String id, final String name, final boolean isDisabled) {
		final Tab tab = new Tab();
		tab.setId(UIElements.TAB.getPrefix() + id);
		tab.setText(name);
		tab.setClosable(false);
		tab.setDisable(isDisabled);
		tab.setContent(generateAnchorPane(id));
		return tab;
	}

	/**
	 * Generate the tab menu.
	 *
	 * @return Returns a menu of various empty tabs.
	 */
	public TabPane generateTabMenu() {
		final TabPane tabPane = generateTabPane("Menu");

		// Generate and add all tabs to the tab pane.
		final List<Tab> tabs = new ArrayList<>();
		for(final MenuItems menuItem : MenuItems.values()) {
			final Tab generateTab = generateTab(menuItem.getId(), menuItem.getName(), !menuItem.isSupported());
			tabs.add(generateTab);
			System.out.println("Generated tab " + menuItem.getName() + "."); // TODO: Replace with log component.
		}
		tabPane.getTabs().addAll(tabs);

		return tabPane;
	}

	private TabPane generateTabPane(final String id) {
		final TabPane tabPane = new TabPane();
		tabPane.setId(UIElements.TABPANE.getPrefix() + id);
		return tabPane;
	}

	private TextField generateTextField(final String id, final String promptText) {
		final TextField textField = new TextField();
		textField.setId(UIElements.TEXTFIELD.getPrefix() + id);
		textField.setPromptText(promptText);
		return textField;
	}

	private TextField generateTextField(final String id, final String promptText, final String text) {
		final TextField textField = this.generateTextField(id, promptText);
		textField.setText(text);
		return textField;
	}
}
