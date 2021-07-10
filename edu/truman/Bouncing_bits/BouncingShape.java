/**
 * 
 */
package edu.truman.Bouncing_bits;

import java.awt.Graphics2D;
/**
 * @author Deepson
 *
 */
public interface BouncingShape {
	/** Change the position of the objects bounding box.
	 */
	void move();
	
	/** Draw the object in the given graphics context.
	 * @param g2 the graphics context in which to draw or fill
	 */
	void draw (Graphics2D g2);
}
