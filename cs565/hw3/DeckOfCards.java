// File: DeckOfCards.java
// Student: Austin J. Alexander
// Assignment: HW 2.2
// Course: MET CS565 (SPRING 2015)

import java.security.SecureRandom;

public class DeckOfCards {

  private Card[] deck;
  private int current_card;
  private static final int NUMBER_OF_CARDS = 52;

  private static final SecureRandom random_numbers = new SecureRandom();

  public DeckOfCards() {
    String[] faces = {"Ace", "Deuce", "Three", "Four", "Five", "Six",
                      "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King"};
    String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};

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

}