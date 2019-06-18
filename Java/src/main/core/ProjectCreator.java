package main.core;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ProjectCreator extends Application {
	
	private static boolean isSafeBootMode = false;

	/**
	 * Launch the application and open the start UI.
	 * @param args Console arguments that may be provided upon launch.
	 */
	public static void main(String[] args) {
		for (String arg : args) {
			if(arg.contentEquals("safeboot") || arg.contentEquals("safe")) { // Set launch mode to safe boot mode.
				isSafeBootMode = true;
				System.out.println("Setting app to launch in safe mode.");
			}
		}
		
		if(isSafeBootMode) { // Launch application in safe boot mode.
			System.out.println("Launching app in safe mode.");
		} else { // Launch application in normal mode.
			System.out.println("Launching app in normal mode.");
		}
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("../ui/single-view.fxml"));
		primaryStage.setTitle("Create new Project");
		primaryStage.setScene(new Scene(root, 400, 300));
		primaryStage.show();
	}
}
