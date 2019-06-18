package main.core;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ProjectCreator extends Application {
	/**
	 * Define if the launch mode is "safe" or "full".
	 */
	private static boolean isSafeBootMode = false;
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
	 * @return Returns true if the launch mode is "safe". Returns false if the launch mode is "full".
	 */
	public static boolean isSafeBootMode() {
		return isSafeBootMode;
	}

	/**
	 * Launch the application.
	 * @param args Console arguments that may be provided upon launch.
	 */
	public static void main(String[] args) {
		for (String arg : args) {
			if(arg.contentEquals("safeboot") || arg.contentEquals("safe")) { // Set launch mode to safe boot mode.
				isSafeBootMode = true;
				System.out.println("Setting app to launch in safe mode."); // TODO: Replace with log component.
			}
		}
		
		if(isSafeBootMode) { // Launch application in safe boot mode.
			System.out.println("Launching app in safe mode."); // TODO: Replace with log component.
		} else { // Launch application in normal mode.
			System.out.println("Launching app in normal mode."); // TODO: Replace with log component.
		}
		launch(args);
	}

	/**
	 * Launch the user interface.
	 * @param primaryStage The first stage launched by the application.
	 */
	@Override
	public void start(Stage primaryStage) throws Exception {
		System.out.println("Launching user interface. Loading in \"single-view.fxml\"."); // TODO: Replace with log component.
		Parent root = FXMLLoader.load(getClass().getResource("../ui/single-view.fxml"));
		
		primaryStage.setTitle("Create new Project");
		primaryStage.setScene(new Scene(root, stageWidth, stageHeight));
		
		System.out.println("User interface initialized."); // TODO: Replace with log component.
		primaryStage.show();
	}
}
