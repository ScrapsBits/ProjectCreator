package main.ui.enumerations;

import main.core.enumerations.ProgrammingLanguage;

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
	
	public ProgrammingLanguage toCoreLanguage() {
		switch(this) {
			case CPLUSPLUS:
				return ProgrammingLanguage.CPLUSPLUS;
			case CSHARP:
				return ProgrammingLanguage.CSHARP;
			case JAVA:
				return ProgrammingLanguage.JAVA;
			default:
				return ProgrammingLanguage.UNKNOWN;
		}
	}
	
	public static ProgrammingLanguages toUILanguage(ProgrammingLanguage value) {
		switch(value) {
			case CPLUSPLUS:
				return ProgrammingLanguages.CPLUSPLUS;
			case CSHARP:
				return ProgrammingLanguages.CSHARP;
			case JAVA:
				return ProgrammingLanguages.JAVA;
			default:
				throw new IllegalArgumentException();
		}
	}
}
