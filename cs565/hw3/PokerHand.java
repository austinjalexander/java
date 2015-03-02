// File: PokerHand.java
// Student: Austin J. Alexander
// Assignment: HW 2.2
// Course: MET CS565 (SPRING 2015)

import java.util.ArrayList;

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



    int[] num_of_face_matches = { 0, 0, 0, 0, 0 };

    for (int i = 0; i < 5; i++) {
      new_hand.
    }


  }

}