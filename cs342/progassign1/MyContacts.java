// File: MyContacts.java
// Student: Austin J. Alexander
// Assignment: Programming Assignment 1
// Course: MET CS342 (FALL 2014)

public class MyContacts {


  public static void main(String[] args) {


    ContactList contact_list = new ContactList();

    System.out.println(contact_list.getFirstContact());
    System.out.println(contact_list.getNextContact());

    // Add new contact
    contact_list.addNewContact("Sara Pethe", "sarapethe@bu.edu", "617-353-0092");

    System.out.println(contact_list.getFirstContact());

    // Add new contact
    contact_list.addNewContact("Nate Goldman", "nateg@bu.edu", "617-353-2811");

    System.out.println(contact_list.getFirstContact());

  }




}

