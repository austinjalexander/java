// File: MyShape.java, abstract superclass
// Student: Austin J. Alexander
// Assignment: Midterm Problem 3 (10.1 [which also relied on 9.1])
// Course: MET CS565 (SPRING 2015)
/*** *** ***
     ATTENTION: PER THE INSTRUCTIONS, THE MAJORITY OF THE CODE IN THIS 
     FILE HAS BEEN COPIED FROM THE TEXTBOOK
 *** *** ***/

import java.awt.Color;
import java.awt.Graphics;

public abstract class MyShape {

  // INSTANCE VARIABLES
  private int x1; // x-coordinate of first endpoint
  private int y1; // y-coordinate of first endpoint
  private int x2; // x-coordinate of second endpoint
  private int y2; // y-coordinate of second endpoint
  private Color color; // color of this rectangle

  // CONSTRUCTORS
  // constructor without input values
  public MyShape() {
    this.setCoordinates(0, 0, 0, 0);
    this.setColor(Color.BLACK);
  } 
  // constructor with input values
  public MyShape(int x1, int y1, int x2, int y2, Color color) {
    this.setCoordinates(x1, y1, x2, y2);
    this.setColor(color);
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

  // GETTERS
  public int[] getCoordinates() {
    return new int[] { this.x1, this.y1, this.x2, this.y2 };
  }
  public Color getColor() {
    return this.color;
  }

  // ABSTRACT METHOD
  // abstract method must be overridden by concrete subclasses
  public abstract void draw(Graphics g);

  // HELPER METHODS
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

} // end class MyShape

