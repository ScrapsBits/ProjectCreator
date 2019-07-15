package main.core;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.core.enumerations.BootMode;
import main.ui.elements.ElementDesigner;

/**
 * Run the application with a user interface, designed with JavaFX.
 *
 * @author ScrapsBits
 */
public final class ProjectCreator extends Application {
	/**
	 * Define if the launch mode is "safe" or "full".
	 */
	private static BootMode bootMode;
	/**
	 * Set the width of the stage.
	 */
	private static int stageWidth = 600;
	/**
	 * Set the height of the stage.
	 */
	private static int stageHeight = 400;

	/**
	 * Read if the launch mode is "safe".
	 *
	 * @return Returns true if the launch mode is "safe". Returns false if the launch mode is "full".
	 */
	public static BootMode bootMode() { return ProjectCreator.bootMode; }

	/**
	 * Set the default boot mode for the application.
	 *
	 * @return Returns the default boot mode.
	 */
	private static BootMode defaultBootMode() {
		final BootMode defaultBootMode = BootMode.DEVELOPMENT;
		System.out.println("Default boot mode is " + defaultBootMode.getBootName() + ".");
		return defaultBootMode;
	}

	/**
	 * Launch the application.
	 *
	 * @param args Console arguments that may be provided upon launch.
	 */
	public static void main(final String[] args) {
		try {
			boolean bootArgProvided = false;
			for(final String arg : args) for(final BootMode bootMode : BootMode.values()) for(final String bootCommand : bootMode.getBootCommands()) {
				if(bootArgProvided && arg.contentEquals(bootCommand)) throw new IllegalArgumentException("Too many boot mode arguments have been provided. Reverting to default boot mode.");
				if(arg.contentEquals(bootCommand)) {
					bootArgProvided = true;
					System.out.println("Setting app to launch in " + bootMode.getBootName() + " mode."); // TODO: Replace with log component.
					ProjectCreator.bootMode = bootMode;
				}
			}
		} catch(final IllegalArgumentException e) {
			System.out.println(e.getMessage()); // TODO: Replace with log component.
		} finally {
			if(ProjectCreator.bootMode == null || ProjectCreator.bootMode == BootMode.DEFAULT) {
				if(ProjectCreator.bootMode == null) System.out.println("No boot commands have been provided. Using default boot mode.");
				ProjectCreator.bootMode = ProjectCreator.defaultBootMode();
			}
			System.out.println("Launching app in " + ProjectCreator.bootMode.getBootName() + " boot mode."); // TODO: Replace with log component.
			Application.launch(args);
		}
	}

	/**
	 * Launch the user interface.
	 *
	 * @param primaryStage The first stage launched by the application.
	 */
	@Override
	public void start(final Stage primaryStage) throws Exception {
		System.out.println("Launching user interface. Loading in \"single-view.fxml\"."); // TODO: Replace with log component.
		final Parent root = FXMLLoader.load(getClass().getResource("../ui/single-view.fxml"));
		final Scene scene = new Scene(root, ProjectCreator.stageWidth, ProjectCreator.stageHeight);

		primaryStage.setTitle("Create new Project");
		primaryStage.setScene(scene);

		System.out.println("User interface initialized. \nDisplaying initialized interface."); // TODO: Replace with log component
		primaryStage.show();
		new ElementDesigner(scene).designElements();
	}
}
