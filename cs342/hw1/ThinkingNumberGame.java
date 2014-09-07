// File: ThinkingNumberGame.java
// Student: Austin J. Alexander
// Assignment: Homework 1.2
// Course: MET CS342 (FALL 2014)

/**************************************************************************
* The <code>ThinkingNumberGame</code> Java terminal/console application to
* guess a pseudorandomly-generated number between 1 and 1000.
*
* @author <a href="mailto:austinja@bu.edu">austinja@bu.edu</a> 
*   (Austin J. Alexander)
* @version 1.0 - Sept 5 2014
****************************************************************************/

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
