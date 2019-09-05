package eu.electricfrog.projectcreator.core.application.boot;

/**
 * Define the boot mode for the application.
 *
 * @author  ScrapsBits
 * @since   1.0
 * @version 1.1
 */
public class ProjectCreatorBoot implements ApplicationBoot {
	/**
	 * Defines the default boot mode for the application.
	 */
	private final BootMode defaultBootMode = BootMode.DEVELOPMENT;
	/**
	 * The application launches in this set boot mode.
	 */
	private final BootMode bootMode;

	/**
	 * Initialize the boot mode with the provided value.
	 *
	 * @param bootMode
	 */
	public ProjectCreatorBoot(final BootMode bootMode) {
		// TODO: Add null check.
		this.bootMode = bootMode;
		System.out.println("Boot mode set to " + this.bootMode.toString().toLowerCase() + ".");
	}

	@Override
	public BootMode getBootMode() { return this.bootMode; }

	@Override
	public BootMode getDefaultBootMode() { return defaultBootMode; }
}
