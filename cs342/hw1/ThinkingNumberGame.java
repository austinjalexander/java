// File: ThinkingNumberGame.java
// Student: Austin J. Alexander
// Assignment: 
// Course: 

/****************************************************************************
* The <CODE>ThinkingNumberGame</CODE> Java terminal/console application to guess a 
* pseudorandomly-generated number between 1 and 1000.
* @author Austin J. Alexander
*   (<a href="mailto:austinja@bu.edu">austinja@bu.edu</a>)
****************************************************************************/
import java.util.Random;
import java.util.Scanner;

class ThinkingNumberGame {

  public static void main(String[] args) {

    int RANDOM_NUMBER = (new Random(System.currentTimeMillis())).nextInt(1000) + 1; 
    int user_guess = 0, number_of_user_guesses = 0;

    while (user_guess != RANDOM_NUMBER) {

      System.out.print("Enter your guess: ");

      Scanner user_input = new Scanner(System.in);

      try {

        Integer.parseInt(user_input.next());

        number_of_user_guesses++;

        if (user_guess > RANDOM_NUMBER) {
          System.out.println("\nToo high!\n ------------------------ \n");
        }
        else if (user_guess < RANDOM_NUMBER) {
          System.out.println("\nToo low!\n ------------------------ \n");
        }
        else {
          System.out.println("\nYou did it!\n\n");
        }

      } catch(NumberFormatException e) {

        System.out.println("\nThis is a number guessing game! " +
                           "Enter numbers only!\n ------------------------ \n");

      }

    }

  }
}



