// File: DrawPanel.java
// Student: Austin J. Alexander
// Assignment: Midterm Exercise 3 (10.1 [which also relied on 9.1])
// Course: MET CS565 (SPRING 2015)
/*** *** ***
     ATTENTION: PER THE INSTRUCTIONS, THE MAJORITY OF THE CODE IN THIS 
     FILE HAS BEEN COPIED FROM THE TEXTBOOK
 *** *** ***/

// Fig. 8.18: DrawPanel.java
// Program that uses classes MyLine, MyRectangle, and MyOval
// to draw random shapes
import java.awt.Color;
import java.awt.Graphics;
import java.security.SecureRandom;
import javax.swing.JPanel;

public class DrawPanel extends JPanel {

  // INSTANCE VARIABLES
  private final int BOUNDARY = 400;
  private final int COLOR_MAX = 256;
  private SecureRandom random_numbers = new SecureRandom();
  private MyShape[] lines; // array of lines
  private MyShape[] rectangles; // array of rectangles
  private MyShape[] ovals; // array of ovals

  // CONSTUCTOR
  // constructor, creates a panel with random shapes
  public DrawPanel() {
    setBackground(Color.WHITE);

    // for each shape class, create an array with random length
    this.lines = new MyLine[1 + random_numbers.nextInt(5)];
    this.rectangles = new MyRectangle[1 + random_numbers.nextInt(5)];
    this.ovals = new MyOval[1 + random_numbers.nextInt(5)];

    // create lines
    createShapes(this.lines);

    // create rectangles
    createShapes(this.rectangles);

    // create ovals
    createShapes(this.ovals);

  }

  // HELPER METHODS
  // create shapes
  public void createShapes(Object[] shapes) {
    // loop through the shapes array
    for (int count = 0; count < shapes.length; count++) {

      // generate random coordinates
      int x1 = random_numbers.nextInt(BOUNDARY);
      int y1 = random_numbers.nextInt(BOUNDARY);
      int x2 = random_numbers.nextInt(BOUNDARY);
      int y2 = random_numbers.nextInt(BOUNDARY);

      // generate a random color
      Color color = new Color(random_numbers.nextInt(COLOR_MAX), 
                              random_numbers.nextInt(COLOR_MAX),
                              random_numbers.nextInt(COLOR_MAX));

      // add a shape to the list of shapes to be displayed
      // if line class
      if (shapes instanceof MyLine[]) {
        shapes[count] = new MyLine(x1, y1, x2, y2, color);
      }
      // if rectangle class
      else if (shapes instanceof MyRectangle[]) {
        // odd-indexed shapes are filled
        boolean fill_flag = (count % 2 == 0) ? false : true;
        shapes[count] = new MyRectangle(x1, y1, x2, y2, color, fill_flag);
      }
      // if oval class
      else if (shapes instanceof MyOval[]) {
        // odd-indexed shapes are filled
        boolean fill_flag = (count % 2 == 0) ? false : true;
        shapes[count] = new MyOval(x1, y1, x2, y2, color, fill_flag);
      }
    }
  } 
  // for each shape array, draw the individual shapes
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    // draw the lines
    for (MyShape line : this.lines) {
      line.draw(g);
    }

    // draw the rectangles
    for (MyShape rectangle : this.rectangles) {
      rectangle.draw(g);
    }

    // draw the oval
    for (MyShape oval : this.ovals) {
      oval.draw(g);
    }
  }
  public String makeStatusLabel() {
    String status_label = "";

    // for line class
      status_label += "Lines: " + this.lines.length + ", ";
    // for rectangle class
      status_label += "Ovals: " + this.ovals.length + ", ";
    // for oval class
      status_label += "Rectangles: " + this.rectangles.length;

    return status_label;
  }
} // end class DrawPanel



