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

	final double sceneWidth;
	final double sceneHeight;
	final double labelWidth;
	final double marginX;
	final double marginY;

	/**
	 * Instantiate the element designer class.
	 *
	 * @param scene The scene displayed by the user interface.
	 */
	public ElementDesigner(final Scene scene) {
		this.scene = scene;
		sceneWidth = scene.getWidth();
		sceneHeight = scene.getHeight();
		labelWidth = 110;
		marginX = 5;
		marginY = 6;
	}

	/**
	 * Place all elements at their correct places and set their properties correct.
	 */
	public void designElements() {
		System.out.println("Positioning and styling elements."); // TODO: Replace with log component.
		final String prefix = UIElements.TAB.getPrefix();
		for(final Tab tab : ((TabPane)scene.lookup("#" + UIElements.TABPANE.getPrefix() + "Menu")).getTabs()) if(tab.getId().contentEquals(prefix + MenuItems.PROJECT.getId()))
			designProjectTab();
		else if(tab.getId().contentEquals(prefix + MenuItems.PROGRAMMING.getId())) {
			designProgrammingTab();
		} else if(tab.getId().contentEquals(prefix + MenuItems.DOCUMENTATION.getId())) {

		} else if(tab.getId().contentEquals(prefix + MenuItems.DIAGRAMS.getId())) {

		} else if(tab.getId().contentEquals(prefix + MenuItems.ADDITIONAL_SOURCES.getId())) {

		} else if(tab.getId().contentEquals(prefix + MenuItems.FINALIZE.getId())) {

		}
		System.out.println("All elements have been positioned and styled."); // TODO: Replace with log component.
	}

	/**
	 * Position all elements of the Project tab.
	 */
	private void designProjectTab() {
		System.out.println("Positioning StackPane GenerationOptions."); // TODO: Replace with log component.
		final StackPane stpGenerationOptions = (StackPane)scene.lookup("#" + UIElements.STACKPANE.getPrefix() + "GenerationOptions");
		stpGenerationOptions.setMinHeight(sceneHeight);
		stpGenerationOptions.setPrefHeight(sceneHeight);
		stpGenerationOptions.setMaxHeight(sceneHeight);

		System.out.println("Positioning TextField ProjectName."); // TODO: Replace with log component.
		final TextField txfProjectName = (TextField)scene.lookup("#" + UIElements.TEXTFIELD.getPrefix() + "ProjectName");
		txfProjectName.setMinWidth(40);
		txfProjectName.setPrefWidth(sceneWidth - (marginX * 3 + labelWidth));
		txfProjectName.setMaxWidth(sceneWidth - (marginX * 3 + labelWidth));
		txfProjectName.setLayoutX(labelWidth + marginX * 2);
		txfProjectName.setLayoutY(marginY);

		System.out.println("Positioning Button Location"); // TODO: Replace with log component.
		final Button btnLocation = (Button)scene.lookup("#" + UIElements.BUTTON.getPrefix() + "Location");
		btnLocation.setMinWidth(40);
		btnLocation.setPrefWidth(90);
		btnLocation.setMaxWidth(90);
		btnLocation.setLayoutX(scene.getWidth() - marginX * 2 - btnLocation.getWidth());
		btnLocation.setLayoutY(txfProjectName.getLayoutY() + txfProjectName.getHeight() + marginY);

		System.out.println("Positioning TextField ProjectLocation."); // TODO: Replace with log component.
		final TextField txfProjectLocation = (TextField)scene.lookup("#" + UIElements.TEXTFIELD.getPrefix() + "ProjectLocation");
		txfProjectLocation.setMinWidth(40);
		txfProjectLocation.setPrefWidth(sceneWidth - (marginX * 5 + labelWidth) - btnLocation.getWidth());
		txfProjectLocation.setMaxWidth(sceneWidth - (marginX * 5 + labelWidth) - btnLocation.getWidth());
		txfProjectLocation.setLayoutX(labelWidth + marginX * 2);
		txfProjectLocation.setLayoutY(marginY * 2 + txfProjectName.getHeight());

		System.out.println("Positioning Label ProjectName."); // TODO: Replace with log component.
		final Label lblProjectName = (Label)scene.lookup("#" + UIElements.LABEL.getPrefix() + "ProjectName");
		lblProjectName.setLayoutX(marginX + labelWidth - lblProjectName.getWidth());
		lblProjectName.setLayoutY(txfProjectName.getLayoutY() + txfProjectName.getHeight() / 2 - lblProjectName.getHeight() / 2);

		System.out.println("Positioning Label ProjectLocation."); // TODO: Replace with log component.
		final Label lblProjectLocation = (Label)scene.lookup("#" + UIElements.LABEL.getPrefix() + "ProjectLocation");
		lblProjectLocation.setLayoutX(marginX + labelWidth - lblProjectLocation.getWidth());
		lblProjectLocation.setLayoutY(txfProjectLocation.getLayoutY() + txfProjectLocation.getHeight() / 2 - lblProjectLocation.getHeight() / 2);

		System.out.println("Positioning Label ProjectGenerationOptions"); // TODO: Replace with log component.
		final Label lblProjectGenerationOptions = (Label)scene.lookup("#" + UIElements.LABEL.getPrefix() + "ProjectGenerationOptions");
		lblProjectGenerationOptions.setLayoutX(marginX);
		lblProjectGenerationOptions.setLayoutY(lblProjectLocation.getLayoutY() + (lblProjectLocation.getLayoutY() - lblProjectName.getLayoutY()));

		System.out.println("Positioning CheckBox Programming"); // TODO: Replace with log component.
		final CheckBox chbProgramming = (CheckBox)scene.lookup("#" + UIElements.CHECKBOX.getPrefix() + "Programming");
		chbProgramming.setMinWidth(60);
		chbProgramming.setPrefWidth(120);
		chbProgramming.setMaxWidth(200);
		chbProgramming.setLayoutX(marginX);
		chbProgramming.setLayoutY(lblProjectGenerationOptions.getLayoutY() + lblProjectGenerationOptions.getHeight() + marginY);

		System.out.println("Positioning CheckBox Documentation"); // TODO: Replace with log component.
		final CheckBox chbDocumentation = (CheckBox)scene.lookup("#" + UIElements.CHECKBOX.getPrefix() + "Documentation");
		chbDocumentation.setMinWidth(60);
		chbDocumentation.setPrefWidth(120);
		chbDocumentation.setMaxWidth(200);
		chbDocumentation.setLayoutX(marginX);
		chbDocumentation.setLayoutY(lblProjectGenerationOptions.getLayoutY() + lblProjectGenerationOptions.getHeight() + marginY * 2 + chbProgramming.getHeight());

		System.out.println("Positioning CheckBox Diagrams"); // TODO: Replace with log component.
		final CheckBox chbDiagrams = (CheckBox)scene.lookup("#" + UIElements.CHECKBOX.getPrefix() + "Diagrams");
		chbDiagrams.setMinWidth(60);
		chbDiagrams.setPrefWidth(120);
		chbDiagrams.setMaxWidth(200);
		chbDiagrams.setLayoutX(marginX);
		chbDiagrams.setLayoutY(lblProjectGenerationOptions.getLayoutY() + lblProjectGenerationOptions.getHeight() + marginY * 3 + chbProgramming.getHeight() + chbDocumentation.getHeight());

		System.out.println("Positioning CheckBox AdditionalSources"); // TODO: Replace with log component.
		final CheckBox chbAdditionalSources = (CheckBox)scene.lookup("#" + UIElements.CHECKBOX.getPrefix() + "AdditionalSources");
		chbAdditionalSources.setMinWidth(60);
		chbAdditionalSources.setPrefWidth(120);
		chbAdditionalSources.setMaxWidth(200);
		chbAdditionalSources.setLayoutX(marginX);
		chbAdditionalSources.setLayoutY(lblProjectGenerationOptions.getLayoutY() + lblProjectGenerationOptions.getHeight() + marginY * 4 + chbProgramming.getHeight()
				+ chbDocumentation.getHeight() + chbDiagrams.getHeight());
	}

	private void designProgrammingTab() {
		final double languageColumnWidth = 120;
		final double languageTopRowHeight = 22;

		System.out.println("Positioning StackPane ProgrammingLanguages."); // TODO: Replace with log component.
		final StackPane stpProgrammingLanguages = (StackPane)scene.lookup("#" + UIElements.STACKPANE.getPrefix() + "ProgrammingLanguages");
		stpProgrammingLanguages.setMinWidth(sceneWidth);
		stpProgrammingLanguages.setPrefWidth(sceneWidth);
		stpProgrammingLanguages.setMaxWidth(sceneWidth);

		System.out.println("Positioning Label Functional"); // TODO: Replace with log component.
		final Label lblFunctional = (Label)scene.lookup("#" + UIElements.LABEL.getPrefix() + "Functional");
		lblFunctional.setMinSize(8, 40);
		lblFunctional.setPrefSize(90, 34);
		lblFunctional.setMaxSize(languageColumnWidth, languageTopRowHeight);
		lblFunctional.setLayoutX(marginX);
		lblFunctional.setLayoutY(marginY);

		System.out.println("Positioning Label ObjectOriented"); // TODO: Replace with log component.
		final Label lblObjectOriented = (Label)scene.lookup("#" + UIElements.LABEL.getPrefix() + "ObjectOriented");
		lblObjectOriented.setMinSize(8, 40);
		lblObjectOriented.setPrefSize(90, 34);
		lblObjectOriented.setMaxSize(languageColumnWidth, 57);
		lblObjectOriented.setLayoutX(marginX * 3 + lblFunctional.getWidth());
		lblObjectOriented.setLayoutY(marginY);

		System.out.println("Positioning CheckBoxes"); // TODO: Replace with log component.
		int functionalLanguages = 0;
		int objectOrientedLanguages = 0;
		for(int i = 0; i < ProgrammingLanguage.values().length; i += 1) {
			final ProgrammingLanguage language = ProgrammingLanguage.values()[i];
			if(!language.getName().contentEquals("")) {
				final CheckBox chbLanguage = (CheckBox)scene.lookup("#" + UIElements.CHECKBOX.getPrefix() + language.getId());
				chbLanguage.setMinWidth(40);
				chbLanguage.setPrefWidth(60);
				chbLanguage.setMaxWidth(languageColumnWidth);
				if(language.isFunctional()) {
					functionalLanguages += 1;
					chbLanguage.setLayoutX(lblFunctional.getLayoutX());
					chbLanguage.setLayoutY(languageTopRowHeight + marginY * functionalLanguages + chbLanguage.getHeight() * functionalLanguages);
				} else {
					objectOrientedLanguages += 1;
					chbLanguage.setLayoutX(lblObjectOriented.getLayoutX());
					chbLanguage.setLayoutY(languageTopRowHeight + marginY * objectOrientedLanguages + chbLanguage.getHeight() * objectOrientedLanguages);
				}
			}
		}
	}
}
