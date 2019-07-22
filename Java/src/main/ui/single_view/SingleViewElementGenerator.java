package main.ui.single_view;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import main.core.enumerations.ProgrammingLanguage;
import main.ui.ElementGenerator;
import main.ui.enumerations.MenuItems;
import main.ui.enumerations.UIElements;

/**
 * Generate elements for the UI.
 *
 * @author ScrapsBits
 */
public final class SingleViewElementGenerator extends ElementGenerator {

	private final SingleViewController singleViewController;

	public SingleViewElementGenerator(final SingleViewController controller) {
		super(controller);
		this.singleViewController = (SingleViewController)super.getController();
	}

	/**
	 * Generate and populate content for the Additional Sources tab.
	 *
	 * @param  tab The tab "AdditionalSources".
	 * @return     Returns the child AnchorPane of the AdditionalSources tab.
	 */
	public AnchorPane generateAdditionalSourcesTabContent() {
		System.out.println("Generating Additional Sources tab components."); // TODO: Replace with log component.
		final AnchorPane anchorPane = this.generateAnchorPane("AdditionalSources");
		final List<Node> nodes = new ArrayList<>();
		// TODO: Generate elements for the Additional Sources tab.
		anchorPane.getChildren().addAll(nodes);
		return anchorPane;
	}

