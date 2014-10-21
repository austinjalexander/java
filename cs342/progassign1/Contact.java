// File: Contact.java
// Student: Austin J. Alexander
// Assignment: Programming Assignment 1
// Course: MET CS342 (FALL 2014)

import java.io.*;

public class Contact implements Serializable {

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
    this.email = email.toLowerCase();
    this.phone_number = phone_number.toUpperCase();
    this.next_contact = null;
  }

  public Contact(String full_name, String email, String phone_number, 
                 Contact next_contact) {
    this.full_name = full_name.toUpperCase();
    this.email = email.toLowerCase();
    this.phone_number = phone_number.toUpperCase();
    this.next_contact = next_contact;
  }

  // GETTERS 
  public String getFullName() {
    return this.full_name;
  }

  public String getEmail() {
    return this.email;
  }

  public String getPhoneNumber() {
    return this.phone_number;
  }

  public Contact getNextContact() {
    return this.next_contact;
  }

  // SETTERS
  public void setNextContact(Contact next_contact) {
    this.next_contact = next_contact;
  }

  // PUBLIC METHODS
  public String toString() {
    return "Full Name: " + this.full_name + "\n" +
           "Email: " + this.email + "\n" +
           "Phone Number: " + this.phone_number + "\n";
  }

  public Boolean isNextContactNull() {
    Boolean next_is_null = false;

    if (this.next_contact == null) {
      next_is_null = true;
    }

    return next_is_null;
  }

} //end: public class Contact

