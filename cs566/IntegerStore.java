// File: IntegerStore.java
// Student: Austin J. Alexander
// Assignment: Programming Assignment 1
// Course: MET CS566 (SPRING 2015)

// PLEASE NOTE: in order to follow,
    // as precisely as possible in Java,
    // the TREE-INSERT algorithm/pseudocode in _______,
    // the common software practice of making instance variables private
// and implementing 'setter' and 'getter' methods was not done

import java.util.Scanner;

public class IntegerStore {

  public static void main(String[] args) {

    // welcome user
    System.out.println("\n\t< < < * * * INTEGER STORE * * * > > >");

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
      System.out.print("Enter the operation number for the operation\n" + 
                       "you want to perform and hit Enter: ");
      
      // try to get integer from user; 
      // raise exception if input is not an integer
      try {
        // get menu option from user;
        // will raise exception if input is not an integer
        menu_option = user_input.nextInt();

        switch (menu_option) {

          // insert
          case 1: System.out.print("\nType a key (a positive integer) to be\n" +
                                   "to be inserted and hit Enter: ");
                  // get key from user;
                  // will raise exception if input is not an integer
                  treeInsert(binary_search_tree, 
                             new Node(user_input.nextInt()));
                  break;

          // delete
          case 2: //
                  System.out.print("Type a key to be deleted " +
                                   "and hit Enter: ");
                  break;

          // traverse
          case 3: System.out.print("\n\tKEYS: ");
                  inorderTreeWalk(binary_search_tree.root);

                  System.out.print("\n\t[Press Enter to return to the " +
                                   "Main Menu]");
                  user_input.nextLine(); // clear last new line character
                  user_input.nextLine(); // wait for keyboard input
                  break;

          // reset by setting root node to null,
          // letting Java's garbage collector do the work
          case 4: binary_search_tree.reset();
                  break;

          // exit while loop
          case 5: System.out.println("\n\t< < < * * * END * * * > > >");
                  break;

          default: //
                  break;

        } // end: switch (menu_option)
      } // end: try

      catch (Exception e) {
        // alert user to improper input
        System.out.println("\n\t!!! INVALID MENU OPTION !!!");
        user_input.next();
      } // end: catch (Exception e)

      // loop display separator
      System.out.println("\n-------");

    } // end: while (menu_option != 5)
  } // end: public static void main(String[] args)

  // TEXTBOOK ALGORITHMS
  public static void treeInsert(BinarySearchTree T, Node z) {
    // as instructed, the following algorithm follows, 
    // as precisely as possible in Java,
    // the TREE-INSERT algorithm/pseudocode in _______;
    // from a software design perspective, the code is efficient to be sure
    // but at the expense of human readability;
    // personally, i would not write code like this.
    Node y = null;
    Node x = T.root;
    while (x != null) {
      y = x;
      if (z.key < x.key)
        x = x.left;
      else x = x.right;
    }
    z.p = y;
    if (y == null)
      T.root = z; // tree T was empty
    else if (z.key < y.key)
      y.left = z;
    else y.right = z;
  }

  public static void inorderTreeWalk(Node x) {
    if (x != null) {
      inorderTreeWalk(x.left);
      print(x.key);
      inorderTreeWalk(x.right);
    }
  }

  // HELPER METHODS
  public static void print(int key) {
    System.out.print("[" + key + "] ");
  }

}
