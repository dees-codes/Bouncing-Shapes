// Deepson Shrestha
// CS 260 Project-3 : ---> Animated Bouncing Shapes

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import edu.truman.Bouncing_bits.*;

/**
 * 
 * @author Deepson
 *
 */

/**
 * Main class
 */
public class ShresthaAnimation {
	public static void main(String[] args) {
		// Constants for icon height and icon width
		final int iconHeight = 400;
		final int iconWidth = 600;
		// Creating ShapeContainer object with iconHeight and iconWidth
		final ShapeContainer container = new ShapeContainer(iconWidth, iconHeight);

		// Creating a JFrame object
		JFrame frame = new JFrame();

		// Creating button named "Add a Square"
		JButton squareButton = new JButton("Add a Square");
		// Create action to perform when the button is pressed and add
		// the action listener to the squareButton object
		squareButton.addActionListener(
				new ActionListener() 
				{
					public void actionPerformed(ActionEvent event) {
						// Construct a Square object at the upper left corner.
						final BouncingShape shape1 = new Square(0, 0);
						// Add the square object to the container
						container.addShape(shape1);
					}
				}
		);
		// add button representing squareButton object to the frame
		frame.add(squareButton);

		// Creating button named "Add a Circle"
		JButton circleButton = new JButton("Add a Circle");
		// Create action to perform when the button is pressed and add
		// the action listener to the circleButton object
		circleButton.addActionListener(
				new ActionListener() 
				{
					public void actionPerformed(ActionEvent event) {
						// Construct a Circle object at the upper left corner.
						final BouncingShape shape2 = new Circle(0, 0);
						// Add the circle object to the container
						container.addShape(shape2);
					}
				}
		);
		// add button representing squareButton object to the frame
		frame.add(circleButton);

		// Creating button named "Add a Triangle"
		JButton triangleButton = new JButton("Add a Triangle");
		// Create action to perform when the button is pressed and add
		// the action listener to the triangleButton object
		triangleButton.addActionListener(
				new ActionListener() 
				{
					public void actionPerformed(ActionEvent event) {
						// Construct a Triangle object at the upper left corner.
						final BouncingShape shape3 = new Triangle(0, 0);
						// Add the triangle object to the container
						container.addShape(shape3);
					}
				}
		);
		// add button representing triangleButton object to the frame
		frame.add(triangleButton);

		// Creating a JLabel with container as the parameter
		final JLabel label = new JLabel(container);
		// Add the label to the frame
		frame.add(label);
		// Set the Layout of the frame
		frame.setLayout(new FlowLayout());

		// Exit the application on clicking exit button
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// sizing the frame so that the contents are at or above the
		// preferred sizes
		frame.pack();
		// make the frame visible
		frame.setVisible(true);

		// timer delay of 42 milliseconds
		final int DELAY = 42;

		// Creating timer object that fires 24 times a second
		Timer t = new Timer(DELAY, new 
				ActionListener() 
				{
					public void actionPerformed(ActionEvent event) 
					{
						// Move contents of container in every cycle
						container.move();
						// Repaint the label in every cycle
						label.repaint();
					}
				});
		// Start the timer
		t.start();

	}

}
