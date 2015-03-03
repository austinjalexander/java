// File: PokerHand.java
// Student: Austin J. Alexander
// Assignment: HW 2.2
// Course: MET CS565 (SPRING 2015)

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Arrays;
import java.util.Collections;

public class PokerHand {

  public static void main(String[] args) {

  System.out.println("\n\t\t<=== POKER HAND ===>");

    DeckOfCards my_deck_of_cards = new DeckOfCards();
    my_deck_of_cards.shuffle();

    ArrayList<Card> new_hand = new ArrayList<>();

    System.out.println("\n\t\t<--- HAND DEALT --->");

    for (int i = 0; i < 5; i++) {

      new_hand.add(my_deck_of_cards.dealCard());

      System.out.printf("%-19s", new_hand.get(i));

      if ( (i != 0) && (i % 2 == 0) ) {
        System.out.println();
      }
    }

    Hashtable<String,Integer> faces = new Hashtable<>(); 

    for (Card card : new_hand) {
      if (faces.containsKey(card.getFace()) == false) {
        faces.put(card.getFace(), 1);
      }
      else {
        faces.put(card.getFace(), faces.get(card.getFace()) + 1);
      }
    }

    Hashtable<String,Integer> suits = new Hashtable<>(); 

    for (Card card : new_hand) {
      if (suits.containsKey(card.getSuit()) == false) {
        suits.put(card.getSuit(), 1);
      }
      else {
        suits.put(card.getSuit(), suits.get(card.getSuit()) + 1);
      }
    }

    System.out.println("\n\t<------ FACE/SUIT FREQUENCIES ------>");
    System.out.println(faces);
    System.out.println(suits);
    
    int num_of_pairs = 0;
    boolean three_of_a_kind = false;
    boolean four_of_a_kind = false;

    for (String face : my_deck_of_cards.getFaces()) {
      if ( (faces.containsKey(face)) && (faces.get(face) == 2) ) {
        num_of_pairs++;
      }

      if ( (faces.containsKey(face)) && (faces.get(face) == 3) ) {
        three_of_a_kind = true;
      }

      if ( (faces.containsKey(face)) && (faces.get(face) == 4) ) {
        four_of_a_kind = true;
      }
    }

    System.out.println("\n\t\t<--- HAND COUNT --->");
    System.out.println("Number of pairs: " + num_of_pairs);
    System.out.println("Three of a kind? " + three_of_a_kind);
    System.out.println("Four of a kind? " + four_of_a_kind);


    boolean flush = false;

    for (String suit : my_deck_of_cards.getSuits()) {
      if ( (suits.containsKey(suit)) && (suits.get(suit) == 5) ) {
        flush = true;
      }
    }

    System.out.println("Flush? " + flush);


    boolean straight = false;
    Hashtable<String,Integer> face_values = new Hashtable<>();

    if ( (num_of_pairs == 0) && (three_of_a_kind == false) && 
         (four_of_a_kind == false) ) {

      int value = 1;
      for (String face : my_deck_of_cards.getFaces()) {
        if (face_values.containsKey(face) == false) {
          face_values.put(face, value);
        }
        value++;
      }
    }

    System.out.println(face_values);

    Integer[] straight_check = { 5, 3, 7, 14, 1 };

    Arrays.sort(straight_check, Collections.reverseOrder());

    int first_diff = (straight_check[0] - straight_check[1]);
    int second_diff = (straight_check[1] - straight_check[2]);
    int third_diff = (straight_check[2] - straight_check[3]);
    int fourth_diff = (straight_check[3] - straight_check[4]);

    if ( (first_diff == 1) && (second_diff == 1) && (third_diff == 1) && 
         (fourth_diff == 1) ) {
      straight = true;
    }
    

    System.out.println("Straight? " + straight);


    boolean full_house = false;

    if ( (num_of_pairs == 1) && (three_of_a_kind == true) ) {
      full_house = true;
    }

    System.out.println("Full house? " + full_house);

    System.out.println("\n\t\t<====== END ======>");

  }

}




