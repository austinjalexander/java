// File: Circles.java
// Student: Austin J. Alexander
// Assignment: HW 2.1
// Course: MET CS565 (SPRING 2015)

import javax.swing.JFrame;

public class Circles {

  public static void main(String[] args) {

    DrawPanel panel = new DrawPanel();

    JFrame application = new JFrame();

    application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    application.add(panel);
    application.setSize(500, 500);
    application.setVisible(true);

  }

}