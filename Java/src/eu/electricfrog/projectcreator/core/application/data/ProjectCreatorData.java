package eu.electricfrog.projectcreator.core.application.data;

/**
 * Keep track of the ProjectCreator application data.
 *
 * @author  ScrapsBits
 * @since   1.0
 * @version 1.0
 */
public class ProjectCreatorData implements Data {
	/**
	 * The name of the application.
	 */
	private final String name = "ProjectCreator";
	/**
	 * The current version number of the application.
	 */
	private final String version = "1.1";
	/**
	 * The copyright owner of the application.
	 */
	private final String copyright = "ScrapsBits";

	@Override
	public String getCopyright() { return this.copyright; }

	@Override
	public String getName() { return this.name; }

	@Override
	public String getVersion() { return this.version; }
}
