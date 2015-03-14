// File: DeckOfCards.java
// Student: Austin J. Alexander
// Assignment: HW 3.2
// Course: MET CS565 (SPRING 2015)

// *** PLEASE NOTE: AS DIRECTED BY THE INSTRUCTIONS, THIS CODE
// *** DIRECTLY COPIES THE CODE IN THE TEXTBOOK IN NUMEROUS PLACES

import java.util.ArrayList;
import java.security.SecureRandom;
import java.util.Hashtable;

public class DeckOfCards {

  private Card[] deck;
  private int current_card;
  private static final String[] faces = {"Ace", "Deuce", "Three", "Four", "Five", "Six",
                    "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
  private static final String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
  private static final int NUMBER_OF_CARDS = 52;

  private static final SecureRandom random_numbers = new SecureRandom();

  public DeckOfCards() {

    deck = new Card[NUMBER_OF_CARDS];
    current_card = 0;

    for (int count = 0; count < deck.length; count++) {
      deck[count] = new Card(faces[count % 13], suits[count / 13]);
    }
  }

  public void shuffle() {
    current_card = 0;

    for (int first = 0; first < deck.length; first++) {
      int second = random_numbers.nextInt(NUMBER_OF_CARDS);

      Card temp = deck[first];
      deck[first] = deck[second];
      deck[second] = temp;
    }
  }

  public Card dealCard() {
    if (current_card < deck.length) {
      return deck[current_card++];
    }
    else {
      return null;
    }
  }

  public ArrayList<Card> dealFiveCardsToAHand(ArrayList<Card> hand) {
    for (int i = 0; i < 5; i++) {

      hand.add(this.dealCard());

      System.out.printf("%-19s", hand.get(i));

      if ( (i != 0) && (i % 2 == 0) ) {
        System.out.println();
      }
    }

    return hand;
  }

  public String[] getFaces() {
    return this.faces;
  }

  public String[] getSuits() {
    return this.suits;
  }

  public Hashtable<String,Integer> getFaceValues() {
    // create a hashtable
    Hashtable<String,Integer> face_values = new Hashtable<>();

    // give a value
    int value = 1;
    for (String face : this.getFaces()) {
      face_values.put(face, value);
      value++;
    }

    return face_values;
  }

}