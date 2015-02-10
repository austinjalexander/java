// File: Reserve.java
// Student: Austin J. Alexander
// Assignment: HW 2.2
// Course: MET CS565 (SPRING 2015)

import java.util.Scanner;

public class Reserve {

  public static void main(String[] args) {

    // display program info
    System.out.println("\n\t\t      Java Airlines\n");
    System.out.println("\t\t<------- RESERVE ------->\n");

    /*** LOCAL VARIABLES ***/
    // if all seats are filled (i.e., set to true), 
    // then the plane is full; 
    // they are originally set to false
    boolean[] seats = new boolean[10];
    for (boolean seat : seats) {
      seat = false;
    }
    // seat_class is originally set to 0;
    // user should enter 1 (First Class) or 2 (Economy)
    int seat_class = 0;

    /*** PROGRAM LOOP ***/
    // while the plane is not full,
    // and the exit command is not set to true,
    // and the user enters a number other than 1 or 2
    // continue to request information from the user
    while ( ( (plane_full == false) && (exit_command == false) ) || ( (seat_class <= 0) || (seat_class > 2) ) ) {

      // ask for seat class
      System.out.print("Please type 1 for First Class " + 
                       "or 2 for Economy ('Q' to quit): ");
      // get seat class
      seat_class = getSeatClass(seat_class);
      // otherwise, if user entered 1 or 2
      if ( (seat_class >= 1) && (seat_class <= 2) ) {
        // assign seat
        int seat_assignment = assignSeat(seat_class,seats);
        // if seat assignment is within range (1-10)
        if ( (seat_assignment >= 1) && (seat_assignment <= 10) ) {
          // display boarding pass
          displayBoardingPass(seat_assignment);
        }
        // if First Class was selected but is full
        else if ( (seat_class == 1) && (seat_assignment == 0) ) {
          System.out.print("\t--> First Class is full. Reserve a seat in Economy?");
          // attempt to switch class
          switchClass(2, seats);
        }
        // otherwise, if Economy was selected but is full
        else if ( (seat_class == 2) && (seat_assignment == 0) ) {
          System.out.print("\t--> Economy is full. Reserve a seat in First Class?");
          // attempt to switch class
          switchClass(1, seats);
        }
      // otherwise, loop will ask for new input
      }

      // check if plane is full
      plane_full = checkIfPlaneFull(seats);
      // if plane if full, while loop will terminate
      if (plane_full == true) {
        // display message
        System.out.println(PLANE_IS_FULL);
      }
    } // end: while ( ( (plane_full == false) && (exit_command...

    // termination message
    System.out.println("\n\t\t<------- END ------->\n");
  }

  /*** STATIC CONSTANTS ***/
  private static final String PLANE_IS_FULL = "\n\t<!> Plane is full! Next flight leaves in 3 hours. <!>\n";
  private static final String NEXT_FLIGHT = "\n\t<<< Next flight leaves in 3 hours. >>>\n";
  // if exit_command is set to true by the user,
  // the program will terminate;
  // it is originally set to false
  private static boolean exit_command = false;
  // if plane_full is set to true,
  // the program will terminate;
  // it is originally set to false
  private static boolean plane_full = false;


  /*** STATIC HELPER FUNCTIONS ***/
  // helper function to get seat class from user;
  // return seat class (1 or 2), exit signal, 
  // or indication to loop again
  private static int getSeatClass(int seat_class) {
    // new scanner object
    Scanner user_input = new Scanner(System.in);

    // attempt to get user input
    String input = user_input.nextLine();

    // if user wants to quit, signal exit command
    if ( (input.charAt(0) == 'Q') || (input.charAt(0) == 'q') ) {
      exit_command = true;
    }
    // if user enters anything else, 
    // try to interpret as an integer
    else {
      try {
        seat_class = Integer.parseInt(input);
      }
      // if not an int
      catch (NumberFormatException e) {
        // return 0 so user will be prompted for new input
        seat_class = 0;
      }
    }
    return seat_class;
  }

  // helper function to assign seat based on entered class;
  // return the seat number
  private static int assignSeat(int seat_class, boolean[] seats) {
    
    // set seat_assignment to 0
    int seat_assignment = 0;

    // if First Class was selected
    if (seat_class == 1) {
      // look for an open seat
      for (int i = 0; i < 5; i++) {
        // if a seat is open
        if (seats[i] == false) {
          // get seat number
          seat_assignment = i + 1; 
          // assign seat
          seats[i] = true; 
          // exit loop
          i = 5;
        }
      }
    }
    // otherwise, if Economy was selected
    else if (seat_class == 2) {
      // look for an open seat
      for (int i = 5; i < 10; i++) {
        // if a seat is open
        if (seats[i] == false) {
          // get seat number
          seat_assignment = i + 1; 
          // assign seat
          seats[i] = true; 
          // exit loop
          i = 10;
        }
      }
    }
    return seat_assignment;
  }

  // helper function to switch originally selected class
  // when one of the classes is full
  private static void switchClass(int seat_class, boolean[] seats) {

    // flag to indicate if user wants to switch class
    boolean switch_class = false;

    // new scanner object
    Scanner user_input = new Scanner(System.in);

    // string for user input
    String input = " ";

    // while user doesn't enter Y and N, loop
    while ((input.charAt(0) != 'Y') && (input.charAt(0) != 'y') && (input.charAt(0) != 'N') && (input.charAt(0) != 'n')) {

      // let user know appropriate options
      System.out.print(" Y or N: ");

      // attempt to get user input
      input = user_input.nextLine();

      // if user wants to switch class
      if ( (input.charAt(0) == 'Y') || (input.charAt(0) == 'y') ) {
        // return true
        switch_class = true;
      }
      // if user wants to switch class
      else if ( (input.charAt(0) == 'N') || (input.charAt(0) == 'n') ) {
        // return false
        switch_class = false;
      }
    }

    // if user wants to switch
    if (switch_class == true) {
      // assign seat using new seat class
      int seat_assignment = assignSeat(seat_class,seats);
      // if a seat is found
      if (seat_assignment != 0) {
        // display boarding pass
        displayBoardingPass(seat_assignment);
      }
      // otherwise, plane is full
      else {
        // set plane_full flag to true
        plane_full = true;
        // display message
        System.out.println(PLANE_IS_FULL);
      }
    }
    // otherwise, display message
    else {
      System.out.println(NEXT_FLIGHT);
    }
  }

  // helper function to check if plane is full;
  // takes seats as a parameter,
  // and returns true if plane is full
  private static boolean checkIfPlaneFull(boolean[] seats) {
    // set empty_seats to 0
    int empty_seats = 0;
    // loop through seats
    for (boolean seat : seats) {
      // if any empty seats are found
      if (seat == false) {
        // increment empty_seats
        empty_seats++;
      }
    }
    // return the boolean value:
    // if empty seats == 0, true, which will cause program to terminate,
    // since plane is full;
    // otherwise, plane still has empty seats, so while loop will continue
    return (empty_seats == 0); 
  }

  // helper function to display boarding pass
  private static void displayBoardingPass(int seat_assignment) {
    // since values are checked prior to this point, 
    // only need to check whether seat_assignment is <= 5
    String seat_class = (seat_assignment <= 5) ? "FIRST" : "ECONOMY";

    // display seat assignment
    System.out.println("\n\t[[ BOARDING PASS ]]\n" +
                       "\t  CLASS: " + seat_class + "\n" +
                       "\t  SEAT: " + seat_assignment + "\n");
  }

}