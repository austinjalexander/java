// File: ListOTen.java
// Student: Austin J. Alexander
// Assignment: Homework 2.1
// Course: MET CS342 (FALL 2014)

public class ListOTen {

  public static void main(String[] args) {

    //int[] items = {  };                                        //  0 items
    //int[] items = { 12 };                                      //  1 item
    int[] items = { 12, 34, 435345, -1, 12, 56, 654, 0, 90, 1 }; // 10 items

    List list = new List();
    System.out.println("\n<--- Add Items to List --->");

    for (int i = 0; i < items.length; i++) {
      list.addItem(items[i]);
    }

    System.out.println("\n<--- Display List Items --->");
    list.displayList();

    System.out.println("\n<--- Remove Last Item from List --->");
    list.removeLastItem();

    System.out.println("\n<--- Display List Items --->");
    list.displayList();

    System.out.println();
  }

}
