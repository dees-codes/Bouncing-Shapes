/**
 * 
 */
package edu.truman.Bouncing_bits;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import javax.swing.*;
import java.util.*;

/**
 * @author Deepson
 *
 */

/**
 * A class for drawing and holding different shapes.
 */
public class ShapeContainer implements Icon {
	// Variables for ShapeContainer object's width and height
	private int w;
	private int h;
	// ArrayList for holding all the created shapes
	private ArrayList<BouncingShape> ShapeArray = new ArrayList<BouncingShape>();
	
	/** Creating a new object that stores information about icon to be painted.
	 * @param width the width of the icon
	 * @param height the height of the icon
	 */
	public ShapeContainer(int width, int height)
	{
		this.w = width;
		this.h = height;		
	}
	
	/** Add shape to the array list of shapes
	 * @param n the shape to be added to the array list
	 */
	public void addShape(BouncingShape n)
	{
		ShapeArray.add(n);
	}
	
	/** Move the shapes in the array list
	 */
	public void move() {
		// Iterating through the ShapeArray
		for (int i = 0; i < ShapeArray.size(); i++) 
		{
			//Get each shape from array list and move it.
			ShapeArray.get(i).move();
		}
	}
	
	/** Return icon width
	 * @return the width of the icon
	 */
	public int getIconWidth()
	{
		return w;
	}
	
	/** Return icon height
	 * @return the height of the icon
	 */
	public int getIconHeight()
	{
		return h;
	}
	
	/** Draw the icon at the specified location.
	 * @param c object with a graphical representation that can be displayed and 
	 * 			interacted with
	 * @param g graphics context that carries out required drawing operation
	 * @param x x-coordinate of top left corner of icon
	 * @param y y-coordinate of top left corner of icon
	 */
	@Override
	public void paintIcon(Component c, Graphics g, int x, int y)
	{
		/* Cast the graphics context object from the old kind
		 * to the new kind.
		 */
		Graphics2D g2 = (Graphics2D) g;
		
		// Draw a rectangle that shows the icon's boundary
		// Width and height set to w-1 and h-1 respectively to make boundary visible.
		Rectangle2D.Double border = new Rectangle2D.Double(x, y, w-1, h-1);
		g2.draw(border);
		
		// Iterate through ShapeArray to get and draw each shape from the array list.
		for (int i = 0; i < ShapeArray.size(); i++) 
		{
			ShapeArray.get(i).draw(g2);
		}
	}
}
