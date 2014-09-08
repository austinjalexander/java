// File: ThinkingNumberGame.java
// Student: Austin J. Alexander
// Assignment: Homework 1.2
// Course: MET CS342 (FALL 2014)

public class ThinkingNumberGame {

  public static void main(String[] args) {

    // text decoration
    final String STARS = "*********";

    // welcome message
    System.out.println("\n\n\t" + STARS + 
                       "WELCOME TO THE GAME: I'm Thinking " +
                       " of a Number...! " + STARS + "\n");
    
    // start a new game
    Game new_game = new Game();
    new_game.play();

    // goodbye message
    System.out.println("\n\n\t\t\t" + STARS + " BYE! " + STARS + "\n");
  }
}
