

/**
 * Triangle.java
 * @version 2.0.0
 * Originally written by Bette Bultena but heavily modified for the purposes of 
 * CSC-115 (Daniel Archambault and Liam O'Reilly)
 */

import javafx.scene.paint.Color;
import javafx.scene.canvas.GraphicsContext;

/**
 *
 * Triangle is an Triangle shape that can be drawn to the screen, either
 * filled with colour or opaque.
 * Its position is determined by the upper left corner of the
 * Triangle's bounding Triangle
 */
public class Triangle extends ClosedShape {
	//The width and height of the Triangle (major and minor axis)
	private int width, height;

	/**
	 * Creates an Triangle.
	 * @param x The display component's x position.
	 * @param y The display component's y position.
	 * @param vx The display component's x velocity.
	 * @param vy The display component's y velocity.
	 * @param width The width of the Triangle (in pixels).
	 * @param height The height of the Triangle (in pixels).
	 * @param colour The line colour or fill colour.
	 * @param isFilled True if the Triangle is filled with colour, false if opaque.
	 */
	public Triangle (int insertionTime, int x, int y, int vx, int vy, int width, int height, Color colour, boolean isFilled, boolean pulse) {
		super (insertionTime, x, y, vx, vy, colour, isFilled, pulse);
		this.width = width;
		this.height = height;
	}

	/**
     * Method to convert an Triangle to a string.
     */
    public String toString () {
    	String result = "This is an Triangle\n";
    	result += super.toString ();
	result += "Its width is " + this.width + " and its height is " + this.height + "\n";
    	return result;
    }

	/**
	 * @param width Resets the width.
	 */
 	public void setWidth (int width) {
		this.width = width;
	}

 	/**
 	 * @param height Resets the height.
 	 */
 	public void setHeight (int height) {
		this.height = height;
	}

 	/**
 	 * @return The width of the Triangle.
 	 */
 	public int getWidth() {
		return width;
	}

 	/**
 	 * @return The height of the Triangle.
 	 */
 	public int getHeight() {
		return height;
	}

 	/**
 	 * Draw the Triangle.
 	 * @param g The graphics object of the drawable component.
 	 */
	public void draw (GraphicsContext g) {
		double[] triX = {x, x+(width/2), x+height};
		double[] triY = {y, y+height, y+width};
		
		g.setFill (colour);
		g.setStroke( colour );
		if (isFilled) {
			g.fillPolygon( triX, triY, 3 );
		} 
		else {
			g.strokePolygon( triX, triY, 3 );
		}
	}
}
