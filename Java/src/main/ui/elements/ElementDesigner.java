package main.ui.elements;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import main.core.enumerations.ProgrammingLanguage;
import main.ui.enumerations.MenuItems;
import main.ui.enumerations.UIElements;

/**
 * A class to design the single-view user interface.
 *
 * @author ScrapsBits
 */
public final class ElementDesigner {
	/**
	 * The scene displayed by the user interface.
	 */
	private final Scene scene;

	private final double sceneWidth;
	private final double sceneHeight;
	private final double labelWidth;
	private final double marginX;
	private final double marginY;
	private final double edgeMarginX;
	private final double edgeMarginY;

	/**
	 * Instantiate the element designer class.
	 *
	 * @param scene The scene displayed by the user interface.
	 */
	public ElementDesigner(final Scene scene) {
		this.scene = scene;
		this.sceneWidth = scene.getWidth();
		this.sceneHeight = scene.getHeight();
		this.labelWidth = 110;
		this.marginX = 5;
		this.marginY = 6;
		this.edgeMarginX = 7;
		this.edgeMarginY = 4;
	}

	/**
	 * Place all elements at their correct places and set their properties correct.
	 */
	public void designElements() {
		System.out.println("Positioning and styling elements."); // TODO: Replace with log component.
		final String prefix = UIElements.TAB.getPrefix();
		for(final Tab tab : ((TabPane)this.scene.lookup("#" + UIElements.TABPANE.getPrefix() + "Menu")).getTabs()) if(tab.getId().contentEquals(prefix + MenuItems.PROJECT.getId()))
			this.designProjectTab();
		else if(tab.getId().contentEquals(prefix + MenuItems.PROGRAMMING.getId()))
			this.designProgrammingTab();
		else if(tab.getId().contentEquals(prefix + MenuItems.DOCUMENTATION.getId())) {

		} else if(tab.getId().contentEquals(prefix + MenuItems.DIAGRAMS.getId())) {

		} else if(tab.getId().contentEquals(prefix + MenuItems.ADDITIONAL_SOURCES.getId())) {

		} else if(tab.getId().contentEquals(prefix + MenuItems.FINALIZE.getId())) {

		}
		System.out.println("All elements have been positioned and styled."); // TODO: Replace with log component.
	}

	/**
	 * Position all elements of the Programming tab.
	 */
	private void designProgrammingTab() {
		final double languageColumnWidth = 120;
		final double languageTopRowHeight = 22;

		System.out.println("Positioning StackPane ProgrammingLanguages."); // TODO: Replace with log component.
		final StackPane stpProgrammingLanguages = (StackPane)this.scene.lookup("#" + UIElements.STACKPANE.getPrefix() + "ProgrammingLanguages");
		stpProgrammingLanguages.setMinWidth(this.sceneWidth);
		stpProgrammingLanguages.setPrefWidth(this.sceneWidth);
		stpProgrammingLanguages.setMaxWidth(this.sceneWidth);

		System.out.println("Positioning Label Functional"); // TODO: Replace with log component.
		final Label lblFunctional = (Label)this.scene.lookup("#" + UIElements.LABEL.getPrefix() + "Functional");
		lblFunctional.setMinSize(8, 40);
		lblFunctional.setPrefSize(90, 34);
		lblFunctional.setMaxSize(languageColumnWidth, languageTopRowHeight);
		lblFunctional.setLayoutX(this.marginX);
		lblFunctional.setLayoutY(this.marginY);

		System.out.println("Positioning Label ObjectOriented"); // TODO: Replace with log component.
		final Label lblObjectOriented = (Label)this.scene.lookup("#" + UIElements.LABEL.getPrefix() + "ObjectOriented");
		lblObjectOriented.setMinSize(8, 40);
		lblObjectOriented.setPrefSize(90, 34);
		lblObjectOriented.setMaxSize(languageColumnWidth, 57);
		lblObjectOriented.setLayoutX(this.marginX * 3 + lblFunctional.getWidth());
		lblObjectOriented.setLayoutY(this.marginY);

		System.out.println("Positioning CheckBoxes"); // TODO: Replace with log component.
		int functionalLanguages = 0;
		int objectOrientedLanguages = 0;
		for(int i = 0; i < ProgrammingLanguage.values().length; i += 1) {
			final ProgrammingLanguage language = ProgrammingLanguage.values()[i];
			if(!language.getName().contentEquals("")) {
				final CheckBox chbLanguage = (CheckBox)this.scene.lookup("#" + UIElements.CHECKBOX.getPrefix() + language.getId());
				chbLanguage.setMinWidth(40);
				chbLanguage.setPrefWidth(60);
				chbLanguage.setMaxWidth(languageColumnWidth);
				if(language.isFunctional()) {
					functionalLanguages += 1;
					chbLanguage.setLayoutX(lblFunctional.getLayoutX());
					chbLanguage.setLayoutY(languageTopRowHeight + this.marginY * functionalLanguages + chbLanguage.getHeight() * functionalLanguages);
				} else {
					objectOrientedLanguages += 1;
					chbLanguage.setLayoutX(lblObjectOriented.getLayoutX());
					chbLanguage.setLayoutY(languageTopRowHeight + this.marginY * objectOrientedLanguages + chbLanguage.getHeight() * objectOrientedLanguages);
				}
				if(!language.isSupported()) chbLanguage.setDisable(true);
			}
		}
	}

