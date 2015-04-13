// File: Node.java
// Student: Austin J. Alexander
// Assignment: Programming Assignment 1
// Course: MET CS566 (SPRING 2015)

// REGARDING THE IMPLEMENTATION DETAILS BELOW 
// (E.G., THE USE OF PUBLIC INSTANCE VARIABLES), 
// PLEASE SEE THE NOTE (d) IN THE DOCUMENTATION FILE

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

