/**
 * 
 */
package edu.truman.Bouncing_bits;

import java.awt.*;
import java.awt.geom.*;
import java.util.*;

/**
 * @author Deepson
 *
 */

/**
 *  A circle that can be moved around.
 */
public class Circle implements BouncingShape {

	private int x;			// x-coordinate of bounding square
	private int y;			// y-coordinate of bounding square
	private int width;		// width of bounding square
	
	// r,g,b integer values for color.
	private int r;			
	private int g;
	private int b;
	
	private int dx;			// change in x-coordinate
	private int dy;			// change in y-coordinate
	private Color scolor; 	// shape color
	
	/**
	 * Constructs a circle
	 * @param x the left of the bounding square
	 * @param y the top of the bounding square
	 */
	public Circle(int x, int y)
	{
		this.x = x;
		this.y = y;
		setProperties();
	}
	
	/**
	 * Sets properties of the circle
	 */
	private void setProperties()
	{	
		int maxrgbValue = 255;
		int maxWidth = 100;
		int minWidth = 10;
		int maxd = 5;
		int mind = 1;
		
		// Random object
		Random rand = new Random();
		// Set width in the range 10 - 100 (inclusive)
		width = rand.nextInt(maxWidth - minWidth + 1 ) + minWidth;
		// Set r,g,b in the range 0 - 255 (inclusive)
		r= rand.nextInt(maxrgbValue + 1);
		g= rand.nextInt(maxrgbValue + 1);
		b= rand.nextInt(maxrgbValue + 1);
		// Set scolor with r,g,b
		scolor = new Color(r, g, b);
		// Set dx, dy in the range 1 - 5 (inclusive)
		dx = rand.nextInt(maxd - mind + 1) + mind;
		dy = rand.nextInt(maxd - mind + 1) + mind;
	}

	/**
	 * Moves the circle shape
	 */
	public void move()
	{
		int left_wall = 0;
		int right_wall = 600;
		int upper_wall = 0;
		int lower_wall = 400;
		
		// If adding dx moves the shape outside of icon width (0-600), 
		// reverse direction
		if ((x + dx < left_wall) || (x + dx + width > right_wall)) {dx = -dx;} 
		// Shift in x axis by dx
		x += dx;
		
		// If adding dy moves the shape outside of icon height (0-400), 
		// reverse direction
		if ((y + dy < upper_wall) || (y + dy + width > lower_wall)) {dy = -dy;}
		// Shift in y axis by dy
		y += dy;
	}
	
	/**
	 * Draw the circle shape
	 * @param Graphics2D object to be drawn
	 */
	public void draw(Graphics2D g2)
	{
		//Constructing a Ellipse2D.Double object which fits in a square of passed
		//width and height
		Ellipse2D.Double Circle = new Ellipse2D.Double(x, y, width, width);
		//Set color to scolor
		g2.setColor(scolor);
		//Fill the circle
		g2.fill(Circle);
	}
}
