// File: RandomBulls.java
// Student: Austin J. Alexander
// Assignment: HW 3.1
// Course: MET CS565 (SPRING 2015)

import javax.swing.JFrame;

public class RandomBulls {

  public static void main(String[] args) {

    // create new panel; the panel class contains all the drawing logic
    DrawPanel panel = new DrawPanel();

    // create a new frame for panel
    JFrame application = new JFrame();

    // set application to exit when frame is closed
    application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // add panel to pane
    application.add(panel);
    // set panel size and visibuity
    application.setSize(500, 500);
    application.setVisible(true);

  }

}