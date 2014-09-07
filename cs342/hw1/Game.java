// File: Game.java
// Student: Austin J. Alexander
// Assignment: Homework 1.2
// Course: MET CS342 (FALL 2014)

import java.util.Random;
import java.util.Scanner;

public class Game {

  // ATTRIBUTES
  private final int SECRET_NUMBER;
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
  /**
  * Runs a game loop
  * @throws NumberFormatException
  *   Indicates that the user gave non-numeric input.
  **/
  public void play() {

    final String SEPARATOR = "\n\t\t\t ------------------ \n";

    while (user_guess != SECRET_NUMBER) {
      System.out.print("\t\tPlease enter your guess: ");

      try {
        user_guess = Integer.parseInt(user_input.next());
        number_of_user_guesses++;

        if (user_guess > SECRET_NUMBER) {
          System.out.println(SEPARATOR +
                             "\t\t\tYour guess is too high!" +
                             SEPARATOR);
        }
        else if (user_guess < SECRET_NUMBER) {
          System.out.println(SEPARATOR +
                             "\t\t\tYour guess is too low!" +
                             SEPARATOR);
        }
        else {
          System.out.println(SEPARATOR +
                             "\t\t\tYour guess is spot on!" +
                             SEPARATOR);
        }
      } catch(NumberFormatException e) {
          System.out.println(SEPARATOR +
                             "\t\t\tThis is a NUMBER guessing game!\n" +
                             "\t\t\tNumbers only please!" +
                             SEPARATOR);
      }
    }

    if (number_of_user_guesses <= 10) {
      switch (number_of_user_guesses) {
        case 1: 
          System.out.println("\t\tIt only took you " + number_of_user_guesses +
                         " guess. Nice work!");
          break;
        default:
          System.out.println("\t\tIt only took you " + number_of_user_guesses +
                         " guesses. Nice work!");
      }
    }
    else {
      System.out.println("\t\tIt took you " + number_of_user_guesses +
                         " guesses.");
    }
  }
}
