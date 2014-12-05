// File: TextMine.java
// Student: Austin J. Alexander
// Assignment: Programming Assignment 3
// Course: MET CS342 (FALL 2014)

import java.io.*;
import java.util.Scanner;

public class TextMine {

  public static void main(String[] args) {

    // BINARY TREE //
    System.out.println("\n*** BINARY TREE ***");
    BinaryTree binary_tree = new BinaryTree();

    // try
    try {
      // using the filename provided by the user,
      // opening a new file, file_input_stream
      String filename = "text.txt";
      File file = new File(filename);
      FileInputStream file_input_stream = new FileInputStream(file);
      Scanner reader = new Scanner(file_input_stream);
      System.out.println("\n\t...reading...\n");

      // loop while text in file
      while (reader.hasNext()) { 
        // get next word
        String new_word = reader.next();
        // strip spaces and non a-z or A-Z characters and lowercasify
        new_word = new_word.trim().replaceAll("[^a-zA-Z]", "").toLowerCase();
        //System.out.println(new_word);
        // add content
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

    String[] search_terms = { "transylvania",
                              "harker",
                              "renfield",
                              "vampire",
                              "exposure",
                              "expostulate" };
    
    for (int i = 0; i < search_terms.length; i++) {
        System.out.println(search_terms[i] + ": " + 
                           binary_tree.searchContent(search_terms[i]));
    }
    


  }
}
