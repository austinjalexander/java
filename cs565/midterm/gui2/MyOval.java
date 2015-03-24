// File: MyOval.java
// Student: Austin J. Alexander
// Assignment: Midterm Exercise 3 (10.1 [which also relied on 9.1])
// Course: MET CS565 (SPRING 2015)
/*** *** ***
     ATTENTION: PER THE INSTRUCTIONS, THE MAJORITY OF THE CODE IN THIS 
     FILE HAS BEEN COPIED FROM THE TEXTBOOK
 *** *** ***/

// Fig. 8.17: MyOval.java
// MyOval class represents a oval.
import java.awt.Color;
import java.awt.Graphics;

public class MyOval extends MyShape {

  // INSTANCE VARIABLES
  private boolean fill_flag; // determine whether shape is filled

  // CONSTRUCTORS
  // constructor without input values
  public MyOval() {
    super();
    this.setFill(false);
  } 
  // constructor with input values
  public MyOval(int x1, int y1, int x2, int y2, Color color, boolean fill_flag) {
    super(x1, y1, x2, y2, color);
    this.setFill(fill_flag);
  }

  // SETTERS
  public void setFill(boolean fill_flag) {
    this.fill_flag = fill_flag;
  }

  // GETTERS
  public boolean getFill() {
    return this.fill_flag;
  }

  // OVERRIDDEN METHODS
  // Draw the oval in the specified color
  @Override
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
} // end class MyOval

