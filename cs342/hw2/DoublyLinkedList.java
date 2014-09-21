// File: DoublyLinkedList.java
// Student: Austin J. Alexander
// Assignment: Homework 2.2
// Course: MET CS342 (FALL 2014)

public class DoublyLinkedList {

  // INSTANCE VARIABLE //
  private DoublyLinkedNode head;

  // CONSTRUCTOR //
  public DoublyLinkedList() {
    this.head = null;
  }

  // PUBLIC METHODS //
  public void addItem(String[] data) {
    // when the list is empty, simply set this.head to the new node;
    // set the previous and next to null,
    // and display the added data to the user
    if (this.head == null) {
      this.head = new DoublyLinkedNode(data);
      this.head.setPrev(null);
      System.out.println("Adding: " + this.head.toString());
      this.head.setNext(null);

    }
    // otherwise...
    else {
      // make a temp node (initialized to this.head) and a null node
      DoublyLinkedNode temp_node = this.head; 
      DoublyLinkedNode new_node = null; 
      /* * * * * * * * * * 
       * while the new node remains null, 
       * loop through, setting the temp node to each next node;
       * once the temp node's next node is null
       * (i.e., the temp node is the last node),
       * create the new node with the data, 
       * set the temp/last node's next to the new node (i.e., new last node),
       * set the new last node's previous to the temp node,
       * print the data,
       * and set the new last node's next to null;
       * now that new node has an object reference, 
       * the loop will exit
       * * * * * * * * * */
      while (new_node == null) {
        if (temp_node.getNext() == null) {
          new_node = new DoublyLinkedNode(data);
          temp_node.setNext(new_node);
          new_node.setPrev(temp_node);
          System.out.println("Adding: " + new_node.toString());
          new_node.setNext(null);
        }
        else {
          temp_node = temp_node.getNext();
        }
      }
    }
  } 
  public void displayList() {
    // when the list is empty, simply let the user know
    if (this.head == null) {
      System.out.println("The list is empty!");
    }
    // otherwise...
    else {
      // make a list-item counter and a temp node (initialized to this.head)
      int counter = 0;
      DoublyLinkedNode temp_node = this.head;
      /* * * * * * * * * * 
       * while the temp node is not null,
       * print the item number and the data;
       * at the end of each loop (i.e., after each printing), 
       * set the temp node to the next node;
       * once the next node is null (i.e., once we're on the last node),
       * the temp node will then be set to null,
       * and the loop will exit
       * * * * * * * * * */
      while (temp_node != null) {
        System.out.println("Item " + (++counter) + ": " 
                             + temp_node.toString());
        temp_node = temp_node.getNext();
      }
    }
  }
  public void removeLastItem() {
    // when the list is empty, simply let the user know
    if (this.head == null) {
      System.out.println("The list is empty!");
    }
    // if there is only one item in the list, simply set this.head to null
    else if (this.head.getNext() == null) {
      System.out.println("Removing: " + this.head.toString());
      this.head = null; // this.head node gets garbage collected
    }
    // otherwise...
    else {
      // make a temp node (initialized to this.head)
      DoublyLinkedNode temp_node = this.head;
      /* * * * * * * * * * 
       * while the temp node is not null, 
       * loop through, setting the temp node to the next node;
       * once the temp node's next node is null
       * (i.e., the temp node is the last node),
       * print the data being removed,
       * set the previous node's next value to null
       * (it's now the new last node),
       * set the temp node's value to null,
       * and the loop will exit
       * * * * * * * * * */
      while (temp_node != null) {
        if (temp_node.getNext() == null) {
          System.out.println("Removing: " + temp_node.toString());
          temp_node.getPrev().setNext(null);
          temp_node = null; // old last node gets garbage collected
        }
        else {
          temp_node = temp_node.getNext();
        }
      }
    }
  }


}
