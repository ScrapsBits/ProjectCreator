package eu.electricfrog.projectcreator.ui.javafx;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.CheckMenuItem;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.RadioMenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.cell.CheckBoxListCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

/**
 * Generate JavaFX elements.
 *
 * @author  ScrapsBits
 * @since 1.0
 * @version 1.0
 */
public abstract class JavaFXGenerator {
	/**
	 * Keep track of the controller to allow linking to the various methods.
	 */
	protected final JavaFXController controller;
	/**
	 * Define the padding distance between the border and an element, and between two elements.
	 */
	protected final double padding = 7.2;
	/**
	 * Define the size of each column in the user interface.
	 */
	protected final double columnSize = 74;
	/**
	 * Define the size of each row in the user interface.
	 */
	protected final double rowSize = 24;
	/**
	 * Labels jump in a little bit to improve alignment visuals.
	 */
	protected final double labelJump = 6;

	/**
	 * Initialize the JavaFX generator with the provided controller.
	 *
	 * @param controller The controller used by the JavaFX application.
	 */
	protected JavaFXGenerator(final JavaFXController controller) { this.controller = controller; }

	/**
	 * Generate the components for the current view of the JavaFX user interface.
	 */
	public abstract void generate();

	protected final AnchorPane generateAnchorPane(final String id) {
		final AnchorPane anchorPane = new AnchorPane();
		anchorPane.setId(JavaFXElement.ANCHORPANE.getPrefix() + id);
		return anchorPane;
	}

	protected final BorderPane generateBorderPane(final String id) {
		final BorderPane borderPane = new BorderPane();
		borderPane.setId(JavaFXElement.BORDERPANE.getPrefix() + id);
		return borderPane;
	}

	protected final Button generateButton(final String id, final String text) {
		final Button button = new Button();
		button.setId(JavaFXElement.BUTTON.getPrefix() + id);
		button.setText(text);
		return button;
	}
	
	protected final ScrollPane generateScrollPane(final String id) {
		final ScrollPane scrollPane = new ScrollPane();
		scrollPane.setId(JavaFXElement.SCROLLPANE.getPrefix() + id);
		scrollPane.setVbarPolicy(ScrollBarPolicy.AS_NEEDED);
		scrollPane.setHbarPolicy(ScrollBarPolicy.NEVER);
		scrollPane.setFitToWidth(true);
		scrollPane.setFitToHeight(false);
		return scrollPane;
	}

	protected final CheckBox generateCheckBox(final String id, final String text, final boolean isChecked) {
		final CheckBox checkBox = new CheckBox();
		checkBox.setId(JavaFXElement.CHECKBOX.getPrefix() + id);
		checkBox.setText(text);
		checkBox.setAllowIndeterminate(false);
		checkBox.setSelected(isChecked);
		return checkBox;
	}

	protected final CheckBoxListCell<String> generateCheckBoxListCell(final String id) {
		final CheckBoxListCell<String> checkBoxListCell = new CheckBoxListCell<>();
		checkBoxListCell.setId(JavaFXElement.CHECKBOXLISTCELL.getPrefix() + id);

		return checkBoxListCell;
	}

	protected final CheckMenuItem generateCheckMenuItem(final String id, final String text) {
		final CheckMenuItem checkMenuItem = new CheckMenuItem();
		checkMenuItem.setId(JavaFXElement.CHECKMENUITEM.getPrefix() + id);
		checkMenuItem.setText(text);
		return checkMenuItem;
	}

	protected final ChoiceBox<String> generateChoiceBox(final String id) {
		final ChoiceBox<String> choiceBox = new ChoiceBox<>();
		choiceBox.setId(JavaFXElement.CHOICEBOX.getPrefix() + id);
		return choiceBox;
	}

	protected final Label generateLabel(final String id, final String text) {
		final Label label = new Label();
		label.setId(JavaFXElement.LABEL.getPrefix() + id);
		label.setText(text);
		return label;
	}

	protected final <T> ListView<T> generateListView(final String id) {
		final ListView<T> listView = new ListView<>();
		listView.setId(JavaFXElement.LISTVIEW.getPrefix() + id);
		return listView;
	}

	protected final Menu generateMenu(final String id, final String text) {
		final Menu menu = new Menu();
		menu.setId(JavaFXElement.MENU.getPrefix() + id);
		menu.setText(text);
		return menu;
	}

	protected final MenuBar generateMenuBar(final String id) {
		final MenuBar menuBar = new MenuBar();
		menuBar.setId(JavaFXElement.MENUBAR.getPrefix() + id);
		return menuBar;
	}

	protected final MenuItem generateMenuItem(final String id, final String text) {
		final MenuItem menuItem = new MenuItem();
		menuItem.setId(JavaFXElement.MENUITEM.getPrefix() + id);
		menuItem.setText(text);
		return menuItem;
	}

	protected final ToggleGroup generateRadioMenu(final String id, final String... itemTexts) {
		final ToggleGroup toggleGroup = new ToggleGroup();
		for(final String text : itemTexts) toggleGroup.getToggles().add(this.generateRadioMenuItem(id + toggleGroup.getToggles().size(), text));
		return toggleGroup;
	}

	protected final RadioMenuItem generateRadioMenuItem(final String id, final String text) {
		final RadioMenuItem radioMenuItem = new RadioMenuItem();
		radioMenuItem.setId(JavaFXElement.RADIOMENUITEM.getPrefix() + id);
		radioMenuItem.setText(text);
		return radioMenuItem;
	}

	protected final StackPane generateStackPane(final String id) {
		final StackPane stackPane = new StackPane();
		stackPane.setId(JavaFXElement.STACKPANE.getPrefix() + id);
		return stackPane;
	}

	protected final Tab generateTab(final String id, final String text) {
		final Tab tab = new Tab();
		tab.setId(JavaFXElement.TAB.getPrefix() + id);
		tab.setText(text);
		return tab;
	}

	protected final TabPane generateTabPane(final String id) {
		final TabPane tabPane = new TabPane();
		tabPane.setId(JavaFXElement.TABPANE.getPrefix() + id);
		return tabPane;
	}

	protected final TextField generateTextField(final String id, final String promptText, final String text) {
		final TextField textField = new TextField();
		textField.setId(JavaFXElement.TEXTFIELD.getPrefix() + id);
		textField.setPromptText(promptText);
		textField.setText(text);
		return textField;
	}

	/**
	 * Place and style the components for the current view of the JavaFX user interface;
	 */
	public abstract void position();
}