	/**
	 * Generate an AnchorPane element.
	 *
	 * @param  id The (unique) ID name of the AnchorPane.
	 * @return    Returns an AnchorPane element.
	 */
	protected AnchorPane generateAnchorPane(final String id) {
		final AnchorPane anchorPane = new AnchorPane();
		anchorPane.setId(UIElements.ANCHORPANE.getPrefix() + id);
		return anchorPane;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Button generateButton(final String id, final String text) {
		final Button button = new Button();
		button.setId(UIElements.BUTTON.getPrefix() + id);
		button.setText(text);
		return button;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected CheckBox generateCheckBox(final String id, final String text) {
		final CheckBox checkBox = new CheckBox();
		checkBox.setId(UIElements.CHECKBOX.getPrefix() + id);
		checkBox.setText(text);
		checkBox.setAllowIndeterminate(false);
		return checkBox;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected CheckBox generateCheckBox(final String id, final String text, final boolean isChecked) {
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
	public AnchorPane generateDiagramsTabContent() {
		System.out.println("Generating Diagrams tab components."); // TODO: Replace with log component.
		final AnchorPane anchorPane = this.generateAnchorPane("Diagrams");
		final List<Node> nodes = new ArrayList<>();
		anchorPane.getChildren().addAll(nodes);
		return anchorPane;
	}

	/**
	 * Generate content for the Documentation tab.
	 *
	 * @param  tab The Documentation tab.
	 * @return     Returns the AnchorPane to be placed on the Documentation tab.
	 */
	public AnchorPane generateDocumentationTabContent() {
		System.out.println("Generating Documentation tab components."); // TODO: Replace with log component.
		final AnchorPane anchorPane = this.generateAnchorPane("Documentation");
		final List<Node> nodes = new ArrayList<>();
		anchorPane.getChildren().addAll(nodes);
		return anchorPane;
	}

	/**
	 * Generate content for the Finalize tab.
	 *
	 * @param  tab The Finalize tab.
	 * @return     Returns the AnchorPane to be placed on the Finalize tab.
	 */
	public AnchorPane generateFinalizeTabContent() {
		System.out.println("Generating Finalization tab components."); // TODO: Replace with log component.
		final AnchorPane anchorPane = this.generateAnchorPane("Finalize");
		final List<Node> nodes = new ArrayList<>();
		System.out.println("Generating Button components."); // TODO: Replace with log component.
		final Button btnFinalize = this.generateButton("Finalize", "Create projects");
		btnFinalize.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> this.singleViewController.handleBtnFinalizeClick(event));
		nodes.add(btnFinalize);

		anchorPane.getChildren().addAll(nodes);
		return anchorPane;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Label generateLabel(final String id, final String text) {
		final Label label = new Label();
		label.setId(UIElements.LABEL.getPrefix() + id);
		label.setText(text);
		label.setWrapText(true);
		return label;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Object generateMenu(final String id) {
		final TabPane tabPane = this.generateTabPane(id);
		tabPane.getSelectionModel().selectedItemProperty().addListener((tab) -> this.singleViewController.listenMenuTabChange(tab, tabPane));

		// Generate all tabs.
		for(final MenuItems menuItem : MenuItems.values()) {
			final Tab generateTab = this.generateMenuItem(menuItem.getId(), menuItem.getName(), menuItem.isSupported());
			System.out.println("Generated tab " + menuItem.getName() + ".\nPopulating tab " + menuItem.getName() + "."); // TODO: Replace with log component.
			switch(menuItem.getId().toLowerCase()) {
				case "project":
					generateTab.setContent(this.generateProjectTabContent());
					this.singleViewController.setActiveTab(generateTab);
					break;
				case "programming":
					generateTab.setContent(this.generateProgrammingTabContent());
					break;
				case "documentation":
					generateTab.setContent(this.generateDocumentationTabContent());
					break;
				case "diagrams":
					generateTab.setContent(this.generateDiagramsTabContent());
					break;
				case "additionalSources":
					generateTab.setContent(this.generateAdditionalSourcesTabContent());
					break;
				case "finalize":
					generateTab.setContent(this.generateFinalizeTabContent());
					break;
			}
			tabPane.getTabs().add(generateTab);
		}
		System.out.println("Size tabpane: " + tabPane.getTabs().size());
		return tabPane;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Tab generateMenuItem(final String id, final String text) {
		final Tab tab = new Tab();
		tab.setId(UIElements.TAB.getPrefix() + id);
		tab.setText(text);
		tab.setClosable(false);
		tab.setContent(this.generateAnchorPane(id));
		tab.setDisable(false);
		return tab;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected Tab generateMenuItem(final String id, final String text, final boolean enabled) {
		final Tab tab = this.generateMenuItem(id, text);
		tab.setDisable(!enabled);
		return tab;
	}

	/**
	 * Generate content for the Programming tab.
	 *
	 * @param  tab The Programming tab.
	 * @return     Returns the AnchorPane to be placed on the Programming tab.
	 */
	public AnchorPane generateProgrammingTabContent() {
		System.out.println("Generating Programming tab components.");
		final AnchorPane anchorPane = this.generateAnchorPane("Programming");
		final List<Node> nodes = new ArrayList<>();

		System.out.println("Generating StackPane components."); // TODO: Replace with log component.
		nodes.add(this.generateStackPane("ProgrammingLanguages"));

		System.out.println("Generating Label components."); // TODO: Replace with log component.
		nodes.add(this.generateLabel("Functional", "Functional Languages"));
		nodes.add(this.generateLabel("ObjectOriented", "Object Oriented Languages"));

		System.out.println("Generating CheckBox components."); // TODO: Replace with log component.
		CheckBox chbLanguage = null;
		for(final ProgrammingLanguage language : ProgrammingLanguage.values()) if(language != ProgrammingLanguage.UNKNOWN) try {
			chbLanguage = this.generateCheckBox(language.getId(), language.getName(), super.getConfig().getSelectedProgrammingLanguages().contains(language));
		} catch(final NullPointerException e) {
			chbLanguage = this.generateCheckBox(language.getId(), language.getName());
		} finally {
			chbLanguage.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> this.singleViewController.handleProgrammingLanguageClick(event));
			nodes.add(chbLanguage);
		}

		anchorPane.getChildren().addAll(nodes);
		return anchorPane;
	}

	/**
	 * Generate content for the Project tab.
	 *
	 * @param  tab The Project tab.
	 * @return     Returns the AnchorPane to be placed on the Project tab.
	 */
	public AnchorPane generateProjectTabContent() {
		System.out.println("Generating Project tab components."); // TODO: Replace with log component.
		final AnchorPane anchorPane = this.generateAnchorPane("ProjectContent");
		final List<Node> nodes = new ArrayList<>();

		System.out.println("Generating StackPane components."); // TODO: Replace with log component.
		nodes.add(this.generateStackPane("GenerationOptions"));

		System.out.println("Generating Label components."); // TODO: Replace with log component.
		nodes.add(this.generateLabel("ProjectName", "Name: "));
		nodes.add(this.generateLabel("ProjectLocation", "Location (Default): "));
		nodes.add(this.generateLabel("ProjectGenerationOptions", "Create files for: "));

		System.out.println("Generating TextField components."); // TODO: Replace with log component.
		try {
			nodes.add(this.generateTextField("ProjectName", "My New Project", super.getConfig().getProjectName()));
		} catch(final NullPointerException e) {
			nodes.add(this.generateTextField("ProjectName", "My New Project"));
		} finally {
			nodes.add(this.generateTextField("ProjectLocation", "Documents/"));
		}

		System.out.println("Generating CheckBox components."); // TODO: Replace with log component.
		final CheckBox chbProgramming = this.generateCheckBox("Programming", "Programming", true);
		chbProgramming.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> this.singleViewController.handleChbProgrammingClick(event));
		nodes.add(chbProgramming);
		final CheckBox chbDocumentation = this.generateCheckBox("Documentation", "Documentation");
		chbDocumentation.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> this.singleViewController.handleChbDocumentationClick(event));
		nodes.add(chbDocumentation);
		final CheckBox chbDiagrams = this.generateCheckBox("Diagrams", "Diagrams");
		chbDiagrams.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> this.singleViewController.handleChbDiagramsClick(event));
		nodes.add(chbDiagrams);
		final CheckBox chbAdditionalSources = this.generateCheckBox("AdditionalSources", "Other");
		chbAdditionalSources.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> this.singleViewController.handleChbAdditionalSourcesClick(event));
		nodes.add(chbAdditionalSources);

		System.out.println("Generating Button components."); // TODO: Replace with log component.
		final Button btnLocation = this.generateButton("Location", "Select Folder");
		btnLocation.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> this.singleViewController.handleBtnLocationClick(event));
		nodes.add(btnLocation);
		anchorPane.getChildren().addAll(nodes);
		return anchorPane;
	}

	/**
	 * Generate a StackPane element.
	 *
	 * @param  id The (unique) ID name of the StackPane.
	 * @return    Returns a StackPane element.
	 */
	protected StackPane generateStackPane(final String id) {
		final StackPane stackPane = new StackPane();
		stackPane.setId(UIElements.STACKPANE.getPrefix() + id);
		return stackPane;
	}

	/**
	 * Generate a TabPane element.
	 *
	 * @param  id The (unique) ID name of the TabPane.
	 * @return    Returns a TabPane element.
	 */
	protected TabPane generateTabPane(final String id) {
		final TabPane tabPane = new TabPane();
		tabPane.setId(UIElements.TABPANE.getPrefix() + id);
		return tabPane;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected TextField generateTextField(final String id, final String promptText) {
		final TextField textField = new TextField();
		textField.setId(UIElements.TEXTFIELD.getPrefix() + id);
		textField.setPromptText(promptText);
		return textField;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected TextField generateTextField(final String id, final String promptText, final String text) {
		final TextField textField = this.generateTextField(id, promptText);
		textField.setText(text);
		return textField;
	}

	/**
	 * {@inheritDoc} This method requires a frame of type StackPane.
	 */
	@Override
	public void populate(final Object frame) {
		if(!(frame instanceof StackPane)) throw new IllegalArgumentException("The frame must be of type StackPane.");
		((StackPane)frame).getChildren().add((TabPane)this.generateMenu("Menu"));
	}
}
