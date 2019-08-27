package eu.electricfrog.projectcreator.core.application.boot;

/**
 * Define how the application is booted.
 *
 * @author  ScrapsBits
 * @version 1.0
 */
public interface ApplicationBoot {
	/**
	 * Get the boot mode used by the application.
	 *
	 * @return Returns the boot mode in which the application was started.
	 */
	BootMode getBootMode();
}
