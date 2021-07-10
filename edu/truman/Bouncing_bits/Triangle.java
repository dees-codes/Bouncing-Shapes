/**
 * 
 */
package edu.truman.Bouncing_bits;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.Random;

/**
 * @author Deepson
 *
 */

/**
 * A triangle that can be moved around
 */
public class Triangle implements BouncingShape {
	
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
	 * Constructs a triangle
	 * @param x the left of the bounding square
	 * @param y the top of the bounding square
	 */
	public Triangle(int x, int y)
	{
		this.x = x;
		this.y = y;
		setProperties();
	}
	
	/**
	 * Sets properties of the triangle
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
	 * Moves the triangle shape
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
	 * Draw the triangle shape
	 * @param Graphics2D object to be drawn
	 */
	public void draw(Graphics2D g2)
	{
		//Constructing Point2D.Double objects for vertices of triangle
		Point2D.Double pointOne = new Point2D.Double(x + width/2, y);
		Point2D.Double pointTwo = new Point2D.Double(x, y + width);
		Point2D.Double pointThree = new Point2D.Double(x + width, y + width);
		
		//Constructing sides of a triangle
		Line2D.Double lineOne = new Line2D.Double(pointOne, pointTwo);
		Line2D.Double lineTwo = new Line2D.Double(pointTwo, pointThree);
		Line2D.Double lineThree = new Line2D.Double(pointThree, pointOne);
		
		//Set color to scolor
		g2.setColor(scolor);
		//Draw the sides of triangle
		g2.draw(lineOne);
		g2.draw(lineTwo);
		g2.draw(lineThree);
	}

}
