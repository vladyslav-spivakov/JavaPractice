package com.company;
import com.company.classes.CardBuilder;  // Importing class Card
import com.company.classes.Card;
import com.company.classes.Deck;

public class Main {

    public static void main(String[] args) {
        Card c = new CardBuilder().suit("Diamonds").value(6).build();
        Deck deck = new Deck(3);
        deck.shuffle();
        deck.printDeck();
        System.out.println(deck.getCard().getValue());
        deck.printDeck();
    }
}
