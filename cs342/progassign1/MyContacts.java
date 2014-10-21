// File: MyContacts.java
// Student: Austin J. Alexander
// Assignment: Programming Assignment 1
// Course: MET CS342 (FALL 2014)

import java.util.Scanner;

public class MyContacts {

  public static void main(String[] args) {

    ContactList contact_list = new ContactList();
    /*** test list_length 3 ***/
    contact_list.addNewContact("Sara Pethe", "sarap@bu.edu", "617-358-1048");  
    contact_list.addNewContact("Cali Stephens", "cali@bu.edu", "617-353-0092");  
    contact_list.addNewContact("Nate Goldman", "nateg@bu.edu", "617-353-2811");

    Scanner user_input = new Scanner(System.in);

    System.out.println("\n\n\t\t\t******* MY CONTACTS *******\n");

    Boolean continue_program = true;
    int counter = 0;

    // while the user wants to continue
    while (continue_program) {
      // show commands before the first prompt
      if (counter == 0) {
        System.out.println("COMMANDS:");
        System.out.println("\t[a]dd: adds a new contact to the list");
        System.out.println("\t\tenter command> a, Sara Pethe, sara@bu.edu, 617-353-9102");
        System.out.println("\t[d]elete: deletes a contact from the list using the index number");
        System.out.println("\t\tenter command> d, 1");
        System.out.println("\t[s]earch: searches for a contact in the list using a string");
        System.out.println("\t\tenter command> s, Nathan");
        System.out.println("\t[e]mail: searches for a contact in the list using a string");
        System.out.println("\t\tenter command> e, gmail");   
        System.out.println("\t[w]rite: write contacts to a file");
        System.out.println("\t\tenter command> w, ~/java/CS342/progassign1/");   
        System.out.println("\t[r]estore: import contacts from a file");
        System.out.println("\t\tenter command> r, ~/java/CS342/progassign1/my_contacts.txt"); 
        System.out.println("\t[p]rint: displays the entire contact list");
        System.out.println("\t\tenter command> p"); 
        System.out.println("\t[q]uit: exits program");
        System.out.println("\t\tenter command> q"); 
      }
  
      System.out.print("\nenter command> ");
      String command = user_input.nextLine();
      String[] command_parts = command.split(",");
      char control = command_parts[0].trim().charAt(0);

      switch (control) {
        case 'A':
        case 'a':
          if (command_parts.length == 4) {
            String full_name = command_parts[1].trim(); 
            String email = command_parts[2].trim(); 
            String phone_number = command_parts[3].trim(); 
            contact_list.addNewContact(full_name, email, phone_number);
            System.out.println("\n\tCONTACT ADDED!");
          }
          else {
            System.out.println("\n\t-- unknown command --");
          }
          break;
        case 'D':
        case 'd': 
          if (command_parts.length == 2) {
            int index = Integer.parseInt(command_parts[1].trim());
            System.out.print("Are you sure? [Y/N]: ");
            command = user_input.nextLine();
            char answer = command.trim().charAt(0);
            if (answer == 'Y' || answer == 'y') {
              contact_list.deleteContact(index);          
            }
          }
          else {
            System.out.println("\n\t-- unknown command --");
          }
          break;
        case 'P':
        case 'p': 
          contact_list.printList();
          break;
        case 'Q':
        case 'q': 
          continue_program = false;
          System.out.println("\n\tGOODBYE!\n");
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
    //contact_list.addNewContact("Nate Goldman", "nateg@bu.edu", "617-353-2811");
    //contact_list.addNewContact("Sara Pethe", "sarap@bu.edu", "617-358-1048");  

    /*** test list_length 2 ***/
    //contact_list.addNewContact("Sara Pethe", "sarap@bu.edu", "617-358-1048");  
    //contact_list.addNewContact("Nate Goldman", "nateg@bu.edu", "617-353-2811");


    /*** test list_length 3 ***/
    //contact_list.addNewContact("Sara Pethe", "sarapethe@bu.edu", "617-353-0092");
    //contact_list.addNewContact("Sara Pethe", "sarap@bu.edu", "617-358-1048"); 
    //contact_list.addNewContact("Nate Goldman", "nateg@bu.edu", "617-353-2811"); 

    /*** test list_length 3 ***/
    //contact_list.addNewContact("Cali Stephens", "cali@bu.edu", "617-353-0092");  
    //contact_list.addNewContact("Nate Goldman", "nateg@bu.edu", "617-353-2811");
    //contact_list.addNewContact("Sara Pethe", "sarap@bu.edu", "617-358-1048");  

    /*** test list_length 3 ***/
    //contact_list.addNewContact("Sara Pethe", "sarap@bu.edu", "617-358-1048");  
    //contact_list.addNewContact("Cali Stephens", "cali@bu.edu", "617-353-0092");  
    //contact_list.addNewContact("Nate Goldman", "nateg@bu.edu", "617-353-2811");


    /*** test list_length 5 ***/
    //contact_list.addNewContact("Nate Goldman", "nateg@bu.edu", "617-353-2811");
    //contact_list.addNewContact("Asher Alexander", "asher@bu.edu", "617-202-2008");
    //contact_list.addNewContact("Sara Pethe", "sarap@bu.edu", "617-358-1048");  
    //contact_list.addNewContact("Cali Stephens", "cali@bu.edu", "617-353-0092");  
    //contact_list.addNewContact("Asher Alexander", "asher@mit.edu", "617-555-2008");


    //contact_list.printList();
    /*************************************************************************/

  } //end: public static void main(String[] args)
} //end: public class MyContacts

