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
		ProjectCreator.bootMode = BootMode.DEVELOPMENT;
		System.out.println("Default boot mode is " + ProjectCreator.bootMode.getBootCommand() + ".");
		return ProjectCreator.bootMode;
	}

	/**
	 * Launch the application.
	 *
	 * @param args Console arguments that may be provided upon launch.
	 */
	public static void main(final String[] args) {
		if(ProjectCreator.validArgs(args)) {
			for(final String arg : args) if(arg.contentEquals(BootMode.SAFE.getBootCommand())) {
				ProjectCreator.bootMode = BootMode.SAFE;
				System.out.println("Setting app to launch in safe mode."); // TODO: Replace with log component.
			} else if(arg.contentEquals(BootMode.DEVELOPMENT.getBootCommand())) {
				ProjectCreator.bootMode = BootMode.DEVELOPMENT;
				System.out.println("Setting app to launch in development mode."); // TODO: Replace with log component.
			} else if(arg.contentEquals(BootMode.DEFAULT.getBootCommand())) {
				ProjectCreator.bootMode = BootMode.DEFAULT;
				System.out.println("Setting app to launch in its default mode."); // TODO: Replace with log component.
			}

			switch(ProjectCreator.bootMode) {
				case SAFE:
					System.out.println("Launching app in safe boot mode."); // TODO: Replace with log component.
					break;
				case DEVELOPMENT:
					System.out.println("Launching app in development boot mode."); // TODO: Replace with log component.
					break;
				case NORMAL:
					System.out.println("Launching app in normal boot mode."); // TODO: Replace with log component.
					break;
				case DEFAULT:
				default:
					System.out.println("Launching app in default boot mode."); // TODO: Replace with log component.
					ProjectCreator.bootMode = ProjectCreator.defaultBootMode();
					break;
			}
			Application.launch(args);
		} else
			System.out.println("Too many boot mode arguments have been provided. Cannot launch application."); // TODO: Replace with log component.
	}

	/**
	 * Ensure only none or one bootmode argument has been provided upon launch.
	 * 
	 * @param  args The arguments provided upon launch.
	 * @return      Returns true if no or one bootmode argument is provided upon launch. Returns false if there are two or more bootmode arguments given.
	 */
	private static boolean validArgs(final String[] args) {
		if(args.length == 0) {
			ProjectCreator.bootMode = BootMode.DEFAULT;
			return true;
		}
		int validArgs = 0;
		for(final String arg : args) {
			if(arg.contentEquals(BootMode.SAFE.getBootCommand()) || arg.contentEquals(BootMode.DEFAULT.getBootCommand()) || arg.contentEquals(BootMode.DEVELOPMENT.getBootCommand()))
				validArgs += 1;
		}
		return validArgs == 1;
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
