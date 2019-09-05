package eu.electricfrog.projectcreator.core.application.boot;

/**
 * Define how the application is booted.
 *
 * @author  ScrapsBits
 * @since 1.0
 * @version 1.1
 */
public interface ApplicationBoot {
	/**
	 * Get the boot mode used by the application.
	 *
	 * @return Returns the boot mode in which the application was started.
	 */
	BootMode getBootMode();
	/**
	 * Get the default boot mode used by the application.
	 * @return Returns the default boot mode.
	 */
	BootMode getDefaultBootMode();
}
