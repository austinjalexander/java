// File: Node.java
// Student: Austin J. Alexander
// Assignment: Homework 2.1
// Course: MET CS342 (FALL 2014)

public class Node {

  // INSTANCE VARIABLES //
  private int item;
  private Node next;

  // CONSTRUCTORS //
  public Node() {
    this.item = 0;
    this.next = null;
  }
  public Node(int item) {
    this.item = item;
    this.next = null;
  }

  // PUBLIC SETTERS //
  public void setItem(int item) {
    this.item = item;
  }
  public void setNext(Node next) {
    this.next = next;
  }

  // PUBLIC GETTERS //
  public int getItem() {
    return this.item;
  }
  public Node getNext() {
    return this.next;
  }

}
