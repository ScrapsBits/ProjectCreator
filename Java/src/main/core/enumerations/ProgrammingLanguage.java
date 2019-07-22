package main.core.enumerations;

/**
 * Keep a list of all supported programming languages.
 *
 * @author ScrapsBits
 */
public enum ProgrammingLanguage {
	/**
	 * An unknown or custom language. It's not supported by the application.
	 */
	UNKNOWN("", "", false, false),
	/**
	 * Represents the language "C++". It's considered a functional language. It's not supported by the application.
	 */
	CPLUSPLUS("CPlusPlus", "C++", true, false),
	/**
	 * Represents the language "C#". It's considered an object oriented language.
	 */
	CSHARP("CSharp", "C#", false, true),
	/**
	 * Represents the language "Java". It's considered an object oriented language.
	 */
	JAVA("Java", "Java", false, true);

	/**
	 * Each language has a unique ID. It may not contain any special characters.
	 */
	private String id;
	/**
	 * The name of the language. It may contain any character.
	 */
	private String name;
	/**
	 * Define if the language is functional. If true, it's functional. If false, it's object oriented.
	 */
	private boolean isFunctional;
	/**
	 * Define if the language is supported by the application.
	 */
	private boolean isSupported;

	/**
	 * Set all values for the language.
	 *
	 * @param id           The unique identifier of the language.
	 * @param name         The name of the language.
	 * @param isFunctional Defines if the language is functional or object oriented.
	 * @param isSupported  Defines if the language is supported by the application.
	 */
	private ProgrammingLanguage(final String id, final String name, final boolean isFunctional, final boolean isSupported) {
		this.id = id;
		this.name = name;
		this.isFunctional = isFunctional;
		this.isSupported = isSupported;
	}

	/**
	 * Fetch the ID of the language.
	 *
	 * @return Returns the language ID.
	 */
	public String getId() { return this.id; }

	/**
	 * Fetch the name of the language.
	 *
	 * @return Returns the language name.
	 */
	public String getName() { return this.name; }

	/**
	 * Fetch if the language is functional or object oriented.
	 *
	 * @return Returns true if the language is functional. Returns false if the language is object oriented.
	 */
	public boolean isFunctional() { return this.isFunctional; }

	/**
	 * Fetch if the language is supported by the application.
	 *
	 * @return Returns true if the language is supported. Returns false if the language is not supported.
	 */
	public boolean isSupported() { return this.isSupported; }

	/**
	 * Return the name of the programming language.
	 */
	@Override
	public String toString() { return this.name; }
}
