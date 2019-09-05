package eu.electricfrog.projectcreator.core.application.configuration.boot;

/**
 * Define how the application is booted.
 *
 * @author  ScrapsBits
 * @since   1.0
 * @version 1.1
 */
public interface Boot {
	/**
	 * Get the boot mode used by the application.
	 *
	 * @return Returns the boot mode in which the application was started.
	 */
	BootMode getBootMode();
}