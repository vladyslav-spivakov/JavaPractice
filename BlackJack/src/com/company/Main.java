package com.company;
import com.company.classes.CardBuilder;  // Importing class Card
import com.company.classes.Card;
import com.company.classes.Deck;
import com.company.classes.Hand;

public class Main {

    public static void main(String[] args) {
        Card c = new CardBuilder().suit("Diamonds").value(6).build();
        Deck deck = new Deck(3);
        deck.shuffle();
        deck.printDeck();
        Hand pl = new Hand();
        pl.takeCard(deck);
        pl.showHand();
        pl.takeCard(deck);
        pl.showHand();
        pl.takeCard(deck);
        pl.showHand();
    }
}
