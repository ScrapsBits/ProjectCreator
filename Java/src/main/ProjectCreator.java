package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.ui.BootModule;
import main.ui.enumerations.BootMode;
import main.ui.single_view.SingleViewElementDesigner;

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
	 * The boot mode used when no specific arguments have been provided.
	 */
	private static final BootMode DEFAULT_BOOT_MODE = BootMode.DEVELOPMENT;
	/**
	 * Find the location of the Single View used by the application.
	 */
	private static final String SINGLE_VIEW_LOCATION = "./ui/single_view/single-view.fxml";
	/**
	 * Boot up the application using this boot mode.
	 */
	private static BootMode bootMode = BootMode.DEFAULT;
	/**
	 * Keep track of all boot commands supported by the module. Commands are stored in a HashMap.
	 */
	private static final BootModule BOOT_MODULE = new BootModule();
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
		try {
			// Check if only one boot command has been provided. If multiple boot commands have been provided, use default boot mode.
			byte bootCommands = 0;
			for(final String arg : args) if(ProjectCreator.BOOT_MODULE.hasCommand(arg)) if((bootCommands += 1) == 1) {
				System.out.println("Boot mode set to " + ProjectCreator.BOOT_MODULE.getBootMode(arg) + "."); // TODO: Replace with log component.
				ProjectCreator.bootMode = ProjectCreator.BOOT_MODULE.getBootMode(arg);
			} else if(bootCommands > 1) throw new IllegalArgumentException("Too many boot mode arguments have been provided. Reverting to default boot mode.");
			if(bootCommands == 0) System.out.println("No boot mode arguments have been provided. Applying default boot mode."); // TODO: Replace with log component.
		} catch(final IllegalArgumentException e) {
			// Something went wrong. Set boot mode to default.
			System.out.println(e.getMessage()); // TODO: Replace with log component.
			ProjectCreator.bootMode = BootMode.DEFAULT;
		} finally {
			// If the selected boot mode is default, use what's set as default boot mode.
			if(ProjectCreator.bootMode == BootMode.DEFAULT) {
				System.out.println("Default boot mode is " + ProjectCreator.DEFAULT_BOOT_MODE + "."); // TODO: Replace with log component.
				ProjectCreator.bootMode = ProjectCreator.DEFAULT_BOOT_MODE;
			}

			// If default boot mode is set to default by accident, use normal mode.
			if(ProjectCreator.bootMode == BootMode.DEFAULT) ProjectCreator.bootMode = BootMode.NORMAL;

			System.out.println("Launching app in " + ProjectCreator.bootMode + " boot mode..."); // TODO: Replace with log component.
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
		System.out.println("Loading in \"single-view.fxml\"..."); // TODO: Replace with log component.
		final Scene scene = new Scene(FXMLLoader.load(this.getClass().getResource(ProjectCreator.SINGLE_VIEW_LOCATION)), ProjectCreator.stageWidth, ProjectCreator.stageHeight);
		System.out.println("Loaded \"single-view.fxml\" successfully."); // TODO: Replace with log component.

		System.out.println("Initializing user interface."); // TODO: Replace with log component.
		primaryStage.setTitle("Create new project");
		primaryStage.setScene(scene);
		System.out.println("User interface initialized."); // TODO: Replace with log component.

		System.out.println("Displaying user interface..."); // TODO: Replace with log component
		primaryStage.show();
		new SingleViewElementDesigner(scene).design();
		System.out.println("User interface displayed."); // TODO: Replace with log component.
	}
}
