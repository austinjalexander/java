// File: TestDraw.java
// Student: Austin J. Alexander
// Assignment: Midterm Problem 2
// Course: MET CS565 (SPRING 2015)
/*** *** ***
     ATTENTION: PER THE INSTRUCTIONS, THE MAJORITY OF THE CODE IN THIS 
     FILE HAS BEEN COPIED FROM THE TEXTBOOK
 *** *** ***/

// Fig. 8.19: TestDraw.java
// Creating a JFrame to display DrawPanel
import javax.swing.JFrame;

public class TestDraw {

  public static void main(String[] args) {
    // create new panel
    DrawPanel panel = new DrawPanel();
    // create new JFrame
    JFrame app = new JFrame();

    // close program on JFrame close
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // add the panel to the JFrame
    app.add(panel);
    // set the size
    app.setSize(500, 500);
    // set the visibility
    app.setVisible(true);
  }

} // end class TestDraw

