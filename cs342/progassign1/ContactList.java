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

  // PUBLIC METHODS
  public void addNewContact(String full_name, String email, String phone_number) {

    // capitalize name for simpler string/character comparison
    full_name = full_name.toUpperCase();

    //*** if the list is empty ***//
    if (this.first_contact == null) {
      this.first_contact = new Contact(full_name, email, phone_number);
    }
    //*** if the list has one contact ****//
    else if (this.first_contact.isNextContactNull() == true) {

      // make full_name string comparison
      /* the first is lexicographically equivalent to the second (comparison = 0)
       * the first lexicographically precedes the second (comparison < 0)
       * the first lexicographically follows the second (comparison > 0) */
      int comparison = this.first_contact.getFullName().compareTo(full_name);

      // if the new contact should be after the first contact
      if (comparison <= 0) {
        this.first_contact.setNextContact(new Contact(full_name, email, phone_number));
      }
      // if the new contact should be the new first contact
      else if (comparison > 0) {
        Contact new_contact = new Contact(full_name, email, phone_number, this.first_contact);
        this.first_contact = new_contact;
      }
    }
    //*** if the list has more than one contact ****//
    else if (this.first_contact.isNextContactNull() == false) {

      // make full_name string comparison
      int comparison = this.first_contact.getFullName().compareTo(full_name);

      // if the new contact should be the new first contact
      if (comparison > 0) {
        Contact new_contact = new Contact(full_name, email, phone_number, this.first_contact);
        this.first_contact = new_contact;
      }
      // otherwise, loop til proper lexicographic location is found
      else if (comparison <= 0) {
        Contact current_contact = this.first_contact;
        Contact next_contact = this.first_contact.getNextContact();

        Boolean found_location = false;
        while (found_location == false) {

          // make full_name string comparisons
          int current_contact_comparison = current_contact.getFullName().compareTo(full_name);
          int next_contact_comparison = next_contact.getFullName().compareTo(full_name);

          // if the proper location is found
          if (current_contact_comparison <= 0 && next_contact_comparison > 0) {
            current_contact.setNextContact(new Contact(full_name, email, 
                                                          phone_number, next_contact));
            found_location = true;
          }
          else {
            // if the end of the list has been reached
            if (next_contact.getNextContact() == null) {
              next_contact.setNextContact(new Contact(full_name, email, 
                                                        phone_number));   

              found_location = true;           
            }
            else {
              current_contact = current_contact.getNextContact();
              next_contact = current_contact.getNextContact();
            }
          }
        } //end: while (found_location == false)
      } //end: else if (comparison <= 0)
    } //end: else if (this.first_contact.isNextContactNull() == false)
  } //end: public void addNewContact(String full_name, String email, String phone_number)

  public void deleteContact(int index) {
    //*** if the list is empty ***//
    if (this.first_contact == null) {
      System.out.println("\n/*** Your Contact List is empty. ***/");
    }
    //*** if the list has one contact and index == 0 ***//
    else if ((this.first_contact.isNextContactNull() == true) && index == 0) {
      this.first_contact = null;
      System.out.println("\n\tCONTACT DELETED!");
    }
    //*** if the list has one contact and index != 0 ***//
    else if ((this.first_contact.isNextContactNull() == true) && index != 0) {
      System.out.println("\n\tINVALID INDEX!");
    }
    //*** if the list has more than one contact ***//
    else if (this.first_contact.isNextContactNull() == false) {
      // if the user wants to delete the first contact,
      // make the second contact the new first contact
      if (index == 0) {
        this.first_contact = first_contact.getNextContact();
        System.out.println("\n\tCONTACT DELETED!");
      }
      // otherwise, loop until index is found
      else {
        int counter = 0;
        Contact previous_contact = this.first_contact;
        Contact current_contact = this.first_contact;

        // while the counter does not equal index
        while (counter != index) {

          // update previous and current contacts to those next in list
          previous_contact = current_contact;
          current_contact = current_contact.getNextContact();

          // increment the counter;
          // once counter == index, the loop will exit
          counter++;            
        }

        // if previous or current are null, the loop went beyond the list
        if (previous_contact == null || current_contact == null) {
          System.out.println("\n\tINVALID INDEX!");
        }
        // otherwise
        else {
          // set the previous contact to the current contact's 
          // next contact, even if it is null
          previous_contact.setNextContact(current_contact.getNextContact());
          System.out.println("\n\tCONTACT DELETED!");         
        }

      }
    } //end: else if (this.first_contact.isNextContactNull() == false)
  } //end: public void deleteContact(int index) 

  public void printList() {
    //*** if the list is empty ***//
    if (this.first_contact == null) {
      System.out.println("\n/*** Your Contact List is empty. ***/");
    }
    //*** if the list has one or more contacts ***//
    else {
      int index = 0;
      Contact current_contact = this.first_contact;

      System.out.println("\n<-- Your Contact List -->\n");
      while (current_contact != null) {
        System.out.println("[contact " + index + "]");
        System.out.println(current_contact.toString());
        current_contact = current_contact.getNextContact();
        index++;
      }
      System.out.println("<-- End of Contact List -->");
    }
  }

} //end: public class ContactList


