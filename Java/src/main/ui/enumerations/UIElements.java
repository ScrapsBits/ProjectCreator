package main.ui.enumerations;

public enum UIElements {
	STACKPANE("stp"), BUTTON("btn"), LABEL("lbl"), TEXTFIELD("txf"), CHECKBOX("chb"), ANCHORPANE("acp"), TAB("tab"),
	TABPANE("tbp");

	private String prefix;

	private UIElements(final String prefix) {
		this.prefix = prefix;
	}

	public String getPrefix() {
		return prefix;
	}
}
