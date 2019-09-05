package eu.electricfrog.projectcreator.ui.javafx.single_view;

import eu.electricfrog.projectcreator.core.application.Application;
import eu.electricfrog.projectcreator.core.application.configuration.boot.BootMode;
import eu.electricfrog.projectcreator.core.models.ProgrammingLanguage;
import eu.electricfrog.projectcreator.ui.javafx.JavaFXElement;
import eu.electricfrog.projectcreator.ui.javafx.JavaFXGenerator;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * Generator class to create the elements displayed on the SingleViewController.
 *
 * @author  ScrapsBits
 * @since   1.0
 * @version 1.1
 */
public class SingleViewGenerator extends JavaFXGenerator {
	/**
	 * Provide a controller of type SingleViewController to the element generator.
	 *
	 * @param controller The SingleViewController used by the user interface.
	 */
	protected SingleViewGenerator(final SingleViewController controller) {
		super(controller);
		controller.stpScene = super.generateStackPane("Scene");
		controller.getStage().setScene(new Scene(controller.stpScene));
	}

	@Override
	public void generate() {
		final SingleViewController controller = (SingleViewController)super.controller;
		controller.stpScene.setMinWidth(controller.getStage().getWidth());

		this.generateTabMenu();
		this.generateProjectTabContent();
		this.generateProgrammingTabContent();
		// TODO: Remove DEVELOPMENT boot mode check.
		if(Application.bootMode().equals(BootMode.DEVELOPMENT)) {
			this.generateDocumentationTabContent();
			this.generateDiagramsTabContent();
			// Additional sources
		}
		this.generateFinalizeTabContent();

		controller.getStage().widthProperty().addListener((v) -> controller.update());
		controller.getStage().heightProperty().addListener((v) -> controller.update());
	}

	/**
	 * Generate content to be displayed on the tab "Diagrams".
	 */
	private final void generateDiagramsTabContent() {
		final SingleViewController controller = (SingleViewController)super.controller;
		System.out.println("Generating content on Diagrams."); // TODO: Replace with log component.
		controller.lblDiagramTypes = super.generateLabel("DiagramTypes", "Diagram types: ");
		controller.lsvDiagrams = super.generateListView("DiagramTypes");
		controller.acpDiagrams.getChildren().addAll(controller.lblDiagramTypes, controller.lsvDiagrams);
		System.out.println("Content on Diagrams has been generated."); // TODO: Replace with log component.
	}

	/**
	 * Generate content to be displayed on the tab "Documentation".
	 */
	private final void generateDocumentationTabContent() {
		final SingleViewController controller = (SingleViewController)super.controller;
		System.out.println("Generating content on Documentation."); // TODO: Replace with log component.
		controller.lblDocumentationTypes = super.generateLabel("DocumentationTypes", "Documentation types: ");
		controller.lsvDocumentation = super.generateListView("DocTypes");
		controller.acpDocumentation.getChildren().addAll(controller.lblDocumentationTypes, controller.lsvDocumentation);
		System.out.println("Content on Documentation has been generated."); // TODO: Replace with log component.
	}

