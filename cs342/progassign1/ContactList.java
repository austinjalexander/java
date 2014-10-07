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

    //*** if the list is empty ***//
    if (this.first_contact == null) {
      this.first_contact = new Contact(full_name, email, phone_number);
    }
    // make full_name string comparison
    int comparison = this.first_contact.getFullName().compareTo(full_name);

    //*** if the list has one contact ****//
    // AND if first_contact.full_name and new_contact.full_name
    // are lexicographically equivalent (comparison = 0), order doesn't matter,
    // set new_contact as last contact in list
    else if (this.first_contact.isNextContactNull() == true && comparison == 0) {
      this.first_contact.setNextContact(new Contact(full_name, email, phone_number));
    }

    //*** if the list has one contact ****//
    // AND if first_contact.full_name is lexicographically after
    // new_contact.full_name (comparison < 0),
    // set new_contact as first contact in list  
    else if (this.first_contact.isNextContactNull() == true && comparison < 0) {
      Contact new_contact = new Contact(full_name, email, phone_number, this.first_contact));
      this.first_contact = new_contact;
    }

    //*** if the list has more than one contact ****//
    // AND if first_contact.full_name is lexicographically after
    // new_contact.full_name (comparison < 0),
    // set new_contact as first contact in list  
    else if (this.first_contact.isNextContactNull() == false && comparison < 0) {
      Contact new_contact = new Contact(full_name, email, phone_number, this.first_contact));
      this.first_contact = new_contact;
    }





    
,
    // OR
    // if first_contact.full_name is lexicographically 
    // after new_contact.full_name (comparison > 0)
    else if (comparison == 0) {
      

    }

/*


      // if first_contact.full_name is lexicographically 
      // equivalent to new_contact.full_name (comparison = 0),
      // the order doesn't matter, set new_contact to first_contact.next_contact;
      // if first_contact.full_name is lexicographically 
      // before new_contact.full_name (comparison < 0), 
      // set new_contact to first_contact.next_contact
      if (comparison <= 0) {
        this.first_contact.setNextContact(new Contact(full_name, email, phone_number));
      }
      // if first_contact.full_name is lexicographically 
      // after new_contact.full_name (comparison > 0)
      else if (comparison > 0) {
        this.first_contact.setNextContact(null);
        Contact new_contact = new Contact(full_name, email, phone_number, this.first_contact);
        this.first_contact = new_contact;
      }
    }
    // if the list has more than one contact
    else {
      Contact current_contact = this.first_contact;
      Contact next_contact = this.first_contact.getNextContact();

      Boolean continue_loop = true;
      while (continue_loop == true) {

        int current_contact_comparison = current_contact.getFullName().compareTo(full_name);
        int next_contact_comparison = next_contact.getFullName().compareTo(full_name);

        // if current_contact.full_name is lexicographically 
        // equivalent to new_contact.full_name (current_contact_comparison = 0),
        // the order doesn't matter, set new_contact to current_contact.next_contact,
        // setting new_contact.next_contact to the original current_contact.next_contact
        if (current_contact_comparison == 0) {
          current_contact.setNextContact(new Contact(full_name, email, 
                                                     phone_number, next_contact));
        }
        // if current_contact.full_name is lexicographically 
        // before new_contact.full_name (current_contact_comparison < 0)
        else if (current_contact_comparison < 0) {
          // if current_contact is the end of the list,
          // set next_contact to new_contact,
          // then exit loop
          if (current_contact.isNextContactNull() == true) {
            current_contact.setNextContact(new Contact(full_name, email, 
                                                     phone_number));
            continue_loop = false;
          }
          // if next_contact.full_name is also lexicographically 
          // before new_contact.full_name (next_contact_comparison < 0),
          // set current_contact to next_contact,
          // set a new next_contact,
          // and go back through loop
          else if (next_contact_comparison < 0) {
            current_contact = current_contact.getNextContact();
            next_contact = current_contact.getNextContact();
          }
          // if next_contact.full_name is lexicographically 
          // after new_contact.full_name (comparison > 0),
          // then new_contact has found its home,
          // then exit loop 
          else if (next_contact > 0) {
            current_contact.setNextContact(new Contact(full_name, email, 
                                                     phone_number, next_contact));
            continue_loop = false;
          }
        }
        // if current_contact.full_name is lexicographically 
        // before new_contact.full_name (current_contact_comparison < 0)
        else if ()
      }
    }
    */
  }

  public void displayList() {
    if (this.first_contact == null) {
      System.out.println("\n/*** Your Contact List is empty. ***/\n");
    }
    else {
      Contact current_contact = this.first_contact;

      System.out.println("\n<-- Your Contact List -->\n");
      while (current_contact != null) {
        System.out.println(current_contact.toString());
        current_contact = current_contact.getNextContact();
      }
      System.out.println("<-- End of Contact List -->\n");
    }
  }

}


