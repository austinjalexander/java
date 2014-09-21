// File: List.java
// Student: Austin J. Alexander
// Assignment: Homework 2.1
// Course: MET CS342 (FALL 2014)

public class List {

  // INSTANCE VARIABLE //
  private Node head;

  // CONSTRUCTOR //
  public List() {
    this.head = null;
  }

  // PUBLIC METHODS //
  public void addItem(int item) {
    // when the list is empty, simply set this.head to the new node
    if (this.head == null) {
      this.head = new Node(item);
      System.out.println("Adding: " + this.head.getItem());
    }
    // otherwise...
    else {
      // make a temp node (initialized to this.head) and a null node
      Node temp_node = this.head; 
      Node new_node = null; 
      /* * * * * * * * * * 
       * while the new node remains null, 
       * loop through, setting the temp node to each next node;
       * once the temp node's next node is null
       * (i.e., the temp node is the last node),
       * create the new node with the item, print the item,
       * and set the temp/last node's next value to the new node;
       * now that new node has an object reference, 
       * the loop will exit
       * * * * * * * * * */
      while (new_node == null) {
        if (temp_node.getNext() == null) {
          new_node = new Node(item);
          System.out.println("Adding: " + new_node.getItem());
          temp_node.setNext(new_node);
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
      Node temp_node = this.head;
      /* * * * * * * * * * 
       * while the temp node is not null,
       * print the item number and the item;
       * at the end of each loop (i.e., after each printing), 
       * set the temp node to the next node;
       * once the next node is null (i.e., once we're on the last node),
       * the temp node will then be set to null,
       * and the loop will exit
       * * * * * * * * * */
      while (temp_node != null) {
        System.out.println("Item " + (++counter) + ": " 
                             + temp_node.getItem());
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
      System.out.println("Removing: " + this.head.getItem());
      this.head = null; // this.head node gets garbage collected
    }
    // otherwise...
    else {
      // make new last node (set to null) 
      // and a temp node (initialized to this.head)
      Node new_last_node = null;
      Node temp_node = this.head;
      /* * * * * * * * * * 
       * while the temp node is not null, 
       * loop through, setting the new last node to the current temp node,
       * and set the temp node to the next node;
       * once the temp node's next node is null
       * (i.e., the temp node is the last node),
       * print the the item being removed,
       * set the new last node's next value to null
       * (it's now the true new last node),
       * set the temp node's value to null,
       * and the loop will exit
       * * * * * * * * * */
      while (temp_node != null) {
        if (temp_node.getNext() == null) {
          System.out.println("Removing: " + temp_node.getItem());
          new_last_node.setNext(null); // old last node gets garbage collected
          temp_node = null;
        }
        else {
          new_last_node = temp_node;
          temp_node = temp_node.getNext();
        }
      }
    }
  }

}
