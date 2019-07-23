package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
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
	private static final BootMode DEFAULT_BOOT_MODE = BootMode.SAFE;
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
	public static final String getApplicationName() { return ProjectCreator.APPLICATION_NAME; }

	/**
	 * Launch the application.
	 *
	 * @param args Console arguments that may be provided upon launch.
	 */
	public static void main(final String[] args) {
		try {
			// TODO: Load in BOOT_MODULE commands from external source.
			ProjectCreator.BOOT_MODULE.addBootCommand("default", BootMode.DEFAULT);
			ProjectCreator.BOOT_MODULE.addBootCommand("normal", BootMode.NORMAL);
			ProjectCreator.BOOT_MODULE.addBootCommand("safe", BootMode.SAFE);
			ProjectCreator.BOOT_MODULE.addBootCommand("safemode", BootMode.SAFE);
			ProjectCreator.BOOT_MODULE.addBootCommand("development", BootMode.DEVELOPMENT);
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		try {
			int bootCommands = 0;
			for(final String arg : args) {
				if(ProjectCreator.BOOT_MODULE.hasCommand(arg)) bootCommands += 1;
				if(bootCommands == 1) {
					System.out.println("Boot mode set to " + ProjectCreator.BOOT_MODULE.getBootMode(arg) + "."); // TODO: Replace with log component.
					ProjectCreator.bootMode = ProjectCreator.BOOT_MODULE.getBootMode(arg);
				} else if(bootCommands > 1) throw new IllegalArgumentException("Too many boot mode arguments have been provided. Reverting to default boot mode.");
			}
		} catch(final IllegalArgumentException e) {
			System.out.println(e.getMessage()); // TODO: Replace with log component.
		} finally {
			if(ProjectCreator.bootMode == BootMode.DEFAULT) {
				System.out.println("Default boot mode is " + ProjectCreator.DEFAULT_BOOT_MODE + "."); // TODO: Replace with log component.
				ProjectCreator.bootMode = ProjectCreator.DEFAULT_BOOT_MODE;
			}
			System.out.println("Launching app in " + ProjectCreator.bootMode + " boot mode."); // TODO: Replace with log component.
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
		System.out.println("Starting app..."); // TODO: Replace with log component.
		final Parent root = FXMLLoader.load(this.getClass().getResource(ProjectCreator.SINGLE_VIEW_LOCATION));
		final Scene scene = new Scene(root, ProjectCreator.stageWidth, ProjectCreator.stageHeight);

		System.out.println("Launching user interface. Loading in \"single-view.fxml\"."); // TODO: Replace with log component.
		primaryStage.setTitle("Create new project");
		primaryStage.setScene(scene);

		System.out.println("User interface initialized. \nDisplaying initialized interface."); // TODO: Replace with log component
		primaryStage.show();
		new SingleViewElementDesigner(scene).design();
	}
}
