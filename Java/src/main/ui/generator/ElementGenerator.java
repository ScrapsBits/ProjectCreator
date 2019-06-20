package main.ui.generator;

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
import main.ui.generator.enumerations.MenuItems;
import main.ui.generator.enumerations.UserInterfaceElements;

/**
 * Generate elements for the UI.
 * 
 * @author ScrapsBits
 *
 */
public final class ElementGenerator {
	/**
	 * Instantiate the element generator.
	 */
	public ElementGenerator() {
	}

	/**
	 * Generate the tab menu.
	 * 
	 * @return Returns a menu of various empty tabs.
	 */
	public TabPane generateTabMenu() {
		TabPane tabPane = generateTabPane("Menu");

		// Generate and add all tabs to the tab pane.
		List<Tab> tabs = new ArrayList<>();
		for (MenuItems menuItem : MenuItems.values()) {
			Tab generateTab = generateTab(menuItem.getId(), menuItem.getName(), !menuItem.isSupported());
			tabs.add(generateTab);
			System.out.println("Generated tab " + menuItem.getName() + "."); // TODO: Replace with log component.
		}
		tabPane.getTabs().addAll(tabs);

		return tabPane;
	}

	public AnchorPane generateProjectTabContent(Tab tab) {
		System.out.println("Generating Project tab components.");
		AnchorPane anchorPane = (AnchorPane) tab.getContent();
		List<Node> nodes = new ArrayList<>();

		System.out.println("Generating StackPane components.");
		nodes.add(generateStackPane("stpGenerationOptions"));
		
		System.out.println("Generating Label components.");
		nodes.add(generateLabel("lblProjectName", "Name: "));
		nodes.add(generateLabel("lblProjectLocation", "Location (Default): "));
		nodes.add(generateLabel("lblProjectGenerationOptions", "Create files for: "));
		
		System.out.println("Generating TextField components.");
		nodes.add(generateTextField("txfProjectName", "My New Project"));
		
		System.out.println("Generating CheckBox components.");
		nodes.add(generateCheckBox("chbProgramming", "Programming", true));
		nodes.add(generateCheckBox("chbDocumentation", "Documentation"));
		nodes.add(generateCheckBox("chbDiagrams", "Diagrams"));
		
		System.out.println("Generating Button components.");
		nodes.add(generateButton("btnLocation", "Select Folder"));
		
		anchorPane.getChildren().addAll(nodes);
		return anchorPane;
	}

	public AnchorPane generateProgrammingTabContent(Tab tab) {
		System.out.println("Generating Programming tab components.");
		AnchorPane anchorPane = (AnchorPane) tab.getContent();
		List<Node> nodes = new ArrayList<>();
		
		System.out.println("Generating StackPane components.");
		nodes.add(generateStackPane("stpProgrammingLanguages"));
		
		System.out.println("Generating Label components.");
		
		System.out.println("Generating TextField components.");
		
		System.out.println("Generating Button components.");
		
		anchorPane.getChildren().addAll(nodes);
		return anchorPane;
	}

	public AnchorPane generateDocumentationTabContent(Tab tab) {
		System.out.println("Generating Documentation tab components.");
		AnchorPane anchorPane = (AnchorPane) tab.getContent();
		List<Node> nodes = new ArrayList<>();
		
		System.out.println("Generating StackPane components.");
		
		System.out.println("Generating Label components.");
		
		System.out.println("Generating TextField components.");
		
		System.out.println("Generating Button components.");
		
		anchorPane.getChildren().addAll(nodes);
		return anchorPane;
	}

	public AnchorPane generateDiagramsTabContent(Tab tab) {
		System.out.println("Generating Diagrams tab components.");
		AnchorPane anchorPane = (AnchorPane) tab.getContent();
		List<Node> nodes = new ArrayList<>();
		
		System.out.println("Generating StackPane components.");
		
		System.out.println("Generating Label components.");
		
		System.out.println("Generating TextField components.");
		
		System.out.println("Generating Button components.");
		
		anchorPane.getChildren().addAll(nodes);		
		return anchorPane;
	}

	public AnchorPane generateAdditionalSourcesTabContent(Tab tab) {
		System.out.println("Generating Additional Sources tab components.");
		AnchorPane anchorPane = (AnchorPane) tab.getContent();
		List<Node> nodes = new ArrayList<>();
		
		System.out.println("Generating StackPane components.");
		
		System.out.println("Generating Label components.");
		
		System.out.println("Generating TextField components.");
		
		System.out.println("Generating Button components.");
		
		anchorPane.getChildren().addAll(nodes);
		return anchorPane;
	}

	public AnchorPane generateFinalizeTabContent(Tab tab) {
		System.out.println("Generating Finalization tab components.");
		AnchorPane anchorPane = (AnchorPane) tab.getContent();
		List<Node> nodes = new ArrayList<>();
		
		System.out.println("Generating StackPane components.");
		
		System.out.println("Generating Label components.");
		
		System.out.println("Generating TextField components.");
		
		System.out.println("Generating Button components.");
		
		anchorPane.getChildren().addAll(nodes);
		return anchorPane;
	}

	private StackPane generateStackPane(String id) {
		StackPane stackPane = new StackPane();
		stackPane.setId(UserInterfaceElements.STACKPANE.getPrefix() + id);
		return stackPane;
	}

	private Button generateButton(String id, String text) {
		Button button = new Button();
		button.setId(UserInterfaceElements.BUTTON.getPrefix() + id);
		button.setText(text);
		return button;
	}

	private TabPane generateTabPane(String id) {
		TabPane tabPane = new TabPane();
		tabPane.setId(UserInterfaceElements.TABPANE.getPrefix() + id);
		return tabPane;
	}
	
	private Tab generateTab(String id, String name, boolean isDisabled) {
		Tab tab = new Tab();
		tab.setId(UserInterfaceElements.TAB.getPrefix() + id);
		tab.setText(name);
		tab.setClosable(false);
		tab.setDisable(isDisabled);
		tab.setContent(generateAnchorPane(id));
		return tab;
	}
	
	private AnchorPane generateAnchorPane(String id) {
		AnchorPane anchorPane = new AnchorPane();
		anchorPane.setId(UserInterfaceElements.ANCHORPANE.getPrefix() + id);
		return anchorPane;
	}

	private Label generateLabel(String id, String text) {
		Label label = new Label();
		label.setId(UserInterfaceElements.LABEL.getPrefix() + id);
		label.setText(text);
		return label;
	}

	private TextField generateTextField(String id, String promptText) {
		TextField textField = new TextField();
		textField.setId(UserInterfaceElements.TEXTFIELD.getPrefix() + id);
		textField.setPromptText(promptText);
		return textField;
	}

	private CheckBox generateCheckBox(String id, String text) {
		CheckBox checkBox = new CheckBox();
		checkBox.setId(UserInterfaceElements.CHECKBOX.getPrefix() + id);
		checkBox.setText(text);
		return checkBox;
	}
	
	private CheckBox generateCheckBox(String id, String text, boolean isChecked) {
		CheckBox checkBox = generateCheckBox(id, text);
		checkBox.setSelected(isChecked);
		return checkBox;
	}
}
