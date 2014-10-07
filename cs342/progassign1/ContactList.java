// File: ContactList.java
// Student: Austin J. Alexander
// Assignment: Programming Assignment 1
// Course: MET CS342 (FALL 2014)

public class ContactList {

  // INSTANCE VARIABLES
  private Contact first_contact;

  // CONSTRUCTORS
  public ContactList() {
    this.first_contact = null;
  }

  // GETTERS


  // SETTERS

  // PUBLIC METHODS
  public void addNewContact(String full_name, String email, String phone_number) {
    if (this.first_contact == null) {
      this.first_contact = new Contact(full_name, email, phone_number);
    }
    else if (this.first_contact.getNextContact() == null) {
      this.first_contact.setNextContact(new Contact(full_name, email, phone_number));
    }
  }

  public String FirstContactToString() {
    return this.first_contact;   ///////////HERE because getter is dangerous with an object
  }

}


