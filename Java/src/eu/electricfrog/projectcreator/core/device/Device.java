package eu.electricfrog.projectcreator.core.device;

import eu.electricfrog.projectcreator.core.device.data.DeviceData;
import eu.electricfrog.projectcreator.core.device.data.DeviceDataManager;

/**
 * A manager class keeping track of all system related information.
 *
 * @author  ScrapsBits
 * @since   1.1
 * @version 1.1
 */
public final class Device {
	/**
	 * A Singleton reference to itself.
	 */
	private static Device device;

	/**
	 * Get the system class instance. If none exists, it creates one.
	 *
	 * @return Returns a single instance of the System class.
	 */
	private static Device device() {
		if(Device.device == null) Device.device = new Device();
		return Device.device;
	}

	/**
	 * Gets the OS running on this device.
	 *
	 * @return Returns a string representation of the OS running on this device.
	 */
	public static String getOS() { return Device.device().getDeviceData().getOS(); }

	/**
	 * A hidden constructor, used to create a Singleton instance of this class.
	 */
	private Device() {}

	/**
	 * Expose an initialization of the DeviceData implementation interface.
	 *
	 * @return Returns an implementation of the DeviceData interface.
	 */
	private DeviceData getDeviceData() { return new DeviceDataManager(); }
}
