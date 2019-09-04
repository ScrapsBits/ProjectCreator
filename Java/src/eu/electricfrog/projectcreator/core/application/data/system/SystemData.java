package eu.electricfrog.projectcreator.core.application.data.system;

public final class SystemData {
	public final String getOS() {
		String os = System.getProperty("os.name");
		System.out.println("Detected OS: " + os); // TODO: Replace with log component.
		return os;
	}
}
