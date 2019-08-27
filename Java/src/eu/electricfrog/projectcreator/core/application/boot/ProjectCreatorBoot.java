package eu.electricfrog.projectcreator.core.application.boot;

/**
 * Define the boot mode for the application.
 *
 * @author  ScrapsBits
 * @version 1.0
 */
public class ProjectCreatorBoot implements ApplicationBoot {
	/**
	 * Defines the default boot mode for the application.
	 */
	public static final BootMode DEFAULT_BOOT_MODE = BootMode.DEVELOPMENT;
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
}
