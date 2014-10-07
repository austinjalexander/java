// File: Contact.java
// Student: Austin J. Alexander
// Assignment: Programming Assignment 1
// Course: MET CS342 (FALL 2014)

public class Contact {

  // INSTANCE VARIABLES
  private String full_name;
  private String email;
  private String phone_number;
  private Contact next_contact;

  // CONSTRUCTORS 
  public Contact() {
    this.full_name = "";
    this.email = "";
    this.phone_number = "";
    this.next_contact = null;
  }

  public Contact(String full_name, String email, String phone_number) {
    this.full_name = full_name.toUpperCase();
    this.email = email.toUpperCase();
    this.phone_number = phone_number.toUpperCase();
    this.next_contact = null;
  }

  // GETTERS 
  public Contact getNextContact() {
    return this.next_contact;
  }

  // SETTERS
  public void setNextContact(Contact next_contact) {
    this.next_contact = next_contact;
  }


}

