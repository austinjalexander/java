// File: IntegerStore.java
// Student: Austin J. Alexander
// Assignment: Programming Assignment 1
// Course: MET CS566 (SPRING 2015)

import java.util.Scanner;

public class IntegerStore {

  public static void main(String[] args) {

    // welcome user
    System.out.println("\n< < < * * * INTEGER STORE * * * > > >");

    // instantiate new binary search tree
    BinarySearchTree binary_search_tree = new BinarySearchTree();
    // instantiate a new scanner object for user input
    Scanner user_input = new Scanner(System.in);
    // create a variable to hold menu selections
    int menu_option = 0;

    // primary control loop
    while (menu_option != 5) {

      // menu options
      System.out.println("\n\nMAIN MENU\n");
      System.out.println("Insert: 1\nDelete: 2");
      System.out.println("Postorder tree traversal: 3");
      System.out.println("Reset: 4\nExit: 5\n");

      // prompt for user input
      System.out.print("Enter the operation number for the operation " + 
                       "you want to perform and hit Enter: ");
      try {
        menu_option = user_input.nextInt();

        switch (menu_option) {
          case 1: System.out.print("Type a key (a positive integer) to be " +
                                   "to be inserted and hit Enter: ");
                  break;
          case 2: System.out.print("[Press Enter to return to the " +
                                   "Main Menu]\n");
                  break;
          case 3: //
                  System.out.print("Type a key to be deleted " +
                                   "and hit Enter: ");
                  break;
          case 4: //
                  break;
          case 5: System.out.println("\n< < < * * * END * * * > > >");
                  break;
          default: //
                  break;
        }

      }
      catch (Exception e) {
        // alert user to improper input
        System.out.println("\n!!! INVALID MENU OPTION !!!\n");
        user_input.next();
      }
      
    }
  }

}
