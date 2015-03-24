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
  private MyShape[] shapes;
  private int num_lines;
  private int num_rects;
  private int num_ovals;

  // CONSTUCTOR
  // constructor, creates a panel with random shapes
  public DrawPanel() {
    setBackground(Color.WHITE);

    // for each shape class, generate a random number
    this.num_lines = 1 + random_numbers.nextInt(5);
    this.num_rects = 1 + random_numbers.nextInt(5);
    this.num_ovals = 1 + random_numbers.nextInt(5);

    // create new shapes array
    this.shapes = new MyShape[this.num_lines + this.num_rects + this.num_ovals];

    // create shapes
    createShapes();
  }

  // HELPER METHODS
  // create shapes
  public void createShapes() {
    // loop through the shapes array
    for (int count = 0; count < this.shapes.length; count++) {

      // generate random coordinates
      int x1 = random_numbers.nextInt(BOUNDARY);
      int y1 = random_numbers.nextInt(BOUNDARY);
      int x2 = random_numbers.nextInt(BOUNDARY);
      int y2 = random_numbers.nextInt(BOUNDARY);

      // generate a random color
      Color color = new Color(random_numbers.nextInt(COLOR_MAX), 
                              random_numbers.nextInt(COLOR_MAX),
                              random_numbers.nextInt(COLOR_MAX));

      // add shapes to the list of shapes to be displayed
      // lines
      if (count < this.num_lines) {
        this.shapes[count] = new MyLine(x1, y1, x2, y2, color);
      }
      // rectangles
      else if (count < (this.num_lines+this.num_rects)) {
        // odd-indexed shapes are filled
        boolean fill_flag = (count % 2 == 0) ? false : true;
        this.shapes[count] = new MyRectangle(x1, y1, x2, y2, color, fill_flag);
      }
      // ovals
      else if (count < (this.num_lines+this.num_rects+this.num_ovals)) {
        // odd-indexed shapes are filled
        boolean fill_flag = (count % 2 == 0) ? false : true;
        this.shapes[count] = new MyOval(x1, y1, x2, y2, color, fill_flag);
      }
    }
  } 
  // for each shape array, draw the individual shapes
  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    // draw the shapes
    for (MyShape shape : this.shapes) {
      shape.draw(g);
    }
  }
  public String makeStatusLabel() {
    return "Lines: " + this.num_lines + ", " +
           "Ovals: " + this.num_ovals + ", " + 
           "Rectangles: " + this.num_rects;
  }
} // end class DrawPanel



