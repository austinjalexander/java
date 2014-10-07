// File: MyContacts.java
// Student: Austin J. Alexander
// Assignment: Programming Assignment 1
// Course: MET CS342 (FALL 2014)

public class MyContacts {


  public static void main(String[] args) {


    ContactList contact_list = new ContactList();

    contact_list.displayList();

    // Add new contact
    //contact_list.addNewContact("Sara Pethe", "sarapethe@bu.edu", "617-353-0092");
    //contact_list.addNewContact("Nate Goldman", "nateg@bu.edu", "617-353-2811");

    //contact_list.displayList();

    // Add new contact
    contact_list.addNewContact("Nate Goldman", "nateg@bu.edu", "617-353-2811");
    contact_list.addNewContact("Sara Pethe", "sarap@bu.edu", "617-353-1048");
    contact_list.addNewContact("Cali Stephens", "cali@bu.edu", "617-353-0092");

    contact_list.displayList();


  }




}

