// File: PokerHand.java
// Student: Austin J. Alexander
// Assignment: HW 3.2
// Course: MET CS565 (SPRING 2015)

// *** PLEASE NOTE: THIS CODE ONLY CHECKS FOR 
// *** THE POKER-HAND TYPES LISTED IN THE INSTRUCTIONS 
// *** (e.g., Royal Flush is omitted)

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Arrays;
import java.util.Collections;

public class PokerHand {

  public static void main(String[] args) {

  System.out.println("\n\t\t<=== POKER HAND ===>");

    // create a new deck of cards
    DeckOfCards my_deck_of_cards = new DeckOfCards();
    // shuffle the deck
    my_deck_of_cards.shuffle();

    // create a new hand to hold cards
    ArrayList<Card> new_hand = new ArrayList<>();

    
    System.out.println("\n\t\t<--- HAND DEALT --->");
	// deal to that hand
    new_hand = my_deck_of_cards.dealFiveCardsToAHand(new_hand);

	// create hashtables for the faces and suits in the current hand
    Hashtable<String,Integer> faces = getFacesOrSuits(new_hand, "faces");
    Hashtable<String,Integer> suits = getFacesOrSuits(new_hand, "suits");


    System.out.println("\n\t<------ FACE/SUIT FREQUENCIES ------>");
	// display the frequencies of face/suit occurence in the current hand
    System.out.println("\t" + faces);
    System.out.println("\t" + suits);
    
    // check for pairs and groups ('kinds') of face values 
	// by counting face frequencies
    int num_of_pairs = 0;
    boolean three_of_a_kind = false;
    boolean four_of_a_kind = false;
    // for each face possibility in the deck,
    // check and record impact of face groupings
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

    // check for flush by seeing if one suit has 5 cards
    boolean flush = false;
    for (String suit : my_deck_of_cards.getSuits()) {
      if ( (suits.containsKey(suit)) && (suits.get(suit) == 5) ) {
        flush = true;
      }
    }

    // check for straight by ensuring there are no pairs or other face groups;
    // then get the face values, sort them, and see if the differences of their
    // pairs is 1 in each case (which would suggest a straight);
    // e.g., 9 - 8 == 1, 8 - 7 == 1, 7 - 6 == 1, 6 - 5 == 1, 5 - 4 == 1;
    // also, check the case for 'high-ace'
    boolean straight = false;
    Integer[] face_values = { 0, 0, 0, 0, 0 };

    // make sure there are no groups of faces 
    // (couldn't have a straight that way!)
    if ( (num_of_pairs == 0) && (three_of_a_kind == false) && 
         (four_of_a_kind == false) ) {

      int i = 0;
      // for each face in deck
      for (String face : my_deck_of_cards.getFaces()) {

        // if the face is in the current hand, 
        // get the face-card value
        if (faces.containsKey(face)) {
          face_values[i] = my_deck_of_cards.getFaceValues().get(face);
          i++;
        }
      }

      // sort the face values in descending order
      Arrays.sort(face_values, Collections.reverseOrder());
      // in the case of a possible 'high-ace' straight,
      // determined by whether or not a king (13) is in the array,
      // change the face value of ace, if it is in the array, to 14
      if ( (face_values[0] == 13) && (face_values[4] == 1) ) {
        face_values[4] = 14;
        // resort array
        Arrays.sort(face_values, Collections.reverseOrder());
      }

      // if the difference of each pair of descending-value faces == 1,
      // then a straight exists
      int first_diff = (face_values[0] - face_values[1]);
      int second_diff = (face_values[1] - face_values[2]);
      int third_diff = (face_values[2] - face_values[3]);
      int fourth_diff = (face_values[3] - face_values[4]);
      if ( (first_diff == 1) && (second_diff == 1) && (third_diff == 1) && 
           (fourth_diff == 1) ) {
        straight = true;
      }
    }

    // check for full house
    boolean full_house = false;
    if ( (num_of_pairs == 1) && (three_of_a_kind == true) ) {
      full_house = true;
    }

	// hand types displayed in order given in instructions
    System.out.println("\n\t\t<--- HAND COUNT --->");
    System.out.println("\tNumber of pairs: " + num_of_pairs);
    System.out.println("\tThree of a kind? " + three_of_a_kind);
    System.out.println("\tFour of a kind? " + four_of_a_kind);
    System.out.println("\tFlush? " + flush);
    System.out.println("\tStraight? " + straight);
    System.out.println("\tFull house? " + full_house);

    System.out.println("\n\t\t<====== END ======>\n");

  }

  // create a hash table for faces or suits
  private static Hashtable<String,Integer> getFacesOrSuits(ArrayList<Card> hand, 
                                                           String get) {
    // create a new hash table
    Hashtable<String,Integer> faces_or_suits = new Hashtable<>(); 

    // if faces, scan hand for faces, add those as keys to hash table,
    // and record the count
    if (get == "faces") {
      for (Card card : hand) {
        if (faces_or_suits.containsKey(card.getFace()) == false) {
          faces_or_suits.put(card.getFace(), 1);
        }
        else {
          faces_or_suits.put(card.getFace(), 
          	faces_or_suits.get(card.getFace()) + 1);
        }
      }      
    }

    // if suits, scan hand for suits, add those as keys to hash table,
    // and record the count
    else if (get == "suits") {
      for (Card card : hand) {
        if (faces_or_suits.containsKey(card.getSuit()) == false) {
          faces_or_suits.put(card.getSuit(), 1);
        }
        else {
          faces_or_suits.put(card.getSuit(), 
		  	faces_or_suits.get(card.getSuit()) + 1);
        }
      }
    }

    // return hash table
    return faces_or_suits;
  }

}


