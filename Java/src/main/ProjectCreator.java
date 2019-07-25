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
	 * Find the location of the Single View used by the application.
	 */
	private static final String SINGLE_VIEW_LOCATION = "./ui/single_view/single-view.fxml";
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
	public static final BootMode bootMode() { return ProjectCreator.BOOT_MODULE.getCurrentBootMode(); }

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
	public static final void main(final String[] args) {
		try {
			String bootCommand = null;
			for(final String arg : args) {
				if(ProjectCreator.BOOT_MODULE.hasCommand(arg)) {
					System.out.println("Received command \"" + arg + "\"."); // TODO: Replace with log component.
					if(bootCommand != null) throw new IllegalArgumentException("Too many boot mode arguments have been provided.");
					bootCommand = arg;
				}
			}
			if(bootCommand == null) throw new IllegalArgumentException("No boot mode arguments have been provided."); // TODO: Replace with log component.
			ProjectCreator.BOOT_MODULE.setBootMode(bootCommand);
		} catch(IllegalArgumentException e) {
			System.out.println(e.getMessage() + " Applying default boot mode."); // TODO: Replace with log component.
			System.out.println("Default boot mode is " + ProjectCreator.BOOT_MODULE.getDefaultBootMode() + "."); // TODO: Replace with log component.
		} finally {
			System.out.println("Launching app in " + ProjectCreator.BOOT_MODULE.getCurrentBootMode() + " boot mode."); // TODO: Replace with log component.
			Application.launch(args);
		}
	}

	/**
	 * Launch the user interface.
	 *
	 * @param primaryStage The first stage launched by the application.
	 */
	@Override
	public final void start(final Stage primaryStage) throws Exception {
		System.out.println("Loading in \"single-view.fxml\"..."); // TODO: Replace with log component.
		final Scene scene = new Scene(FXMLLoader.load(this.getClass().getResource(ProjectCreator.SINGLE_VIEW_LOCATION)), ProjectCreator.stageWidth, ProjectCreator.stageHeight);
		System.out.println("Loaded \"single-view.fxml\" successfully."); // TODO: Replace with log component.

		System.out.println("Displaying user interface..."); // TODO: Replace with log component
		primaryStage.setTitle(ProjectCreator.APPLICATION_NAME);
		primaryStage.setScene(scene);
		primaryStage.show();
		new SingleViewElementDesigner(scene).design();
		System.out.println("User interface displayed."); // TODO: Replace with log component.
	}
}
