package main.ui;

public class Controller {
	public void initialize() {
		String javaVersion = System.getProperty("java.version");
		String javafxVersion = System.getProperty("javafx.version");
		System.out.println("JavaFX " + javafxVersion + "\nRunning on Java" + javaVersion + ".");
	}
}
