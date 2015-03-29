// File: IntegerStoreTest.java
// Student: Austin J. Alexander
// Assignment: Programming Assignment 1
// Course: MET CS566 (SPRING 2015)


public class IntegerStoreTest {

  public static void main(String[] args) {

    BinarySearchTree binary_search_tree = new BinarySearchTree();

    inorderTreeWalk(binary_search_tree.root);
    System.out.println();
    treeInsert(binary_search_tree, new Node(6));
    treeInsert(binary_search_tree, new Node(5));
    treeInsert(binary_search_tree, new Node(7));
    treeInsert(binary_search_tree, new Node(2));
    treeInsert(binary_search_tree, new Node(5));
    //treeInsert(binary_search_tree, new Node(4));
    treeInsert(binary_search_tree, new Node(8));
    inorderTreeWalk(binary_search_tree.root);
    //treeDelete(binary_search_tree, treeSearch(binary_search_tree.root, 4));
    System.out.println();
    inorderTreeWalk(binary_search_tree.root);
    System.out.println();

    /*
    binary_search_tree.reset();

    inorderTreeWalk(binary_search_tree.root);
    System.out.println();
    treeInsertRecursive(binary_search_tree, binary_search_tree.root, new Node(6));
    treeInsertRecursive(binary_search_tree, binary_search_tree.root, new Node(5));
    treeInsertRecursive(binary_search_tree, binary_search_tree.root, new Node(7));
    treeInsertRecursive(binary_search_tree, binary_search_tree.root, new Node(2));
    treeInsertRecursive(binary_search_tree, binary_search_tree.root, new Node(5));
    treeInsertRecursive(binary_search_tree, binary_search_tree.root, new Node(8));
    inorderTreeWalk(binary_search_tree.root);
    //treeDelete(binary_search_tree, treeSearch(binary_search_tree.root, 7));
    System.out.println();
    inorderTreeWalk(binary_search_tree.root);
    System.out.println();
    */

    System.out.println();
    postorderTreeWalk(binary_search_tree.root);
    System.out.println();
    postorderTreeWalk(binary_search_tree.root);
    System.out.println();
  }

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
    // set parent of z to x
    z.p = x;
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
