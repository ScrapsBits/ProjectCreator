package eu.electricfrog.projectcreator.core.device.data;

/**
 * Keep track of all data related to this system.
 *
 * @author  ScrapsBits
 * @since   1.1
 * @version 1.1
 */
public final class DeviceDataManager implements DeviceData {
	/**
	 * Get the operating system running on this system.
	 *
	 * @return Returns the operating system read from the system.
	 */
	@Override
	public String getOS() {
		final String os = System.getProperty("os.name");
		System.out.println("Detected OS: " + os); // TODO: Replace with log component.
		return os;
	}
}
