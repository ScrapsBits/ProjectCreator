package eu.electricfrog.projectcreator.ui.javafx.single_view.language.csharp;

import eu.electricfrog.projectcreator.ui.javafx.JavaFXGenerator;
import javafx.scene.Scene;

/**
 * Generate elements to be displayed on the CSharp user interface.
 * @author ScrapsBits
 * @since 1.1
 * @version 1.1
 */
public class CSharpGenerator extends JavaFXGenerator {

	/**
	 * Create a generator that links actions to the provided controller.
	 * @param controller The controller to be linked to the user interface.
	 */
	protected CSharpGenerator(CSharpController controller) {
		super(controller);
		controller.acpScene = super.generateAnchorPane("Scene");
		controller.getStage().setScene(new Scene(controller.acpScene));
	}

	@Override
	public void generate() {
		final CSharpController controller = (CSharpController)super.controller;
		controller.acpScene.setPrefWidth(controller.getStage().getWidth());
		controller.acpScene.setPrefHeight(controller.getStage().getHeight());
		
		controller.lblName = super.generateLabel("Name", "Name: ");
		controller.lblDirectory = super.generateLabel("Directory", "Directory: ");
		controller.lblSolution = super.generateLabel("Solution", "Solution name: ");
		controller.acpScene.getChildren().addAll(controller.lblName, controller.lblDirectory, controller.lblSolution);
		
		controller.btnSave = super.generateButton("Save", "Save");
		controller.btnDirectory = super.generateButton("Directory", "Directory");
		controller.acpScene.getChildren().addAll(controller.btnSave, controller.btnDirectory);
		
		controller.txfName = super.generateTextField("Name", "My New Project", "");
		controller.txfDirectory = super.generateTextField("Directory", "", "");
		controller.txfSolution = super.generateTextField("Solution", "MyNewProject", "");
		controller.acpScene.getChildren().addAll(controller.txfName, controller.txfDirectory, controller.txfSolution);
	}

	@Override
	public void position() {
		// FIXME: Switching from one monitor to another seems to mess with the UI's dimensions.
		final CSharpController controller = (CSharpController)super.controller;

		controller.btnDirectory.setLayoutX(controller.acpScene.getWidth() - this.padding - controller.btnDirectory.getWidth());
		controller.btnDirectory.setLayoutY(2 * this.padding + rowSize);

		double prefWidth = controller.acpScene.getWidth() * .7;
		controller.txfName.setPrefWidth(prefWidth);
		controller.txfName.setLayoutX(controller.acpScene.getWidth() - this.padding - prefWidth);
		controller.txfName.setLayoutY(this.padding);
		controller.txfDirectory.setPrefWidth(prefWidth - this.padding - controller.btnDirectory.getWidth());
		controller.txfDirectory.setLayoutX(controller.acpScene.getWidth() - this.padding - prefWidth);
		controller.txfDirectory.setLayoutY(2 * this.padding + this.rowSize);
		controller.txfSolution.setPrefWidth(prefWidth);
		controller.txfSolution.setLayoutX(controller.acpScene.getWidth() - this.padding - prefWidth);
		controller.txfSolution.setLayoutY(3 * this.padding + 2 * this.rowSize);
		
		controller.lblName.setLayoutX(controller.txfName.getLayoutX() - this.padding - controller.lblName.getWidth());
		controller.lblName.setLayoutY(controller.txfName.getLayoutY() + .5 * controller.txfName.getHeight() - .5 * controller.lblName.getHeight());
		controller.lblDirectory.setLayoutX(controller.txfDirectory.getLayoutX() - this.padding - controller.lblDirectory.getWidth());
		controller.lblDirectory.setLayoutY(controller.txfDirectory.getLayoutY() + .5 * controller.txfDirectory.getHeight() - .5 * controller.lblDirectory.getHeight());
		controller.lblSolution.setLayoutX(controller.txfSolution.getLayoutX() - this.padding - controller.lblSolution.getWidth());
		controller.lblSolution.setLayoutY(controller.txfSolution.getLayoutY() + .5 * controller.txfSolution.getHeight() - .5 * controller.lblSolution.getHeight());
	 }
}
