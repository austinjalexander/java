// File: Game.java
// Student: Austin J. Alexander
// Assignment: Homework 1.2
// Course: MET CS342 (FALL 2014)

import java.util.Random;
import java.util.Scanner;

public class Game {

  // ATTRIBUTES
  private final int SECRET_NUMBER; // randomly generated numbers
  private int user_guess, number_of_user_guesses;
  private Scanner user_input;

  // CONSTRUCTORS
  public Game() {
    SECRET_NUMBER = (new Random(System.currentTimeMillis())).nextInt(1000) + 1; 
    user_input = new Scanner(System.in);
    user_guess = 0;
    number_of_user_guesses = 0;
  }

  // SETTERS

  // GETTERS

  // HELPING METHODS
  // display each guess position (i.e., 'too high', 'too low', 'spot on')
  private void displayGuessPosition(String rank) {
    System.out.println("\n\t\t\t ------------------ \n" +
                       "\t\t\tYour guess is " + rank + "!" +
                       "\n\t\t\t ------------------ \n");
  }
  // runs the game loop and displays final guess tally
  public void play() {

    // the game loop
    while (user_guess != SECRET_NUMBER) {
      System.out.print("\t\tPlease enter your guess: ");

      // catch user input if it's not integer-compatible
      try {
        user_guess = Integer.parseInt(user_input.next());
        number_of_user_guesses++;

        if (user_guess > SECRET_NUMBER) {
          displayGuessPosition("too high");
        }
        else if (user_guess < SECRET_NUMBER) {
          displayGuessPosition("too low");
        }
        else {
          displayGuessPosition("spot on");
        }
      } catch(NumberFormatException e) {
          System.out.println("\n\t\t\t ------------------ \n" +
                             "\t\tThis is a NUMBER guessing game!\n" +
                             "\t\t\tNumbers only please!" +
                             "\n\t\t\t ------------------ \n");
      }
    }

    // display total number of guesses
    if (number_of_user_guesses <= 10) {
      System.out.print("\t\tIt only took you " + number_of_user_guesses);
      switch (number_of_user_guesses) {
        case 1: 
          System.out.print(" guess.");
          break;
        default:
          System.out.println(" guesses.");
          break;
      }
      System.out.println(" Nice work!");
    }
    else {
      System.out.println("\t\tIt took you " + number_of_user_guesses +
                         " guesses.");
    }
  }
}
