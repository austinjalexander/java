// File: MyLine.java
// Student: Austin J. Alexander
// Assignment: Midterm Problem 3 (10.1 [which also relied on 9.1])
// Course: MET CS565 (SPRING 2015)
/*** *** ***
     ATTENTION: PER THE INSTRUCTIONS, THE MAJORITY OF THE CODE IN THIS 
     FILE HAS BEEN COPIED FROM THE TEXTBOOK
 *** *** ***/

// Fig. 8.17: MyLine.java
// MyLine class represents a line.
import java.awt.Color;
import java.awt.Graphics;

public class MyLine extends MyShape {

  // CONSTRUCTORS
  // constructor without input values
  public MyLine() {
    super();
  } 
  // constructor with input values
  public MyLine(int x1, int y1, int x2, int y2, Color color) {
    super(x1, y1, x2, y2, color);
  }

  // OVERRIDDEN METHODS
  // Draw the line in the specified color
  @Override
  public void draw(Graphics g) {
    g.setColor(this.getColor());

    int[] coordinates = this.getCoordinates();
    g.drawLine(coordinates[0], 
               coordinates[1], 
               coordinates[2], 
               coordinates[3]);
  }

} // end class MyLine

