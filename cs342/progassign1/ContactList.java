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

    // capitalize name for simpler string/character comparison
    full_name = full_name.toUpperCase();

    // list_length == 0
    //*** if the list is empty ***//
    if (this.first_contact == null) {
      this.first_contact = new Contact(full_name, email, phone_number);
    }

    // list_length == 1
    //*** if the list has one contact ****//
    else if (this.first_contact.isNextContactNull() == true) {

      // make full_name string comparison
      int comparison = this.first_contact.getFullName().compareTo(full_name);

      // first(A), new(A) || first(A), new(B)
      /* if first_contact.full_name and new_contact.full_name
       * are lexicographically equivalent (comparison = 0),
       * OR if first_contact.full_name lexicographically precedes
       * new_contact.full_name (comparison < 0) 
       * set new_contact as last contact in list */
      if (comparison == 0 || comparison < 0) {
        this.first_contact.setNextContact(new Contact(full_name, email, phone_number));
      }

      // new(A), first(B)
      /* else if first_contact.full_name lexicographically follows
       * new_contact.full_name (comparison > 0),
       * set new_contact as first contact in list */
      else if (comparison > 0) {
        Contact new_contact = new Contact(full_name, email, phone_number, this.first_contact);
        this.first_contact = new_contact;
      } 
    }

    // list_length > 1
    //*** if the list has more than one contact ****//
    else if (this.first_contact.isNextContactNull() == false) {

      // make full_name string comparison
      int comparison = this.first_contact.getFullName().compareTo(full_name);

      // new(A), first(B)
      /* if first_contact.full_name lexicographically follows
       * new_contact.full_name (comparison > 0),
       * set new_contact as first contact in list */
      if (comparison > 0) {
        Contact new_contact = new Contact(full_name, email, phone_number, this.first_contact);
        this.first_contact = new_contact;
      } 

      // first(A), new(A) 
      // OR
      // first(A), .?., new(B), next(C)
      /* else first_contact.full_name and new_contact.full_name
       * are lexicographically equivalent (comparison = 0),
       * OR first_contact.full_name lexicographically precedes
       * new_contact.full_name (comparison < 0),
       * find the proper lexicographic location for new_contact 
       * by looping through the list */
      else if (comparison == 0 || comparison < 0) {

        Contact current_contact = this.first_contact;
        Contact next_contact = this.first_contact.getNextContact();

        Boolean found_location = false;
        while (found_location == false) {

          // make full_name string comparisons
          int current_contact_comparison = this.first_contact.getFullName().compareTo(full_name);
          int next_contact_comparison = this.first_contact.getNextContact().getFullName().compareTo(full_name);

          // current(C), new(C), next(F)
          // OR
          // current(C), new(D), next(F)
          /* if current_contact.full_name and new_contact.full_name
           * are lexicographically equivalent (current_contact_comparison = 0),
           * AND next_contact.full_name lexicographically follows
           * new_contact.full_name (next_contact_comparison > 0),
           * OR if current_contact.full_name lexicographically precedes
           * new_contact.full_name (current_contact_comparison < 0) 
           * AND next_contact.full_name lexicographically follows
           * new_contact.full_name (next_contact_comparison > 0), 
           * set new_contact as the contact in between 
           * current_contact and next_contact */
          if ((current_contact_comparison == 0 && next_contact_comparison > 0) || 
               (current_contact_comparison < 0 && next_contact_comparison > 0)) {

            current_contact.setNextContact(new Contact(full_name, email, 
                                                          phone_number, next_contact));
            found_location = true;
          }

          // current(C), new(C), next(C)
          // OR
          // current(C), new(D), next(D)
          /* if current_contact.full_name and new_contact.full_name
           * are lexicographically equivalent (current_contact_comparison = 0),
           * AND next_contact.full_name and new_contact.full_name
           * are lexicographically equivalent (current_contact_comparison = 0),
           * OR if current_contact.full_name lexicographically precedes
           * new_contact.full_name (current_contact_comparison < 0) 
           * AND next_contact.full_name and new_contact.full_name
           * are lexicographically equivalent (current_contact_comparison = 0),
           * iterate through the loop */
          else if ((current_contact_comparison == 0 && next_contact_comparison == 0) || 
               (current_contact_comparison < 0 && next_contact_comparison == 0)) {

            found_location = false;
          }

        } // end: while (found_location == false)
      } // end: else if (comparison < 0)
    } // end: else if (this.first_contact.isNextContactNull() == false) 
  } // end: public void addNewContact(String full_name, String email, String phone_number)

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


