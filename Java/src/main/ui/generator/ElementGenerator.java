package main.ui.generator;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;

/**
 * Generate elements for the UI.
 * @author ScrapsBits
 *
 */
public final class ElementGenerator {
	/**
	 * Instantiate the element generator.
	 */
	public ElementGenerator() {}
	
	public TabPane generateTabMenu() {
		TabPane tabPane = generateTabPane();
		List<Tab> tabs = new ArrayList<>();
		
		Tab initializeTab = generateTab("Start");
		tabs.add(initializeTab);
		
		Tab programmingTab = generateTab("Programming");
		tabs.add(programmingTab);
		
		Tab documentationTab = generateTab("Documentation");
		documentationTab.setDisable(true);
		tabs.add(documentationTab);
		
		Tab diagramsTab = generateTab("Diagrams");
		diagramsTab.setDisable(true);
		tabs.add(diagramsTab);
		
		Tab additionalSourcesTab = generateTab("Additional Sources");
		additionalSourcesTab.setDisable(true);
		tabs.add(additionalSourcesTab);
		
		Tab completeTab = generateTab("Complete");
		tabs.add(completeTab);
		
		tabPane.getTabs().addAll(tabs);
		return tabPane;
	}
	
	public StackPane generateStackPane() {
		StackPane stackPane = new StackPane();
		return stackPane;
	}
	
	public Button generateButton() {
		Button button = new Button();
		return button;
	}
	
	public TabPane generateTabPane() {
		TabPane tabPane = new TabPane();
		return tabPane;
	}
	
	public Tab generateTab(String name) {
		Tab tab = new Tab(name);
		tab.setClosable(false);
		tab.setDisable(false);
		return tab;
	}
	
	public AnchorPane generateAnchorPane() {
		AnchorPane anchorPane = new AnchorPane();
		return anchorPane;
	}
	
	public Label generateLabel() {
		Label label = new Label();
		return label;
	}
	
	public TextField generateTextField() {
		TextField textField = new TextField();
		return textField;
	}
	
	public CheckBox generateTextBox() {
		CheckBox checkBox = new CheckBox();
		return checkBox;
	}
}
