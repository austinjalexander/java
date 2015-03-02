// File: PokerHand.java
// Student: Austin J. Alexander
// Assignment: HW 2.2
// Course: MET CS565 (SPRING 2015)

import java.util.ArrayList;
import java.util.Hashtable;

public class PokerHand {

  public static void main(String[] args) {
    DeckOfCards my_deck_of_cards = new DeckOfCards();
    my_deck_of_cards.shuffle();

    ArrayList<Card> new_hand = new ArrayList<>();

    for (int i = 0; i < 5; i++) {

      new_hand.add(my_deck_of_cards.dealCard());

      System.out.printf("%-19s", new_hand.get(i));

      if ( (i != 0) && (i % 2 == 0) ) {
        System.out.println();
      }
    }

    Hashtable<String,Integer> faces = new Hashtable<>(); 
    Hashtable<String,Integer> suits = new Hashtable<>(); 

    for (Card card : new_hand) {
      if (faces.containsKey(card.getFace()) == false) {
        faces.put(card.getFace(), 1);
      }
      else {
        faces.put(card.getFace(), faces.get(card.getFace()) + 1);
      }
    }

    for (Card card : new_hand) {
      if (suits.containsKey(card.getSuit()) == false) {
        suits.put(card.getSuit(), 1);
      }
      else {
        suits.put(card.getSuit(), suits.get(card.getSuit()) + 1);
      }
    }

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

    System.out.println(num_of_pairs);
    System.out.println(three_of_a_kind);
    System.out.println(four_of_a_kind);



    boolean flush = false;

    for (String suit : my_deck_of_cards.getSuits()) {
      if ( (suits.containsKey(suit)) && (suits.get(suit) == 5) ) {
        flush = true;
      }
    }

    System.out.println(flush);


    boolean straight = false;

////

    System.out.println(straight);


    boolean full_house = false;

    if ( (num_of_pairs == 1) && (three_of_a_kind == true) ) {
      full_house = true;
    }



    


  }

}