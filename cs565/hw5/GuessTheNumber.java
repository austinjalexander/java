// File: GuessTheNumber.java
// Student: Austin J. Alexander
// Assignment: Homework Assignment 5
// Course: MET CS565 (SPRING 2015)


import javax.swing.JFrame;
import java.security.SecureRandom;

public class GuessTheNumber {

  public static void main(String[] args) {

    // create new GameUI
    GameUI game_ui = new GameUI();
    // close the program on GameUI close
    game_ui.setDefaultCloseOperation(GameUI.EXIT_ON_CLOSE);

    // set the JFrame size
    game_ui.setSize(500, 500);
    // set the JFrame visibility
    game_ui.setVisible(true);



  } //end: public static void main(String[] args)

} //end: public class GuessTheNumber


