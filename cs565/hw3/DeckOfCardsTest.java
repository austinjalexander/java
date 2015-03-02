// File: DeckOfCardsTest.java
// Student: Austin J. Alexander
// Assignment: HW 2.2
// Course: MET CS565 (SPRING 2015)

public class DeckOfCardsTest {

  public static void main(String[] args) {
    DeckOfCards my_deck_of_cards = new DeckOfCards();
    my_deck_of_cards.shuffle();

    for (int i = 1; i <= 52; i++) {
      System.out.printf("%-19s", my_deck_of_cards.dealCard());

      if (i % 4 == 0) {
        System.out.println();
      }
    }
  }

}