// File: MyOval.java
// Student: Austin J. Alexander
// Assignment: Midterm Problem 2
// Course: MET CS565 (SPRING 2015)
/*** *** ***
     ATTENTION: PER THE INSTRUCTIONS, THE MAJORITY OF THE CODE IN THIS 
     FILE HAS BEEN COPIED FROM THE TEXTBOOK
 *** *** ***/

// Fig. 8.17: MyOval.java
// MyOval class represents a oval.
import java.awt.Color;
import java.awt.Graphics;

public class MyOval {

  // INSTANCE VARIABLES
  private int x1; // x-coordinate of first endpoint
  private int y1; // y-coordinate of first endpoint
  private int x2; // x-coordinate of second endpoint
  private int y2; // y-coordinate of second endpoint
  private Color color; // color of this oval
  private boolean fill_flag; // determine whether shape is filled

  // CONSTRUCTORS
  // constructor without input values
  public MyOval() {
    this.setCoordinates(0, 0, 0, 0);
    this.setColor(Color.BLACK);
    this.setFill(false);
  } 
  // constructor with input values
  public MyOval(int x1, int y1, int x2, int y2, Color color, boolean fill_flag) {
    this.setCoordinates(x1, y1, x2, y2);
    this.setColor(color);
    this.setFill(fill_flag);
  }

  // SETTERS
  public void setCoordinates(int x1, int y1, int x2, int y2) {
    // no negative coordinates allowed
    this.x1 = (x1 >= 0) ? x1 : 0;
    this.y1 = (y1 >= 0) ? y1 : 0;
    this.x2 = (x2 >= 0) ? x2 : 0;
    this.y2 = (y2 >= 0) ? y2 : 0;
  }
  public void setColor(Color color) {
    this.color = color;
  }
  public void setFill(boolean fill_flag) {
    this.fill_flag = fill_flag;
  }

  // GETTERS
  public int[] getCoordinates() {
    return new int[] { this.x1, this.y1, this.x2, this.y2 };
  }
  public Color getColor() {
    return this.color;
  }
  public boolean getFill() {
    return this.fill_flag;
  }

  // HELPER METHODS
  // Draw the oval in the specified color
  public void draw(Graphics g) {
    // set color
    g.setColor(this.getColor());
    
    // NOTE: THE TEXTBOOK INSTRUCTIONS SUGGEST THAT THE HELPER METHODS
    // getUpperLeftX(), getUpperLeftY(), getWidth(), and getHeight()
    // SHOULD BE USED TO DRAW RECTANGLES AND OVALS;
    // HOWEVER, THEY ALSO THEN STATE THAT GET METHODS SHOULD BE USED 
    // WITHIN draw() TO ACCESS THE COORDINATES OF SHAPES; 
    // THUS, I SHOW BOTH CASES BELOW:
    if (this.getFill() == true) {
      g.fillOval(this.getUpperLeftX(), 
                 this.getUpperLeftY(), 
                 this.getWidth(), 
                 this.getHeight());
    }
    else {
      int[] coordinates = this.getCoordinates();
      g.drawOval(coordinates[0], 
                 coordinates[1], 
                 coordinates[2], 
                 coordinates[3]);
    }
  }
  public int getUpperLeftX() {
    return (this.x1 < this.x2) ? this.x1 : this.x2;
  }
  public int getUpperLeftY() {
    return (this.y1 < this.y2) ? this.y1 : this.y2;
  }
  public int getWidth() {
    return Math.abs(this.x1 - this.x2);
  }
  public int getHeight() {
    return Math.abs(this.y1 - this.y2);
  }

} // end class MyOval

