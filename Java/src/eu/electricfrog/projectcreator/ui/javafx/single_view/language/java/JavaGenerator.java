package eu.electricfrog.projectcreator.ui.javafx.single_view.language.java;

import eu.electricfrog.projectcreator.ui.javafx.JavaFXGenerator;
import javafx.scene.Scene;

/**
 * Generate all elements to be displayed on the Java user interface.
 * @author ScrapsBits
 * @since 1.1
 * @version 1.1
 */
public class JavaGenerator extends JavaFXGenerator {

	/**
	 * Link a controller the a user interface to define its actions.
	 * @param controller The controller linked to the user interface.
	 */
	protected JavaGenerator(JavaController controller) {
		super(controller);
		controller.acpScene = super.generateAnchorPane("Scene");
		controller.getStage().setScene(new Scene(controller.acpScene));
	}

	@Override
	public void generate() {
		final JavaController controller = (JavaController)super.controller;
		controller.acpScene.setPrefWidth(controller.getStage().getWidth());
		controller.acpScene.setPrefHeight(controller.getStage().getHeight());
		
		controller.lblName = super.generateLabel("Name", "Name: ");
		controller.lblDirectory = super.generateLabel("Directory", "Directory: ");
		controller.lblPackage = super.generateLabel("Package", "Package name: ");
		controller.acpScene.getChildren().addAll(controller.lblName, controller.lblDirectory, controller.lblPackage);
		
		controller.btnSave = super.generateButton("Save", "Save");
		controller.btnDirectory = super.generateButton("Directory", "Directory");
		controller.acpScene.getChildren().addAll(controller.btnSave, controller.btnDirectory);
		
		controller.txfName = super.generateTextField("Name", "My New Project", "");
		controller.txfDirectory = super.generateTextField("Directory", "", "");
		controller.txfPackage = super.generateTextField("Package", "mynewproject", "");
		controller.acpScene.getChildren().addAll(controller.txfName, controller.txfDirectory, controller.txfPackage);
	}

	@Override
	public void position() {
		// FIXME: Switching from one monitor to another seems to mess with the UI's dimensions.
		final JavaController controller = (JavaController)super.controller;

		controller.btnDirectory.setLayoutX(controller.acpScene.getWidth() - this.padding - controller.btnDirectory.getWidth());
		controller.btnDirectory.setLayoutY(2 * this.padding + rowSize);

		double prefWidth = controller.acpScene.getWidth() * .7;
		controller.txfName.setPrefWidth(prefWidth);
		controller.txfName.setLayoutX(controller.acpScene.getWidth() - this.padding - prefWidth);
		controller.txfName.setLayoutY(this.padding);
		controller.txfDirectory.setPrefWidth(prefWidth - this.padding - controller.btnDirectory.getWidth());
		controller.txfDirectory.setLayoutX(controller.acpScene.getWidth() - this.padding - prefWidth);
		controller.txfDirectory.setLayoutY(2 * this.padding + this.rowSize);
		controller.txfPackage.setPrefWidth(prefWidth);
		controller.txfPackage.setLayoutX(controller.acpScene.getWidth() - this.padding - prefWidth);
		controller.txfPackage.setLayoutY(3 * this.padding + 2 * this.rowSize);
		
		controller.lblName.setLayoutX(controller.txfName.getLayoutX() - this.padding - controller.lblName.getWidth());
		controller.lblName.setLayoutY(controller.txfName.getLayoutY() + .5 * controller.txfName.getHeight() - .5 * controller.lblName.getHeight());
		controller.lblDirectory.setLayoutX(controller.txfDirectory.getLayoutX() - this.padding - controller.lblDirectory.getWidth());
		controller.lblDirectory.setLayoutY(controller.txfDirectory.getLayoutY() + .5 * controller.txfDirectory.getHeight() - .5 * controller.lblDirectory.getHeight());
		controller.lblPackage.setLayoutX(controller.txfPackage.getLayoutX() - this.padding - controller.lblPackage.getWidth());
		controller.lblPackage.setLayoutY(controller.txfPackage.getLayoutY() + .5 * controller.txfPackage.getHeight() - .5 * controller.lblPackage.getHeight());
	 }

}
