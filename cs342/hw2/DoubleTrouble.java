// File: DoubleTrouble.java
// Student: Austin J. Alexander
// Assignment: Homework 2.2
// Course: MET CS342 (FALL 2014)

public class DoubleTrouble {

  public static void main(String[] args) {  

    // as an example for use, each node could be a review object,
    // and each review will have data, which in this case will be an 
    // array of "tags" (e.g., for a reviews website, 
    // where each node/item gets tagged by users/reviewers)
    String[] tag_set_1 = { "fun", "great", "amazing" };  
    String[] tag_set_2 = { "lame", "boring", "worst" };  
    String[] tag_set_3 = { "ok", "maybe", "eh" };  

    DoublyLinkedList list = new DoublyLinkedList();

    System.out.println("\n<--- Add Items to List --->");
    list.addItem(tag_set_1);
    list.addItem(tag_set_2);
    list.addItem(tag_set_3);

    System.out.println("\n<--- Display List Items --->");
    list.displayList();

    System.out.println("\n<--- Remove Last Item from List --->");
    list.removeLastItem();

    System.out.println("\n<--- Display List Items --->");
    list.displayList();

    System.out.println();
  }

}
