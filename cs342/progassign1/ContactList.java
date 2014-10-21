// File: ContactList.java
// Student: Austin J. Alexander
// Assignment: Programming Assignment 1
// Course: MET CS342 (FALL 2014)

import java.io.*;

public class ContactList {

  // INSTANCE VARIABLES
  private Contact first_contact;

  // CONSTRUCTORS
  public ContactList() {
    this.first_contact = null;
  }

  // PUBLIC METHODS
  public void addNewContact(String full_name, String email, String phone_number) {

    // capitalize full name for simpler string/character comparison
    full_name = full_name.toUpperCase();

    //*** if the list is empty ***//
    if (this.first_contact == null) {
      // set the first contact to the new contact
      this.first_contact = new Contact(full_name, email, phone_number);
    }
    //*** if the list has one contact ****//
    else if (this.first_contact.isNextContactNull() == true) {

      // make last name string comparison
      /* if the first string is lexicographically equivalent to the second, (comparison = 0)
       * if the first lstring is exicographically precedes the second, (comparison < 0)
       * if the first string is lexicographically follows the second, (comparison > 0) */
      int comparison = getLastName(this.first_contact.getFullName()).compareTo(getLastName(full_name));

      // if the new contact should be after the first contact
      if (comparison <= 0) {
        // set the new contact as the second contact
        this.first_contact.setNextContact(new Contact(full_name, email, phone_number));
      }
      // if the new contact should be the new first contact
      else if (comparison > 0) {
        // set the new contact as the first, with the original first contact as the new second
        Contact new_contact = new Contact(full_name, email, phone_number, this.first_contact);
        this.first_contact = new_contact;
      }
    }
    //*** if the list has more than one contact ****//
    else if (this.first_contact.isNextContactNull() == false) {

      // make full_name string comparison
      int comparison = getLastName(this.first_contact.getFullName()).compareTo(getLastName(full_name));

      // if the new contact should be the new first contact
      if (comparison > 0) {
        // set the new contact as the first, with the original first contact as the new second
        Contact new_contact = new Contact(full_name, email, phone_number, this.first_contact);
        this.first_contact = new_contact;
      }
      // otherwise, loop til the proper lexicographic location is found
      else if (comparison <= 0) {
        Contact current_contact = this.first_contact;
        Contact next_contact = this.first_contact.getNextContact();

        // use a Boolean flag to indicate that the loop should continue
        Boolean found_location = false;
        while (found_location == false) {

          // make full_name string comparisons
          int current_contact_comparison = getLastName(current_contact.getFullName()).compareTo(getLastName(full_name));
          int next_contact_comparison = getLastName(next_contact.getFullName()).compareTo(getLastName(full_name));

          // if the proper location is found
          if (current_contact_comparison <= 0 && next_contact_comparison > 0) {
            // set the new contact as the current contact's next, 
            // with the old next contact as new contact's next
            current_contact.setNextContact(new Contact(full_name, email, 
                                                          phone_number, next_contact));
            // update the Boolean flag to exit loop
            found_location = true;
          }
          else {
            // if the end of the list has been reached
            if (next_contact.getNextContact() == null) {
              // set the new contact as the new last contact
              next_contact.setNextContact(new Contact(full_name, email, 
                                                        phone_number));   
              // update the Boolean flag to exit loop
              found_location = true;           
            }
            // otherwise, move to the next contacts in list
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
      // let the user know the list is empty
      System.out.println("\n/*** Your Contact List is empty. ***/");
    }
    //*** if the list has one contact and index == 0 ***//
    else if ((this.first_contact.isNextContactNull() == true) && index == 0) {
      // set the first contact to null and let the user know
      this.first_contact = null;
      System.out.println("\n\tCONTACT DELETED!");
    }
    //*** if the list has one contact and index != 0 ***//
    else if ((this.first_contact.isNextContactNull() == true) && index != 0) {
      // let the user know that the index is invalid
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

      // otherwise, loop until index is found,
      // or the loop has extended beyond the list
      else if (index != 0) {

        // store a counter
        int counter = 0;

        // store the previous and current contacts, starting at the first contact
        Contact previous_contact = this.first_contact;
        Contact current_contact = this.first_contact;

        // while the current contact is not null
        while (current_contact != null) {

          // if counter == index, the contact has been found
          if (counter == index) {
            // set the previous contact to the current contact's 
            // next contact, even if it is null
            previous_contact.setNextContact(current_contact.getNextContact());
            // display the deleted message to the user
            System.out.println("\n\tCONTACT DELETED!"); 

            // set current contact to null in order to exit the loop
            current_contact = null;
          }
          // otherwise
          else if (counter != index) {
            // update previous and current contacts to those next in list
            previous_contact = current_contact;
            // unless the next contact is null (i.e., the end of the list has been reached)
            if (current_contact.isNextContactNull() == false) {
              // set the current contact to the next contact
              current_contact = current_contact.getNextContact();
            }
            // otherwise
            else if (current_contact.isNextContactNull() == true) {
              // set current contact to null in order to exit the loop,
              // since the loop went beyond the list
              current_contact = null;
              // let the user know that the index is invalid
              System.out.println("\n\tINVALID INDEX!");
            }
            // increment the counter
            counter++;
          }          
        } //end: while (current_contact != null)
      } //end: else if (index != 0)
    } //end: else if (this.first_contact.isNextContactNull() == false)
  } //end: public void deleteContact(int index) 

  public void searchContacts(char search_type, String search_string) {
    // set an index to 0 to display along with any found contacts
    int index = 0;

    // upcase the search string in order to make comparison easier
    search_string = search_string.toUpperCase();

    // set current contact to first contact
    Contact current_contact = this.first_contact;

    // keep track of number of matches
    int number_of_matches_found = 0;
    // loop until current contact is null (i.e., end of list has been reached)
    while (current_contact != null) {

      // set a Boolean flag to false
      Boolean match_found = false;

      // depending on name or email search
      if (search_type == 'S' || search_type == 's') {
        // set Boolean flag to true is there is a name string match
        match_found = current_contact.getFullName().contains(search_string);        
      }
      else if (search_type == 'E' || search_type == 'e') {
        // set Boolean flag to true is there is an email string match
        match_found = current_contact.getEmail().contains(search_string);         
      }

      // if a match has been found
      if (match_found == true) {
        // display the contact to the user
        System.out.println("[contact " + index + "]");
        System.out.println(current_contact.toString());
        // increment the number of matches found
        number_of_matches_found++;
      } 

      // get next contact
      current_contact = current_contact.getNextContact();
      // increment index
      index++;
    }

    // if no matches
    if (number_of_matches_found == 0) {
      // let user know, depending on name or email search
      if (search_type == 'S' || search_type == 's') {
        System.out.println("\n\tName string not found!");        
      }
      else if (search_type == 'E' || search_type == 'e') {
        System.out.println("\n\tEmail string not found!");        
      }
    }
  } //end: public void searchContacts(String name_string)    

  public void writeToFile(String filename) {

    // try
    try {
      // using the filename provided by the user,
      // opening a new file, fileoutputstream, and objectoutputstream
      File file = new File(filename);
      FileOutputStream file_output_stream = new FileOutputStream(file);
      ObjectOutputStream object_output_stream = new ObjectOutputStream(file_output_stream);

      // set current contact to first contact
      Contact current_contact = this.first_contact;

      // loop until current contact is null
      while (current_contact != null) { 
        // write the current contact to the object stream
        object_output_stream.writeObject(current_contact);
        // set current contact to next contact
        current_contact = current_contact.getNextContact();
      }   

      // close the objectoutputstream and fileoutputstream
      object_output_stream.close();
      file_output_stream.close();

      // let the user know the write was successful
      System.out.println("\n\tContacts written to file!");
    }
    // catch any file/output issues and let the user know
    catch (Exception e) {
      System.out.println("\n\tSomething is wrong with the output file!");
    }
  } //end: public void writeToFile(String filename)

  public void restoreFromFile(String filename) {

    // try
    try {
      // using the filename provided by the user,
      // opening a new file, fileoutputstream, and objectoutputstream
      File file = new File(filename);
      FileInputStream file_input_stream = new FileInputStream(file);
      ObjectInputStream object_input_stream = new ObjectInputStream(file_input_stream);

      // set a Boolean flag to true for continuing the loop
      Boolean reading_file = true;
      while (reading_file) { 
        // set new contact to the current objectinputstream object
        Contact new_contact = (Contact) object_input_stream.readObject();
        // if the current objectinputstream object is null
        if (new_contact == null) {
          // set the Boolean flag to false in order to exit the loop
          reading_file = false;
        }
        // otherwise
        else {
          // add the new contact to the contact list
          this.addNewContact(new_contact.getFullName(), new_contact.getEmail(), 
                             new_contact.getPhoneNumber());
        }
      }   

      // close the objectoutputstream and fileoutputstream
      object_input_stream.close();
      file_input_stream.close();
    }
    // in this case, the EOF is a good thing;
    // let the user know that the contacts were successfully read
    catch (EOFException e) {
      System.out.println("\n\tContacts restored from file!");
    }
    // catch any file/input issues and let the user know
    catch (Exception e) {
      System.out.println("\n\tSomething is wrong with the input file!");
    }
  } //end: public void restoreFromFile(String filename)

  public void printList() {
    //*** if the list is empty ***//
    if (this.first_contact == null) {
      // let the user know
      System.out.println("\n/*** Your Contact List is empty. ***/");
    }
    //*** if the list has one or more contacts ***//
    else {
      // set an index to 0
      int index = 0;
      // set the current contact as the first
      Contact current_contact = this.first_contact;

      System.out.println("\n<-- Your Contact List -->\n");
      // while current contact is not null
      while (current_contact != null) {
        // display the current index and the current contact's information
        System.out.println("[contact " + index + "]");
        System.out.println(current_contact.toString());
        // get next contact
        current_contact = current_contact.getNextContact();
        // increment index
        index++;
      }
      System.out.println("<-- End of Contact List -->");
    }
  } //end: public void printList()

  // PRIVATE HELPING METHODS
  private String getLastName(String full_name) {

    // split full name by it's whitespace
    String[] name_parts = full_name.split(" ");

    // return what is (hopefully) the last name
    return name_parts[(name_parts.length - 1)];
  }

} //end: public class ContactList


