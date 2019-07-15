package main.core.enumerations;

public enum ProgrammingLanguage {
	UNKNOWN("", "", false, false), CPLUSPLUS("CPlusPlus", "C++", false, false), CSHARP("CSharp", "C#", true, true), JAVA("Java", "Java", true, true);

	private String id;
	private String name;
	private boolean isFunctional;
	private boolean isSupported;

	public String getId() { return this.id; }

	public String getName() { return this.name; }

	public boolean isFunctional() { return this.isFunctional; }

	public boolean isSupported() { return this.isSupported; }

	private ProgrammingLanguage(String id, String name, boolean isFunctional, boolean isSupported) {
		this.id = id;
		this.name = name;
		this.isFunctional = isFunctional;
		this.isSupported = isSupported;
	}

	@Override
	public String toString() { return this.name; }
}
