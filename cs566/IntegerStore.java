// File: IntegerStore.java
// Student: Austin J. Alexander
// Assignment: Programming Assignment 1
// Course: MET CS566 (SPRING 2015)

import java.util.Scanner;
import java.util.InputMismatchException;

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

        // switch-case for menu-option selection
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
          case 2: System.out.print("\nType a key to be deleted " +
                                   "and hit Enter: ");
                  // get key from user and search tree for key;
                  // will raise exception if input is not an integer;
                  // will raise exception if key is not in tree
                  treeDelete(binary_search_tree, 
                             treeSearch(binary_search_tree.root, 
                                        user_input.nextInt()));
                  break;

          // traverse
          case 3: System.out.print("\n\tKEYS: ");
                  postorderTreeWalk(binary_search_tree.root);

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

          // otherwise, if still integer input, 
          // invalid menu option
          default:
                  System.out.println("\n\t!!! INVALID MENU OPTION !!!");
                  break;

        } // end: switch (menu_option)
      } // end: try

      // if menu option or key input is invalid 
      catch (InputMismatchException e) {
        // alert user to improper input
        System.out.println("\n\t!!! INVALID INPUT !!!");
        user_input.next();
      } // end: catch (InputMismatchException e)

      // if key isn't in tree, catch the exception thrown
      // due to the textbook's delete algorithm's assumption that 
      // the tree is not empty (and, thus, that z is not null) 
      catch (NullPointerException e) {
        // alert user to improper input
        System.out.println("\n\t!!! KEY NOT IN TREE !!!");
      } // end: catch (NullPointerException e)

      // loop display separator
      System.out.println("\n-------");

    } // end: while (menu_option != 5)
  } // end: public static void main(String[] args)

  // HELPER METHODS
  public static void print(int key) {
    System.out.print("[" + key + "] ");
  } // end: public static void print(int key)

  // TEXTBOOK ALGORITHMS
  // As instructed, the following algorithms follow, 
  // as precisely as possible in Java,
  // the algorithms presented as pseudocode in 
  // Corment, Leiserson, Rivest, and Stein's Introduction to Algorithms.
  // From a software design perspective, the code is efficient to be sure
  // but, in my opinion, at the expense of human readability.
  // Moreover, common software design principles are ignored; 
  // for example, instance variables (e.g., root, key, etc.) are 
  // accessed directly (and, thus, are public) as opposed to being 
  // accessed through 'setter'/'getter' methods.

  public static void treeInsert(BinarySearchTree T, Node z) {
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
  } // end: public static void treeInsert(BinarySearchTree T, Node z)

  // my version, using the textbook's conventions, of recursive insert
  public static void treeInsertRecursive(BinarySearchTree T, Node x, Node z) {
    // if T is empty
    if (x == null)
      T.root = z;
    // otherwise, if key is less than current key
    else if (z.key < x.key) {
      if (x.left == null)
        x.left = z;
      else
        treeInsertRecursive(T, x.left, z);
    }
    // otherwise, if key is greater than or equal to the current key
    else if (z.key >= x.key) {
      if (x.right == null)
        x.right = z;
      else
        treeInsertRecursive(T, x.right, z);
    }
  } // end: public static void treeInsertRecursive(BinarySearchTree T, Node x, Node z)

  public static void inorderTreeWalk(Node x) {
    if (x != null) {
      inorderTreeWalk(x.left);
      print(x.key);
      inorderTreeWalk(x.right);
    }
  } // end: public static void inorderTreeWalk(Node x)

  // my version, using the textbook's conventions, of postorder traversal
  public static void postorderTreeWalk(Node x) {
    if (x != null) {
      postorderTreeWalk(x.left);
      postorderTreeWalk(x.right);
      print(x.key);
    }
  } // end: public static void inorderTreeWalk(Node x)

  public static Node treeSearch(Node x, int k) {
    if ( (x == null) || (k == x.key) )
      return x;
    if (k < x.key)
      return treeSearch(x.left, k);
    else return treeSearch(x.right, k);
  }

  public static Node treeMinimum(Node x) {
    while (x.left != null)
      x = x.left;
    return x;
  } // end: public static Node treeMinimum(Node x)

  public static void transplant(BinarySearchTree T, Node u, Node v) {
    if (u.p == null)
      T.root = v;
    else if (u == u.p.left) 
      u.p.left = v;
    else
      u.p.right = v;
    if (v != null)
      v.p = u.p;
  } // end: public static void transplant(BinarySearchTree T, Node u, Node v)

  public static void treeDelete(BinarySearchTree T, Node z) {
    if (z.left == null)
      transplant(T, z, z.right);
    else if (z.right == null)
      transplant(T, z, z.left);
    else {
      Node y = treeMinimum(z.right);
      if (y.p != z) {
        transplant(T, y, y.right);
        y.right = z.right;
        y.right.p = y;
      }
      transplant(T, z, y);
      y.left = z.left;
      y.left.p = y;
    }
  } // end: public static void treeDelete(BinarySearchTree T, Node z)

}
