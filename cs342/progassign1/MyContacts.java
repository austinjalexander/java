// File: MyContacts.java
// Student: Austin J. Alexander
// Assignment: Programming Assignment 1
// Course: MET CS342 (FALL 2014)

import java.util.Scanner;

public class MyContacts {

  public static void main(String[] args) {

    // create new contact list
    ContactList contact_list = new ContactList();

    // create new scanner for user input
    Scanner user_input = new Scanner(System.in);

    System.out.println("\n\n\t\t\t******* MY CONTACTS *******\n");

    // create a Boolean flag to track is the user wants to continue
    Boolean continue_program = true;
    // set a counter to 0; after the first loop, it will increment (to remove the menu)
    int counter = 0;

    // while the user wants to continue
    while (continue_program) {
      // show commands before the first prompt
      if (counter == 0) {
        System.out.println("\tCOMMANDS:");
        System.out.println("\t [a]dd: adds a new contact to the list");
        System.out.println("\t\tenter command> a, Sara Pethe, sara@bu.edu, 617-353-9102");
        System.out.println("\t [d]elete: deletes a contact from the list using the index number");
        System.out.println("\t\tenter command> d, 1");
        System.out.println("\t [s]earch: searches for a contact in the list using a string");
        System.out.println("\t\tenter command> s, Nathan");
        System.out.println("\t [e]mail: searches for a contact in the list using a string");
        System.out.println("\t\tenter command> e, gmail");   
        System.out.println("\t [w]rite: write contacts to a file");
        System.out.println("\t\tenter command> w, my_contacts.dat");   
        System.out.println("\t [r]estore: import contacts from a file");
        System.out.println("\t\tenter command> r, my_contacts.dat"); 
        System.out.println("\t [p]rint: displays the entire contact list");
        System.out.println("\t\tenter command> p"); 
        System.out.println("\t [q]uit: exits program");
        System.out.println("\t\tenter command> q\n"); 
      }
  
      // display command prompt
      System.out.print("\nenter command> ");
      // get line string from user
      String command = user_input.nextLine();
      // split string at commas
      String[] command_parts = command.split(",");
      // get first character as control command
      char control = command_parts[0].trim().charAt(0);

      // use a switch statement to differentiate between control commands;
      // based on the command, the rest of the user's input will be used in various ways
      switch (control) {
        // if A or a
        case 'A':
        case 'a':
        // if there are 4 parts to the command
          if (command_parts.length == 4) {
            // get the full name, email, and phone number and add the new contact
            contact_list.addNewContact(command_parts[1].trim(), 
                                       command_parts[2].trim(), 
                                       command_parts[3].trim());
            // let the user know
            System.out.println("\n\tCONTACT ADDED!");
          }
          // otherwise
          else {
            // say the command is unknown
            System.out.println("\n\t-- command not recognized --");
          }
          break;
        // if D or d
        case 'D':
        case 'd': 
          // if there are 2 parts to the command
          if (command_parts.length == 2) {
            // attempt to use the 2nd part as an index number
            try {
              int index = Integer.parseInt(command_parts[1].trim());
              // check with the user to be sure
              System.out.print("Are you sure? [Y/N]: ");
              command = user_input.nextLine();
              char answer = command.trim().charAt(0);
              // if the user is sure
              if (answer == 'Y' || answer == 'y') {
                // find and delete contact (if it exists)
                contact_list.deleteContact(index);          
              }               
            }
            // catch if the index isn't valid as input (e.g., it's a string)
            catch (Exception e) {
              System.out.println("\n\tINVALID INDEX!");
            }
          }
          // otherwise
          else {
            // say the command is unknown
            System.out.println("\n\t-- command not recognized --");
          }
          break;
        // if S or s
        case 'S':
        case 's': 
          // if there are 2 parts to the command
          if (command_parts.length == 2) {
            System.out.println();
            // search for the string
            contact_list.searchContacts(control, command_parts[1]);          
          }
          // otherwise
          else {
            // say the command is unknown
            System.out.println("\n\t-- command not recognized --");
          }
          break;
        // if E or e
        case 'E':
        case 'e': 
          // if there are 2 parts to the command
          if (command_parts.length == 2) {
            System.out.println();
            // search for the string
            contact_list.searchContacts(control, command_parts[1]);          
          }
          // otherwise
          else {
            // say the command is unknown
            System.out.println("\n\t-- command not recognized --");
          }
          break;
        // if W or w
        case 'W':
        case 'w': 
          // if there are 2 parts to the command
          if (command_parts.length == 2) {
            // attempt to write to file
            contact_list.writeToFile(command_parts[1]);
          }
          // otherwise
          else {
            // say the command is unknown
            System.out.println("\n\t-- command not recognized --");
          }
          break;
        // if R or r
        case 'R':
        case 'r': 
          // if there are 2 parts to the command
          if (command_parts.length == 2) {
            // attempt to read from file
            contact_list.restoreFromFile(command_parts[1]);
          }
          // otherwise
          else {
            // say the command is unknown
            System.out.println("\n\t-- command not recognized --");
          }
          break;
        // if P or p
        case 'P':
        case 'p': 
          // display the contacts to the user
          contact_list.printList();
          break;
        // if Q or q
        case 'Q':
        case 'q': 
          // ask user to save contacts before closing
          System.out.print("Save contacts before closing? [Y/N]: ");
          command = user_input.nextLine();
          char answer = command.trim().charAt(0);
          // if the user is sure
          if (answer == 'Y' || answer == 'y') {
            // ask user for filename
            System.out.print("Please enter filename: ");
            String filename = user_input.nextLine();
            contact_list.writeToFile(filename.trim());
          } 
          continue_program = false;
          System.out.println("\n\n\t\t\t******* GOODBYE! *******\n");
          break;
        default:
          System.out.println("\n\tPlease select from one of the given commands.");
          break;
      } //end: switch (control)

      // increment counter so that command list doesn't display on every iteration
      counter++;    
    } //end: while (continue_program)



    /****************************** FOR TESTING ******************************/
    /*** test list_length 0 ***/


    /*** test list_length 1 ***/
    //contact_list.addNewContact("Sara Pethe", "sarapethe@bu.edu", "617-353-0092");


    /*** test list_length 2 ***/
    //contact_list.addNewContact("Sara Pethe", "sarapethe@bu.edu", "617-353-0092");
    //contact_list.addNewContact("Sara Pethe", "sarap@bu.edu", "617-358-1048");  

    /*** test list_length 2 ***/
    //contact_list.addNewContact("Sara Pethe", "sarap@bu.edu", "617-358-1048");  
    //contact_list.addNewContact("Sara Pethe", "sarapethe@bu.edu", "617-353-0092");

    /*** test list_length 2 ***/
    //contact_list.addNewContact("Nathan Goldman", "nateg@bu.edu", "617-353-2811");
    //contact_list.addNewContact("Sara Pethe", "sarap@bu.edu", "617-358-1048");  

    /*** test list_length 2 ***/
    //contact_list.addNewContact("Sara Pethe", "sarap@bu.edu", "617-358-1048");  
    //contact_list.addNewContact("Nathan Goldman", "nateg@bu.edu", "617-353-2811");


    /*** test list_length 3 ***/
    //contact_list.addNewContact("Sara Pethe", "sarapethe@bu.edu", "617-353-0092");
    //contact_list.addNewContact("Sara Pethe", "sarap@bu.edu", "617-358-1048"); 
    //contact_list.addNewContact("Nathan Goldman", "nateg@bu.edu", "617-353-2811"); 

    /*** test list_length 3 ***/
    //contact_list.addNewContact("Cali Stephens", "cali@bu.edu", "617-353-0092");  
    //contact_list.addNewContact("Nathan Goldman", "nateg@bu.edu", "617-353-2811");
    //contact_list.addNewContact("Sara Pethe", "sarap@bu.edu", "617-358-1048");  

    /*** test list_length 3 ***/
    //contact_list.addNewContact("Sara Pethe", "sarap@bu.edu", "617-358-1048");  
    //contact_list.addNewContact("Cali Stephens", "cali@bu.edu", "617-353-0092");  
    //contact_list.addNewContact("Nathan Goldman", "nateg@bu.edu", "617-353-2811");

    /*** test list_length 3 ***/
    //contact_list.addNewContact("Nathan Goldman", "nateg@bu.edu", "617-353-2811");
    //contact_list.addNewContact("Sara Pethe", "sarap@bu.edu", "617-358-1048");  
    //contact_list.addNewContact("Cali Stephens", "cali@bu.edu", "617-353-0092");  


    /*** test list_length 5 ***/
    //contact_list.addNewContact("Nathan Goldman", "nateg@bu.edu", "617-353-2811");
    //contact_list.addNewContact("Asher Alexander", "asher@bu.edu", "617-202-2008");
    //contact_list.addNewContact("Sara Pethe", "sarap@bu.edu", "617-358-1048");  
    //contact_list.addNewContact("Cali Stephens", "cali@bu.edu", "617-353-0092");  
    //contact_list.addNewContact("Asher Alexander", "asher@mit.edu", "617-555-2008");


    //contact_list.printList();
    /*************************************************************************/

  } //end: public static void main(String[] args)
} //end: public class MyContacts

