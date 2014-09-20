// File: DoublyLinkedNode.java
// Student: Austin J. Alexander
// Assignment: Homework 2.2
// Course: MET CS342 (FALL 2014)

public class DoublyLinkedNode {

  // INSTANCE VARIABLES //
  private Node prev;
  private String[] tags;
  private Node next;

  // CONSTRUCTORS //
  public DoublyLinkedNode() {
    this.prev = null;
    this.tags = { "" }
    this.next = null;
  }
  public DoublyLinkedNode(String[] tags) {
    this.prev = null;
    for (int i = 0; i < tags.length; i++) {
      this.tags[i] = tags[i];
    }
    this.next = null;
  }

  // PUBLIC SETTERS //
  public void setPrev(Node prev) {
    this.prev = prev;
  }
  public void setItem(String[] tags) {
    for (int i = 0; i < tags.length; i++) {
      this.tags[i] = tags[i];
    }
  }
  public void setNext(Node next) {
    this.next = next;
  }

  // PUBLIC GETTERS //
  public Node getPrev() {
    return this.prev;
  }
  public String[] getItem() {
    return this.tags;
  }
  public Node getNext() {
    return this.next;
  }


}
