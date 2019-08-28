package eu.electricfrog.projectcreator.ui.javafx;

/**
 * JavaFX elements with a prefix used in the ID creation for these elements.
 *
 * @author  ScrapsBits
 * @version 1.0
 */
public enum JavaFXElement {
	ANCHORPANE("acp"), BORDERPANE("bdr"), BUTTON("btn"), CHECKBOX("chb"), CHECKMENUITEM("cmi"), LABEL("lbl"), MENU("mnu"), MENUBAR("mnb"), MENUITEM("mni"), RADIOBUTTON("rbt"),
	RADIOMENU("rmn"), RADIOMENUITEM("rmi"), STACKPANE("stp"), TAB("tab"), TABPANE("tbp"), TEXTFIELD("txf"), LISTVIEW("ltv"), CHECKBOXLISTCELL("clc"), CHOICEBOX("chb");

	/**
	 * The prefix for this JavaFX element.
	 */
	private String prefix;

	/**
	 * Initiate an enum value with a prefix.
	 *
	 * @param prefix The prefix used by the element represented by the enumeration value.
	 */
	private JavaFXElement(final String prefix) { this.prefix = prefix; }

	/**
	 * Get the prefix of this element.
	 *
	 * @return Return the element prefix.
	 */
	public final String getPrefix() { return this.prefix; }
}
