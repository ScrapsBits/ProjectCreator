package main.ui;

/**
 * Give a default style to certain elements.
 *
 * @author ScrapsBits
 */
public abstract class ElementDesigner {
	private final double frameHeight;
	private final double frameMarginX;
	private final double frameMarginY;
	private final double frameWidth;
	private final double innerMarginX;
	private final double innerMarginY;

	/**
	 * Initialize the element designer.
	 */
	protected ElementDesigner(final double frameWidth, final double frameHeight, final double frameMarginX, final double frameMarginY, final double innerMarginX, final double innerMarginY) {
		if(frameWidth < 1) throw new IllegalArgumentException("Frame width must be 1 or greater.");
		this.frameWidth = frameWidth;
		if(frameHeight < 1) throw new IllegalArgumentException("Frame height must be 1 or greater.");
		this.frameHeight = frameHeight;
		if(frameMarginX < 1) throw new IllegalArgumentException("Horizontal frame margin must be 1 or greater.");
		this.frameMarginX = frameMarginX;
		if(frameMarginY < 1) throw new IllegalArgumentException("Vertical frame margin must be 1 or greater.");
		this.frameMarginY = frameMarginY;
		if(innerMarginX < 1) throw new IllegalArgumentException("Horizontal inner margin must be 1 or greater.");
		this.innerMarginX = innerMarginX;
		if(innerMarginY < 1) throw new IllegalArgumentException("Vertical inner margin must be 1 or greater.");
		this.innerMarginY = innerMarginY;
	}

	/**
	 * Design all elements with a default style.
	 */
	public abstract void design();

	/**
	 * Give all buttons a default style.
	 */
	protected abstract void designButtons();

	/**
	 * Give all checkboxes a default style.
	 */
	protected abstract void designCheckBoxes();

	/**
	 * Give all labels a default style.
	 */
	protected abstract void designLabels();

	/**
	 * Give all text fields a default style.
	 */
	protected abstract void designTextFields();

	protected double getFrameHeight() { return this.frameHeight; }

	protected double getFrameMarginX() { return this.frameMarginX; }

	protected double getFrameMarginY() { return this.frameMarginY; }

	protected double getFrameWidth() { return this.frameWidth; }

	protected double getInnerMarginX() { return this.innerMarginX; }

	protected double getInnerMarginY() { return this.innerMarginY; }
}
