// File: TestDraw.java
// Student: Austin J. Alexander
// Assignment: Midterm Problem 3 (10.1 [which also relied on 9.1])
// Course: MET CS565 (SPRING 2015)
/*** *** ***
     ATTENTION: PER THE INSTRUCTIONS, THE MAJORITY OF THE CODE IN THIS 
     FILE HAS BEEN COPIED FROM THE TEXTBOOK
 *** *** ***/

// Fig. 8.19: TestDraw.java
import java.awt.BorderLayout;
import javax.swing.JLabel;
// Creating a JFrame to display DrawPanel
import javax.swing.JFrame;

public class TestDraw {

  public static void main(String[] args) {
    // create new panel
    DrawPanel panel = new DrawPanel();
    // create new JLabel
    JLabel status_label = new JLabel(panel.makeStatusLabel());
    // create new JFrame
    JFrame app = new JFrame();

    // close program on JFrame close
    app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // add the panel to the JFrame
    app.add(panel);
    // add the status label
    app.add(status_label, BorderLayout.SOUTH);
    // set the size
    app.setSize(500, 500);
    // set the visibility
    app.setVisible(true);
  }

} // end class TestDraw

