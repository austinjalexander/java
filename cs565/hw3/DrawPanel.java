// File: DrawPanel.java
// Student: Austin J. Alexander
// Assignment: HW 2.1
// Course: MET CS565 (SPRING 2015)

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import java.security.SecureRandom;

public class DrawPanel extends JPanel {

  public void paintComponent(Graphics g) {
    super.paintComponent(g);

    int width = getWidth();
    int height = getHeight();

    // smallest circle have a radius of 25
    int radius = 5*25; // 125

    // draw grid lines to ensure circles are centered
    //g.drawLine((width/2), (height/2), width, (height/2));
    //g.drawLine((width/2), (height/2), (width*-1), (height/2));
    //g.drawLine((width/2), (height/2), (width/2), height);
    //g.drawLine((width/2), (height/2), (width/2), (height*-1));

    // generate 2 random colors for alternating circles
    SecureRandom random_number_generator = new SecureRandom();
    Color random_color_1 = new Color(random_number_generator.nextInt(256),
                                   random_number_generator.nextInt(256),
                                   random_number_generator.nextInt(256));
    Color random_color_2 = new Color(random_number_generator.nextInt(256),
                                   random_number_generator.nextInt(256),
                                   random_number_generator.nextInt(256));

    // create 5 concentric circles
    for (int i = 5; i > 0; i--) {
      // if number of circle is even, use random_color_1
      if (i % 2 == 0) {
        g.setColor(random_color_1);
      }
      // if number of circle is odd, use random_color_2
      else {
        g.setColor(random_color_2);
      }
      // fill current circle
      g.fillOval(((width/2) - radius), ((height/2) - radius), (radius*2), (radius*2));

      // decrease radius value by 25
      radius -= 25;
    }
  }

}