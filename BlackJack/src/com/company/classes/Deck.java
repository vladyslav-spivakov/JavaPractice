package com.company.classes;

import com.company.classes.Card;

import java.util.Collections;
import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> deck;

    public void addCard(Card newCard) {
        deck.add(newCard);
    }

    public Deck(int num) {
        String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J" , "Q" , "K", "A"};
        String[] suits = {"diamonds", "clubs", "hearts", "spades"};
        this.deck = new ArrayList<>();
        for( var val : values) {
            for( var suit : suits) {
                for(int i = 0; i < num; i++) {
                    this.addCard(new CardBuilder().suit(suit).value(val).build());
                }
            }
        }
    }

    private void printDeck() {
        System.out.print("Deck: ");
        for( var card : deck) {
            System.out.print(card.getValue() + ", ");
        }
        System.out.println();
    }

    public void shuffle() {
        Collections.shuffle(this.deck);
    }

    public int getSize() {
        return deck.size();
    }

    public Card getCard() {
        if( deck.size() == 0) {
            throw new ArrayStoreException("Trying to pick a card from an empty deck.");
        }
        return deck.remove(0);
    }

}
