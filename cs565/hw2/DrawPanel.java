// File: DrawPanel.java
// Student: Austin J. Alexander
// Assignment: HW 2.1
// Course: MET CS565 (SPRING 2015)

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawPanel extends JPanel {

  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    int width = getWidth();
    int height = getHeight();

    int base_r = 120;

    // draw grid lines
    //g.drawLine((width/2), (height/2), width, (height/2));
    //g.drawLine((width/2), (height/2), (width*-1), (height/2));
    //g.drawLine((width/2), (height/2), (width/2), height);
    //g.drawLine((width/2), (height/2), (width/2), (height*-1));

    for (int i = 12; i > 0; i--) {
      if (i % 6 == 0) {
        g.setColor(Color.RED);
      }
      else if (i % 6 == 5) {
        g.setColor(Color.ORANGE);
      }
      else if (i % 6 == 4) {
        g.setColor(Color.YELLOW);
      }
      else if (i % 6 == 3) {
        g.setColor(Color.GREEN);
      }
      else if (i % 6 == 2) {
        g.setColor(Color.BLUE);
      }
      else if (i % 6 == 1) {
        g.setColor(Color.MAGENTA);
      }
      g.fillOval(((width/2) - base_r), ((height/2) - base_r), (base_r*2), (base_r*2));
      base_r -= 10;
    }
  }

}