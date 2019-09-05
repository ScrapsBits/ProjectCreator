package eu.electricfrog.projectcreator.core.models;

/**
 * A language used for programming.
 * 
 * @author  ScrapsBits
 * @since 1.0
 * @version 1.0
 */
public class ProgrammingLanguage {
	/**
	 * The language name.
	 */
	private final String name;
	/**
	 * The version of this language used in the project.
	 */
	private final String version;
	/**
	 * The type of language this is.
	 */
	private final ProgrammingLanguageType type;

	/**
	 * Initialize a new language.
	 * 
	 * @param name
	 */
	public ProgrammingLanguage(final String name, final String version, final ProgrammingLanguageType type) {
		this.name = name;
		this.version = version;
		this.type = type;
	}

	public ProgrammingLanguage(final String name, final String version, final String type) { this(name, version, ProgrammingLanguageType.valueOf(type.toUpperCase())); }

	@Override
	public final boolean equals(final Object obj) {
		if(obj instanceof ProgrammingLanguage) {
			final ProgrammingLanguage programmingLanguage = (ProgrammingLanguage)obj;
			return this.name.contentEquals(programmingLanguage.name) && this.version.contentEquals(programmingLanguage.version);
		}
		return false;
	}

	/**
	 * Get the name of the language.
	 * 
	 * @return Returns the language name.
	 */
	public final String getName() { return this.name; }

	/**
	 * Get the type of this language.
	 * 
	 * @return Returns an enum value representing the type of this language.
	 */
	public final ProgrammingLanguageType getType() { return this.type; }

	/**
	 * Get the version of this programming language.
	 * 
	 * @return Returns the version of the language.
	 */
	public final String getVersion() { return this.version; }

	@Override
	public final int hashCode() {
		final String nameWithVersion = this.name + this.version;
		return nameWithVersion.hashCode();
	}

	/**
	 * Returns a string representation of this language.
	 * 
	 * @return Returns the name of the language.
	 */
	@Override
	public final String toString() { return this.getName() + " (" + this.getVersion() + ")"; }
	
	/**
	 * Returns a string representation of this language exclusively in letters.
	 * @return Returns the name of the language in letters.
	 */
	public final String toCharString() { return this.getName().replaceAll("#", "Sharp"); }
}
