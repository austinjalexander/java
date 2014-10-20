// File: MyContacts.java
// Student: Austin J. Alexander
// Assignment: Programming Assignment 1
// Course: MET CS342 (FALL 2014)

public class MyContacts {


  public static void main(String[] args) {


    ContactList contact_list = new ContactList();

    contact_list.displayList();

    // Add new, first contact
    // list_length == 0
    contact_list.addNewContact("Sara Pethe", "sarapethe@bu.edu", "617-353-0092");

    /*** list_length == 1 ***/
    // first(A), new(A)
    //contact_list.addNewContact("Sara Pethe", "sarap@bu.edu", "617-358-1048");  

    // new(A), first(B)
    //contact_list.addNewContact("Nate Goldman", "nateg@bu.edu", "617-353-2811");

    // first(A), new(B)
    //contact_list.addNewContact("Cali Stephens", "cali@bu.edu", "617-353-0092");  


    contact_list.addNewContact("Austin Alexander", "austin@bu.edu", "617-353-3739");
    /*** list_length > 1 ***/
    // first(A), new(A)
    //contact_list.addNewContact("Austin Alexander", "austinjalexander@bu.edu", "617-353-2008");

    // new(A), first(B)
    contact_list.addNewContact("Asher Alexander", "asher@bu.edu", "617-202-2008");


    contact_list.addNewContact("Asher Alexander", "asher@gmail.com", "617-333-2008"); 
    // first(A), .?., new(B), next(C)
    
      // current(C), new(C), next(F)
      contact_list.addNewContact("Cali Stephens", "cali@bu.edu", "617-353-0092");
      // OR
      // current(C), new(D), next(F)
      // current(C), new(C), next(C)
      //contact_list.addNewContact("Asher Alexander", "asher@mit.edu", "617-555-2008");
      // OR
      // current(C), new(D), next(D)



    contact_list.displayList();


  }




}

