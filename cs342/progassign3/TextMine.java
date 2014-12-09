// File: TextMine.java
// Student: Austin J. Alexander
// Assignment: Programming Assignment 3
// Course: MET CS342 (FALL 2014)

import java.io.*;
import java.util.Scanner;

public class TextMine {

  public static void main(String[] args) {

    // BINARY TREE //
    System.out.println("\n< < < * * * TeXt MiNe * * * > > >");
    BinaryTree binary_tree = new BinaryTree();
//*
    // try
    try {
      // using the filename provided by the user,
      // opening a new file, file_input_stream, and scanner
      String filename = "text.txt";
      File file = new File(filename);
      FileInputStream file_input_stream = new FileInputStream(file);
      Scanner reader = new Scanner(file_input_stream);
      System.out.println("\n...reading...\n");

      // loop while text in file
      while (reader.hasNext()) { 
        // get next word
        String new_word = reader.next();
        // strip spaces and non a-z or A-Z characters and lowercasify
        new_word = new_word.trim().replaceAll("[^a-zA-Z]", "").toLowerCase();
        
        // display new_word (for testing)
        //System.out.println(new_word);
        
        // add content to tree
        binary_tree.addContent(new_word);
      }   

      // close file_input_stream
      file_input_stream.close();
    }
    // catch any file/input issues and let the user know
    catch (Exception e) {
      System.out.println("\n\tSomething might be wrong with the file!");
      //System.out.println(e);
    }

    // search for specfic term frequencies
    String[] search_terms = { "transylvania",
                              "harker",
                              "renfield",
                              "vampire",
                              "expostulate" };
    
    // for the length of the search terms array, loop
    for (int i = 0; i < search_terms.length; i++) {
        // print out the search term and its frequency
        System.out.println("\t" + search_terms[i] + " occurs: " + 
                           binary_tree.searchContent(search_terms[i]) +
                           " time(s)");
    }

    // display stats
    binary_tree.displayStats();

//*/
  

// TESTERS
/*
    binary_tree.displayStats();

    binary_tree.addContent("t");
    binary_tree.addContent("g");
    binary_tree.addContent("a");
    binary_tree.addContent("c");
    binary_tree.addContent("v");
    binary_tree.addContent("u");
    binary_tree.addContent("u");  //test most frequent
    binary_tree.addContent("x");
    binary_tree.addContent("w");
    binary_tree.addContent("z");

    binary_tree.displayStats();
//*/

    System.out.println("\n> > > * * * fin * * * < < <\n\n");

  }
}
