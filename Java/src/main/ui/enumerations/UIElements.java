package main.ui.enumerations;

public enum UIElements {
	ANCHORPANE("acp"), BUTTON("btn"), CHECKBOX("chb"), LABEL("lbl"), STACKPANE("stp"), TAB("tab"), TABPANE("tbp"), TEXTFIELD("txf");

	private String prefix;

	private UIElements(final String prefix) { this.prefix = prefix; }

	public String getPrefix() { return this.prefix; }
}
