package main.ui.generator.enumerations;

public enum MenuItems {
	PROJECT("Project", "Project", true), PROGRAMMING("Programming", "Programming", true),
	DOCUMENTATION("Documentation", "Documentation", false), DIAGRAMS("Diagrams", "Diagrams", false),
	ADDITIONAL_SOURCES("AdditionalSources", "Additional Sources", false), FINALIZE("Finalize", "Complete", true);

	private String id;
	private String name;
	private boolean isSupported;

	private MenuItems(final String id, final String name, final boolean isSupported) {
		this.id = id;
		this.name = name;
		this.isSupported = isSupported;
	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public boolean isSupported() {
		return isSupported;
	}
}
