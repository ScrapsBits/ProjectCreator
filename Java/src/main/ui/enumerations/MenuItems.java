package main.ui.enumerations;

/**
 * Define all items displayed in the menu.
 * @author ScrapsBits
 *
 */
public enum MenuItems {
	/**
	 * A project menu item.
	 */
	PROJECT("Project", "Project", true),
	/**
	 * A menu item about programming.
	 */
	PROGRAMMING("Programming", "Programming", true),
	/**
	 * A menu item to create documentation files.
	 */
	DOCUMENTATION("Documentation", "Documentation", false),
	/**
	 * A menu item to create diagram files.
	 */
	DIAGRAMS("Diagrams", "Diagrams", false),
	/**
	 * A menu item to create additional files, such as GIT or SVN.
	 */
	ADDITIONAL_SOURCES("AdditionalSources", "Additional Sources", false),
	/**
	 * A menu item to complete all actions and let the program work.
	 */
	FINALIZE("Finalize", "Complete", true);

	/**
	 * The unique identifier for the menu item.
	 */
	private String id;
	/**
	 * The name of the menu item.
	 */
	private String name;
	/**
	 * Define if the menu item is supported.
	 */
	private boolean isSupported;

	private MenuItems(final String id, final String name, final boolean isSupported) {
		this.id = id;
		this.name = name;
		this.isSupported = isSupported;
	}

	public String getId() { return id; }

	public String getName() { return name; }

	public boolean isSupported() { return isSupported; }
}
