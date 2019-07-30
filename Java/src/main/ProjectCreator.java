package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.core.boot.AppBootMode;
import main.ui.single_view.SingleViewElementDesigner;
import main.ui.single_view.boot.SingleViewBootModeManager;

/**
 * Run the application with a user interface, designed with JavaFX.
 *
 * @author ScrapsBits
 */
public final class ProjectCreator extends Application {

	/**
	 * The name of the application.
	 */
	private static final String APPLICATION_NAME = "ProjectCreator";
	/**
	 * Keep track of all boot commands supported by the module. Commands are stored in a HashMap.
	 */
	public static final AppBootMode BOOT = new SingleViewBootModeManager();
	/**
	 * Define all supported command types.
	 */
	private static final String[] COMMAND_TYPES = new String[] {
			"boot"
	}; // TODO: Replace with ENUM.
	/**
	 * Set the height of the stage.
	 */
	private static int stageHeight = 400;
	/**
	 * Set the width of the stage.
	 */
	private static int stageWidth = 600;
	/**
	 * Find the location of the Single View used by the application.
	 */
	private static final String UI_FILE_LOCATION = "./ui/single_view/single-view.fxml";

	private static HashMap<String, String[]> filterCommands(final String[] args) {
		final HashMap<String, List<String>> groupedCommandsList = new HashMap<>();
		if(args.length != 0) for(final String arg : args) if(ProjectCreator.BOOT.supportsCommand(arg)) {
			List<String> bootCommands = groupedCommandsList.get(ProjectCreator.COMMAND_TYPES[0]);
			if(bootCommands == null) bootCommands = new ArrayList<>();
			bootCommands.add(arg);
			groupedCommandsList.put("boot", bootCommands);
		} else
			System.out.println("Provided arg \"" + arg + "\" is unknown. Ignoring argument.");

		final HashMap<String, String[]> groupedCommandsArray = new HashMap<>();
		for(final String key : groupedCommandsList.keySet()) {
			final List<String> values = groupedCommandsList.get(key);
			groupedCommandsArray.put(key, Arrays.copyOf(values.toArray(), values.size(), String[].class));
		}
		return groupedCommandsArray;
	}

	/**
	 * Read the application name.
	 *
	 * @return Returns the name of the application.
	 */
	public static String getApplicationName() { return ProjectCreator.APPLICATION_NAME; }

	/**
	 * Launch the application.
	 *
	 * @param args Console arguments that may be provided upon launch.
	 */
	public static void main(final String[] args) {
		final HashMap<String, String[]> groupedArgs = ProjectCreator.filterCommands(args);

		for(final String key : groupedArgs.keySet()) switch(key) {
			case "boot":
				try {
					final String[] bootCommands = groupedArgs.get(key);
					if(bootCommands.length < 1)
						throw new IllegalArgumentException("No boot mode arguments have been provided.");
					else if(bootCommands.length > 1)
						throw new IllegalArgumentException("Too many boot mode arguments have been provided.");
					else
						((SingleViewBootModeManager)ProjectCreator.BOOT).setBootMode(((SingleViewBootModeManager)ProjectCreator.BOOT).getBootMode(bootCommands[0]));
				} catch(final IllegalArgumentException e) {
					System.out.println(e.getMessage() + " Applying default boot mode."); // TODO: Replace with log component.
				}
				break;
			default:
				System.out.println("Key \"" + key + "\" not used.");
				break;
		}
		if(ProjectCreator.BOOT.isDefault()) System.out.println("Default boot mode is " + ProjectCreator.BOOT.getDefaultBootMode() + "."); // TODO: Replace with log component.
		System.out.println("Launching app in " + ProjectCreator.BOOT.getBootMode() + " boot mode."); // TODO: Replace with log component.
		Application.launch(args);
	}

	/**
	 * Launch the user interface.
	 *
	 * @param primaryStage The first stage launched by the application.
	 */
	@Override
	public void start(final Stage primaryStage) throws Exception {
		System.out.println("Loading in \"single-view.fxml\"..."); // TODO: Replace with log component.
		final Scene scene = new Scene(FXMLLoader.load(this.getClass().getResource(ProjectCreator.UI_FILE_LOCATION)), ProjectCreator.stageWidth, ProjectCreator.stageHeight);
		System.out.println("Loaded \"single-view.fxml\" successfully."); // TODO: Replace with log component.

		System.out.println("Displaying user interface..."); // TODO: Replace with log component
		primaryStage.setTitle(ProjectCreator.APPLICATION_NAME);
		primaryStage.setScene(scene);
		primaryStage.show();
		new SingleViewElementDesigner(scene).design();
		System.out.println("User interface displayed."); // TODO: Replace with log component.
	}
}
