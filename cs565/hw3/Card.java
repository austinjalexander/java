// File: Card.java
// Student: Austin J. Alexander
// Assignment: HW 3.2
// Course: MET CS565 (SPRING 2015)

// *** PLEASE NOTE: AS DIRECTED BY THE INSTRUCTIONS, THIS CODE
// *** DIRECTLY COPIES THE CODE IN THE TEXTBOOK IN NUMEROUS PLACES

public class Card {

  private final String face;
  private final String suit;

  public Card(String card_face, String card_suit) {
    this.face = card_face;
    this.suit = card_suit;
  }

  public String toString() {
    return this.face + " of " + this.suit;
  }

  public String getFace() {
    return this.face;
  }

  public String getSuit() {
    return this.suit;
  }

}