	/**
	 * Generate content to be displayed on the tab "Finalize".
	 */
	private final void generateFinalizeTabContent() {
		final SingleViewController controller = (SingleViewController)super.controller;
		System.out.println("Generating content on Finalize."); // TODO: Replace with log component.
		controller.scpLanguages = super.generateScrollPane("Languages");
		controller.scpLanguages.setVbarPolicy(ScrollBarPolicy.ALWAYS);
		controller.acpLanguages = super.generateAnchorPane("Languages");
		controller.scpLanguages.setContent(controller.acpLanguages);

		controller.btnSave = super.generateButton("Save", "Save");
		// TODO: Change into method reference.
		controller.btnSave.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> controller.handleBtnSaveClick(event));
		// TODO: Change into method reference.
		controller.btnGenerateProjects = super.generateButton("GenerateProjects", "Generate projects");
		controller.btnGenerateProjects.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> controller.handleBtnGenerateProjectsClick(event));
		controller.acpComplete.getChildren().addAll(controller.btnSave, controller.btnGenerateProjects, controller.scpLanguages);
		System.out.println("Content on Finalize has been generated."); // TODO: Replace with log component.
	}

	/**
	 * Generate content to be displayed on the tab "Programming".
	 */
	private final void generateProgrammingTabContent() {
		final SingleViewController controller = (SingleViewController)super.controller;
		System.out.println("Generating content on Programming."); // TODO: Replace with log component.
		controller.lblProgrammingLanguages = super.generateLabel("AvailableLanguages", "Available languages:");
		controller.lsvLanguages = super.generateListView("Languages");
		controller.lsvLanguages.setCellFactory(CheckBoxListCell.forListView((observableLanguage) -> observableLanguage.getObservableProperty()));
		// TODO: Change into method reference.
		controller.acpProgramming.getChildren().addAll(controller.lblProgrammingLanguages, controller.lsvLanguages);
		System.out.println("Content on Programming has been generated."); // TODO: Replace with log component.
	}

	/**
	 * Generate content to be displayed on the tab "Project".
	 */
	private final void generateProjectTabContent() {
		final SingleViewController controller = (SingleViewController)super.controller;
		System.out.println("Generating content on Project."); // TODO: Replace with log component.
		controller.lblProjectName = super.generateLabel("ProjectName", "Name: ");
		controller.lblProjectLocation = super.generateLabel("ProjectLocation", "Location: ");
		controller.lblProjectDate = super.generateLabel("ProjectDate", "");
		controller.txfProjectName = super.generateTextField("ProjectName", "My new project", "");
		controller.txfProjectLocation = super.generateTextField("ProjectLocation", "Documents", "");
		controller.btnDirectory = super.generateButton("Directory", "Select folder");
		// TODO: Change into method reference.
		controller.btnDirectory.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> controller.handleBtnLocationClick(event));
		controller.btnLoad = super.generateButton("Load", "Load project");
		// TODO: Change into method reference.
		controller.btnLoad.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> controller.handleBtnLoadClick(event));

		controller.acpProject.getChildren().addAll(controller.lblProjectName, controller.lblProjectLocation, controller.txfProjectName, controller.txfProjectLocation, controller.btnDirectory,
				controller.lblProjectDate, controller.btnLoad);
		System.out.println("Content on Project has been generated."); // TODO: Replace with log component.
	}

	public final void generateSelectedLanguagePane(final ProgrammingLanguage language) {
		System.out.println("Generating settings for language " + language.getName());
		final SingleViewController controller = (SingleViewController)super.controller;
		// TODO: Check if this item already exists.
		controller.acpLanguages.getChildren().removeIf((child) -> child.getId().contentEquals(JavaFXElement.ANCHORPANE.getPrefix() + language.toCharString()));
		final AnchorPane languagePane = super.generateAnchorPane(language.toCharString());
		final Label languageName = super.generateLabel(language.toCharString(), language.getName());
		final Button languageSettings = super.generateButton(language.toCharString(), "Settings");
		languageSettings.setUserData(language);
		switch(language.getName()) {
			case "C#":
				languageSettings.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> controller.handleBtnCSharpSettingsClick(event));
				break;
			case "Java":
				languageSettings.addEventHandler(MouseEvent.MOUSE_CLICKED, (event) -> controller.handleBtnJavaSettingsClick(event));
				break;
			case "PHP":
				break;
		}
		languagePane.getChildren().addAll(languageName, languageSettings);
		controller.acpLanguages.getChildren().add(languagePane);
	}

	/**
	 * Generate the tab-style menu.
	 */
	private final void generateTabMenu() {
		final SingleViewController controller = (SingleViewController)super.controller;
		System.out.println("Generating Tabs."); // TODO: Replace with log component.
		controller.tbpMenu = super.generateTabPane("Menu");
		controller.tbpMenu.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		controller.tbpMenu.setTabMinWidth(45);

		Tab tabDocumentation = null;
		Tab tabDiagrams = null;
		Tab tabAdditionalSources = null;

		final Tab tabProject = super.generateTab("Project", "Project");
		tabProject.setContent(controller.acpProject = super.generateAnchorPane("Project"));
		final Tab tabProgramming = super.generateTab("Programming", "Programming");
		tabProgramming.setContent(controller.acpProgramming = super.generateAnchorPane("Programming"));
		// TODO: Remove DEVELOPMENT boot mode check.
		if(Application.bootMode().equals(BootMode.DEVELOPMENT)) {
			tabDocumentation = super.generateTab("Documentation", "Documentation");
			tabDocumentation.setContent(controller.acpDocumentation = super.generateAnchorPane("Documentation"));
			tabDiagrams = super.generateTab("Diagrams", "Diagrams");
			tabDiagrams.setContent(controller.acpDiagrams = super.generateAnchorPane("Diagrams"));
			tabAdditionalSources = super.generateTab("AdditionalSources", "Extra");
			tabAdditionalSources.setContent(controller.acpAdditionalSources = super.generateAnchorPane("AdditionalSources"));
		}
		final Tab tabComplete = super.generateTab("Finish", "Complete");
		tabComplete.setContent(controller.acpComplete = super.generateAnchorPane("Complete"));

		if(Application.bootMode().equals(BootMode.DEVELOPMENT)) // Additional sources
			controller.tbpMenu.getTabs().addAll(tabProject, tabProgramming, tabDocumentation, tabDiagrams, tabAdditionalSources, tabComplete);
		else
			controller.tbpMenu.getTabs().addAll(tabProject, tabProgramming, tabComplete);
		controller.stpScene.getChildren().add(controller.tbpMenu);
		controller.tbpMenu.getSelectionModel().selectedItemProperty().addListener((observable, oldTab, newTab) -> controller.listenTabChange(observable, oldTab, newTab));
		System.out.println("Tabs generated."); // TODO: Replace with log component.
	}

	@Override
	public void position() {
		final SingleViewController controller = (SingleViewController)super.controller;
		controller.stpScene.setPrefWidth(controller.getStage().getWidth());
		controller.stpScene.setPrefHeight(controller.getStage().getHeight());
		controller.stpScene.setMaxWidth(controller.getStage().getWidth());
		controller.stpScene.setMaxHeight(controller.getStage().getHeight());

		this.positionProjectTabContent();
		this.positionProgrammingTabContent();
		// TODO: Remove DEVELOPMENT boot mode check.
		if(Application.bootMode().equals(BootMode.DEVELOPMENT)) {
			this.positionDocumentationTabContent();
			this.positionDiagramsTabContent();
			// Additional sources
		}
		this.positionFinalizeTabContent();

		// if(controller.tbpMenu.getSelectionModel().getSelectedItem().getText().contentEquals("Complete")) {
		System.out.println("Positioning settings objects.");
		this.positionProgrammingLanguagesSettings();
		// }
	}

	/**
	 * Position the elements displayed on the Diagrams tab.
	 */
	private final void positionDiagramsTabContent() {
		final SingleViewController controller = (SingleViewController)super.controller;
		System.out.println("Positioning Diagrams content."); // TODO: Replace with log component.
		controller.lblDiagramTypes.setLayoutX(this.padding + this.labelJump);
		controller.lblDiagramTypes.setLayoutY(this.padding);
		controller.lsvDiagrams.setLayoutX(this.padding);
		controller.lsvDiagrams.setLayoutY(this.padding + this.rowSize);
		controller.lsvDiagrams.setPrefWidth(this.columnSize * 2);
		controller.lsvDiagrams.setPrefHeight(controller.acpDiagrams.getHeight() - 2 * this.padding - this.rowSize);
		controller.lsvDiagrams.setMaxWidth(this.columnSize * 2);
		controller.lsvDiagrams.setMaxHeight(controller.acpDiagrams.getHeight() - 2 * this.padding - this.rowSize);
		System.out.println("Diagrams content positioned."); // TODO: Replace with log component.
	}

	/**
	 * Position the elements displayed on the Documentation tab.
	 */
	private final void positionDocumentationTabContent() {
		final SingleViewController controller = (SingleViewController)super.controller;
		System.out.println("Positioning Documentation content.");
		controller.lblDocumentationTypes.setLayoutX(this.padding + this.labelJump);
		controller.lblDocumentationTypes.setLayoutY(this.padding);
		controller.lsvDocumentation.setLayoutX(this.padding);
		controller.lsvDocumentation.setLayoutY(this.padding + this.rowSize);
		controller.lsvDocumentation.setPrefWidth(this.columnSize * 2);
		controller.lsvDocumentation.setPrefHeight(controller.acpDocumentation.getHeight() - 2 * this.padding - this.rowSize);
		controller.lsvDocumentation.setMaxWidth(this.columnSize * 2);
		controller.lsvDocumentation.setMaxHeight(controller.acpDocumentation.getHeight() - 2 * this.padding - this.rowSize);
		System.out.println("Documentation content positioned.");
	}

	/**
	 * Position the elements displayed on the Finalize tab.
	 */
	private final void positionFinalizeTabContent() {
		final SingleViewController controller = (SingleViewController)super.controller;
		System.out.println("Positioning Finalize content.");
		controller.scpLanguages.setPrefWidth(.5 * controller.acpComplete.getWidth() - this.padding);
		controller.scpLanguages.setPrefHeight(201);
		controller.scpLanguages.setLayoutX(this.padding);
		controller.scpLanguages.setLayoutY(this.padding);
		controller.acpLanguages.setMinWidth(controller.scpLanguages.getViewportBounds().getWidth());
		controller.acpLanguages.setPrefWidth(controller.scpLanguages.getViewportBounds().getWidth());
		controller.btnSave.setLayoutX(this.padding);
		controller.btnSave.setLayoutY(controller.acpComplete.getHeight() - this.padding - controller.btnSave.getHeight());
		controller.btnGenerateProjects.setLayoutX(2 * this.padding + controller.btnSave.getWidth());
		controller.btnGenerateProjects.setLayoutY(controller.acpComplete.getHeight() - this.padding - controller.btnGenerateProjects.getHeight());
		System.out.println("Finalize content positioned.");
	}

	/**
	 * Position the dynamically generated elements in the scpProgrammingLanguage node.
	 */
	public final void positionProgrammingLanguagesSettings() {
		final SingleViewController controller = (SingleViewController)super.controller;
		System.out.println("There are " + controller.acpLanguages.getChildren().size() + " items.");
		for(final Node childNode : controller.acpLanguages.getChildren()) if(childNode instanceof AnchorPane) {
			childNode.setLayoutY(controller.acpLanguages.getChildren().indexOf(childNode) * 1.5 * this.rowSize);
			for(final Node e : ((AnchorPane)childNode).getChildren()) {
				System.out.println("Moving node " + e.getId());
				if(e instanceof Label) {
					e.setLayoutX(this.padding);
					e.setLayoutY(this.padding);
				}
				if(e instanceof Button) {
					final Button btnNode = (Button)e;
					btnNode.setLayoutX(controller.acpLanguages.getWidth() - this.padding - btnNode.getWidth());
					btnNode.setLayoutY(this.padding);
				}
			}
		}
	}

	/**
	 * Position the elements displayed on the Programming tab.
	 */
	private final void positionProgrammingTabContent() {
		final SingleViewController controller = (SingleViewController)super.controller;
		System.out.println("Positioning Programming content.");
		controller.lblProgrammingLanguages.setLayoutX(this.padding + this.labelJump);
		controller.lblProgrammingLanguages.setLayoutY(this.padding);

		controller.lsvLanguages.setLayoutX(this.padding);
		controller.lsvLanguages.setLayoutY(this.padding + this.rowSize);
		controller.lsvLanguages.setPrefWidth(this.columnSize * 2);
		controller.lsvLanguages.setPrefHeight(controller.acpProgramming.getHeight() - 2 * this.padding - this.rowSize);
		controller.lsvLanguages.setMaxWidth(this.columnSize * 2);
		controller.lsvLanguages.setMaxHeight(controller.acpProgramming.getHeight() - 2 * this.padding - this.rowSize);

		System.out.println("Programming content positioned.");
	}

	/**
	 * Position the elements displayed on the Project tab.
	 */
	private final void positionProjectTabContent() {
		final SingleViewController controller = (SingleViewController)super.controller;
		System.out.println("Positioning Project content.");
		controller.txfProjectName.setLayoutX(this.padding + this.columnSize);
		controller.txfProjectName.setLayoutY(this.padding + 0 * this.rowSize);
		controller.txfProjectName.setPrefWidth(controller.acpProject.getWidth() - this.columnSize - 2 * super.padding);
		controller.txfProjectLocation.setLayoutX(this.padding + this.columnSize);
		controller.txfProjectLocation.setLayoutY(2 * this.padding + 1 * this.rowSize);
		controller.txfProjectLocation.setPrefWidth(controller.acpProject.getWidth() - this.columnSize - 3 * super.padding - controller.btnDirectory.getWidth());
		controller.btnDirectory.setLayoutX(controller.acpProject.getWidth() - controller.btnDirectory.getWidth() - this.padding);
		controller.btnDirectory.setLayoutY(controller.txfProjectLocation.getLayoutY());
		controller.btnLoad.setLayoutX(this.padding);
		controller.btnLoad.setLayoutY(controller.acpProject.getHeight() - this.padding - controller.btnLoad.getHeight());

		controller.lblProjectName.setLayoutX(controller.txfProjectName.getLayoutX() - controller.lblProjectName.getWidth() - this.padding);
		controller.lblProjectName.setLayoutY(controller.txfProjectName.getLayoutY() + .5 * controller.txfProjectName.getHeight() - .5 * controller.lblProjectName.getHeight());
		controller.lblProjectLocation.setLayoutX(controller.txfProjectLocation.getLayoutX() - controller.lblProjectLocation.getWidth() - this.padding);
		controller.lblProjectLocation.setLayoutY(controller.txfProjectLocation.getLayoutY() + .5 * controller.txfProjectLocation.getHeight() - .5 * controller.lblProjectLocation.getHeight());
		controller.lblProjectDate.setVisible(false);
		System.out.println("Project content positioned.");
	}
}
