package main.ui.generator.enumerations;

/**
 * Keep track of all supported programming languages.
 * 
 * @author ScrapsBits
 *
 */
public enum ProgrammingLanguages {
	CSHARP("CSharp", "C#"), JAVA("Java", "Java");

	private String id;
	private String name;

	public String getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}

	private ProgrammingLanguages(String id, String value) {
		this.id = id;
		this.name = value;
	}
}
