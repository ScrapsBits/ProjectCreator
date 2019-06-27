package main.ui.enumerations;

/**
 * Keep track of all supported programming languages.
 *
 * @author ScrapsBits
 */
public enum ProgrammingLanguages {
	CSHARP("CSharp", "C#", false), JAVA("Java", "Java", false), CPLUSPLUS("CPlusPlus", "C++", true);

	private String id;
	private String name;
	private boolean isFunctional;

	private ProgrammingLanguages(final String id, final String value, final boolean isFunctional) {
		this.id = id;
		name = value;
		this.isFunctional = isFunctional;
	}

	public String getId() { return id; }

	public String getName() { return name; }

	public boolean isFunctional() { return isFunctional; }
}
