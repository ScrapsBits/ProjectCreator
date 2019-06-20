package main.ui.generator.enumerations;

public enum UserInterfaceElements {
	STACKPANE("stp"),
	BUTTON("btn"),
	LABEL("lbl"),
	TEXTFIELD("txf"),
	CHECKBOX("chb"),
	ANCHORPANE("acp"),
	TAB("tab"),
	TABPANE("tbp");
	
	private String prefix;
	
	public String getPrefix() {
		return prefix;
	}
	
	private UserInterfaceElements(String prefix) {
		this.prefix = prefix;
	}
}
