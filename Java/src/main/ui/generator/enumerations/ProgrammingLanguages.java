package main.ui.generator.enumerations;

/**
 * Keep track of all supported programming languages.
 * 
 * @author ScrapsBits
 *
 */
public enum ProgrammingLanguages {
	CSHARP("CSharp", "C#", false), JAVA("Java", "Java", false);

	private String id;
	private String name;
	private boolean isFunctional;

	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isFunctional() {
		return isFunctional;
	}

	private ProgrammingLanguages(String id, String value, boolean isFunctional) {
		this.id = id;
		this.name = value;
		this.isFunctional = isFunctional;
	}
}
