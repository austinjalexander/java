// File: DoublyLinkedNode.java
// Student: Austin J. Alexander
// Assignment: Homework 2.2
// Course: MET CS342 (FALL 2014)

public class DoublyLinkedNode {

  // INSTANCE VARIABLES //
  private DoublyLinkedNode prev;
  private String[] data;
  private DoublyLinkedNode next;

  // CONSTRUCTORS //
  public DoublyLinkedNode() {
    this.prev = null;
    this.data = new String[3]; // default data size is 3
    for (int i = 0; i < data.length; i++) {
      this.data[i] = data[i];
    }
    this.next = null;
  }
  public DoublyLinkedNode(String[] data) {
    this.prev = null;
    this.data = new String[data.length];
    for (int i = 0; i < data.length; i++) {
      this.data[i] = data[i];
    }
    this.next = null;
  }

  // PUBLIC SETTERS //
  public void setPrev(DoublyLinkedNode prev) {
    this.prev = prev;
  }
  public void setItem(String[] data) {
    for (int i = 0; i < data.length; i++) {
      this.data[i] = data[i];
    }
  }
  public void setNext(DoublyLinkedNode next) {
    this.next = next;
  }

  // PUBLIC GETTERS //
  public DoublyLinkedNode getPrev() {
    return this.prev;
  }
  public String[] getItem() {
    return this.data;
  }
  public DoublyLinkedNode getNext() {
    return this.next;
  }

  // PUBLIC METHODS //
  public String toString() {
    String data_string = "[";
    for (int i = 0; i < this.data.length; i++) {
      if ((i + 1) == this.data.length) {
        data_string += data[i] + "]";
      }
      else {
        data_string += data[i] + ", ";
      }
    }
    return data_string;
  }
}