	/**
	 * Position all elements of the Project tab.
	 */
	private void designProjectTab() {
		System.out.println("Positioning StackPane GenerationOptions."); // TODO: Replace with log component.
		final StackPane stpGenerationOptions = (StackPane)this.scene.lookup("#" + UIElements.STACKPANE.getPrefix() + "GenerationOptions");
		stpGenerationOptions.setMinHeight(this.sceneHeight);
		stpGenerationOptions.setPrefHeight(this.sceneHeight);
		stpGenerationOptions.setMaxHeight(this.sceneHeight);

		System.out.println("Positioning TextField ProjectName."); // TODO: Replace with log component.
		final TextField txfProjectName = (TextField)this.scene.lookup("#" + UIElements.TEXTFIELD.getPrefix() + "ProjectName");
		txfProjectName.setMinWidth(40);
		txfProjectName.setPrefWidth(this.sceneWidth - (this.marginX * 3 + this.labelWidth));
		txfProjectName.setMaxWidth(this.sceneWidth - (this.marginX * 3 + this.labelWidth));
		txfProjectName.setLayoutX(this.labelWidth + this.marginX * 2);
		txfProjectName.setLayoutY(this.marginY);

		System.out.println("Positioning Button Location"); // TODO: Replace with log component.
		final Button btnLocation = (Button)this.scene.lookup("#" + UIElements.BUTTON.getPrefix() + "Location");
		btnLocation.setMinWidth(40);
		btnLocation.setPrefWidth(90);
		btnLocation.setMaxWidth(90);
		btnLocation.setLayoutX(this.scene.getWidth() - this.marginX * 2 - btnLocation.getWidth());
		btnLocation.setLayoutY(txfProjectName.getLayoutY() + txfProjectName.getHeight() + this.edgeMarginY);

		System.out.println("Positioning TextField ProjectLocation."); // TODO: Replace with log component.
		final TextField txfProjectLocation = (TextField)this.scene.lookup("#" + UIElements.TEXTFIELD.getPrefix() + "ProjectLocation");
		txfProjectLocation.setMinWidth(40);
		txfProjectLocation.setPrefWidth(this.sceneWidth - (this.marginX * 5 + this.labelWidth) - btnLocation.getWidth());
		txfProjectLocation.setMaxWidth(this.sceneWidth - (this.marginX * 5 + this.labelWidth) - btnLocation.getWidth());
		txfProjectLocation.setLayoutX(this.labelWidth + this.marginX * 2);
		txfProjectLocation.setLayoutY(this.edgeMarginY + this.marginY * 2 - this.marginY + txfProjectName.getHeight());

		System.out.println("Positioning Label ProjectName."); // TODO: Replace with log component.
		final Label lblProjectName = (Label)this.scene.lookup("#" + UIElements.LABEL.getPrefix() + "ProjectName");
		lblProjectName.setLayoutX(this.edgeMarginX + this.labelWidth - lblProjectName.getWidth());
		lblProjectName.setLayoutY(txfProjectName.getLayoutY() + txfProjectName.getHeight() / 2 - lblProjectName.getHeight() / 2);

		System.out.println("Positioning Label ProjectLocation."); // TODO: Replace with log component.
		final Label lblProjectLocation = (Label)this.scene.lookup("#" + UIElements.LABEL.getPrefix() + "ProjectLocation");
		lblProjectLocation.setLayoutX(this.edgeMarginX + this.labelWidth - lblProjectLocation.getWidth());
		lblProjectLocation.setLayoutY(txfProjectLocation.getLayoutY() + txfProjectLocation.getHeight() / 2 - lblProjectLocation.getHeight() / 2);

		System.out.println("Positioning Label ProjectGenerationOptions"); // TODO: Replace with log component.
		final Label lblProjectGenerationOptions = (Label)this.scene.lookup("#" + UIElements.LABEL.getPrefix() + "ProjectGenerationOptions");
		lblProjectGenerationOptions.setLayoutX(this.edgeMarginX + this.labelWidth - lblProjectGenerationOptions.getWidth());
		lblProjectGenerationOptions.setLayoutY(lblProjectLocation.getLayoutY() + (lblProjectLocation.getLayoutY() - lblProjectName.getLayoutY()));

		System.out.println("Positioning CheckBox Programming"); // TODO: Replace with log component.
		final CheckBox chbProgramming = (CheckBox)this.scene.lookup("#" + UIElements.CHECKBOX.getPrefix() + "Programming");
		chbProgramming.setMinWidth(60);
		chbProgramming.setPrefWidth(120);
		chbProgramming.setMaxWidth(200);
		chbProgramming.setLayoutX(this.edgeMarginX);
		chbProgramming.setLayoutY(lblProjectGenerationOptions.getLayoutY() + lblProjectGenerationOptions.getHeight() + this.marginY);

		System.out.println("Positioning CheckBox Documentation"); // TODO: Replace with log component.
		final CheckBox chbDocumentation = (CheckBox)this.scene.lookup("#" + UIElements.CHECKBOX.getPrefix() + "Documentation");
		chbDocumentation.setMinWidth(60);
		chbDocumentation.setPrefWidth(120);
		chbDocumentation.setMaxWidth(200);
		chbDocumentation.setLayoutX(this.edgeMarginX);
		chbDocumentation.setLayoutY(lblProjectGenerationOptions.getLayoutY() + lblProjectGenerationOptions.getHeight() + this.marginY * 2 + chbProgramming.getHeight());

		System.out.println("Positioning CheckBox Diagrams"); // TODO: Replace with log component.
		final CheckBox chbDiagrams = (CheckBox)this.scene.lookup("#" + UIElements.CHECKBOX.getPrefix() + "Diagrams");
		chbDiagrams.setMinWidth(60);
		chbDiagrams.setPrefWidth(120);
		chbDiagrams.setMaxWidth(200);
		chbDiagrams.setLayoutX(this.edgeMarginX);
		chbDiagrams
				.setLayoutY(lblProjectGenerationOptions.getLayoutY() + lblProjectGenerationOptions.getHeight() + this.marginY * 3 + chbProgramming.getHeight() + chbDocumentation.getHeight());

		System.out.println("Positioning CheckBox AdditionalSources"); // TODO: Replace with log component.
		final CheckBox chbAdditionalSources = (CheckBox)this.scene.lookup("#" + UIElements.CHECKBOX.getPrefix() + "AdditionalSources");
		chbAdditionalSources.setMinWidth(60);
		chbAdditionalSources.setPrefWidth(120);
		chbAdditionalSources.setMaxWidth(200);
		chbAdditionalSources.setLayoutX(this.edgeMarginX);
		chbAdditionalSources.setLayoutY(lblProjectGenerationOptions.getLayoutY() + lblProjectGenerationOptions.getHeight() + this.marginY * 4 + chbProgramming.getHeight()
				+ chbDocumentation.getHeight() + chbDiagrams.getHeight());
	}
}
