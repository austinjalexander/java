// File: MyLine.java
// Student: Austin J. Alexander
// Assignment: Midterm Problem 2
// Course: MET CS565 (SPRING 2015)
/*** *** ***
     ATTENTION: PER THE INSTRUCTIONS, THE MAJORITY OF THE CODE IN THIS 
     FILE HAS BEEN COPIED FROM THE TEXTBOOK
 *** *** ***/

// Fig. 8.17: MyLine.java
// MyLine class represents a line.
import java.awt.Color;
import java.awt.Graphics;

public class MyLine {

  // INSTANCE VARIABLES
  private int x1; // x-coordinate of first endpoint
  private int y1; // y-coordinate of first endpoint
  private int x2; // x-coordinate of second endpoint
  private int y2; // y-coordinate of second endpoint
  private Color color; // color of this line

  // CONSTRUCTORS
  // constructor without input values
  public MyLine() {
    this.setCoordinates(0, 0, 0, 0);
    this.setColor(Color.BLACK);
  } 
  // constructor with input values
  public MyLine(int x1, int y1, int x2, int y2, Color color) {
    this.setCoordinates(x1, y1, x2, y2);
    this.setColor(color);
  }

  // SETTERS
  public void setCoordinates(int x1, int y1, int x2, int y2) {
    this.x1 = (x1 >= 0) ? x1 : 0;
    this.y1 = (y1 >= 0) ? y1 : 0;
    this.x2 = (x2 >= 0) ? x2 : 0;
    this.y2 = (y2 >= 0) ? y2 : 0;
  }
  public void setColor(Color color) {
    this.color = color;
  }

  // GETTERS
  public int[] getCoordinates() {
    return new int[] { this.x1, this.y1, this.x2, this.y2 };
  }
  public Color getColor() {
    return this.color;
  }

  // HELPER METHODS
  // Draw the line in the specified color
  public void draw(Graphics g) {
    g.setColor(this.getColor());

    int[] coordinates = this.getCoordinates();
    g.drawLine(coordinates[0], 
               coordinates[1], 
               coordinates[2], 
               coordinates[3]);
  }
} // end class MyLine

