// File: Card.java
// Student: Austin J. Alexander
// Assignment: HW 2.2
// Course: MET CS565 (SPRING 2015)

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