// File: Node.java
// Student: Austin J. Alexander
// Assignment: Programming Assignment 1
// Course: MET CS566 (SPRING 2015)

// PLEASE NOTE: in order to follow,
    // as precisely as possible in Java,
    // the TREE-INSERT algorithm/pseudocode in _______,
    // the common software practice of making instance variables private
// and implementing 'setter' and 'getter' methods was not done

public class Node {

  // INSTANCE VARIABLES
  public Node p;
  public Node left;
  public Node right;
  public int key;

  // CONSTRUCTORS
  public Node() {
    this.p = null;
    this.left = null;
    this.right = null;
    this.key = 0;
  }
  public Node(int key) {
    this.p = null;
    this.left = null;
    this.right = null;
    this.key = key;
  }


}
