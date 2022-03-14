package com.company.classes;

import java.util.ArrayList;
import java.util.Arrays;

public class Hand {

    protected ArrayList<Card> cards;

    public Hand() {
        cards = new ArrayList<>();
    }

    public Hand(Deck deck) {
        this();
        this.takeCard(deck);
        this.takeCard(deck);
    }

    public void takeCard(Deck deck) {
        if(deck.getSize() == 0) {
            System.out.println("You`ve not taken a card. Deck is empty!");
            throw new ArrayStoreException("Deck was empty!");
        }

        cards.add(deck.getCard());
    }

    public void showHand() {
        if( cards.size() == 0) {
            System.out.println("Hand has no cards.");
        } else if( cards.size() == 1) {
            System.out.println("Hand holds this card:");
        } else {
            System.out.println("Hand holds these cards:");
        }
        for (int i = 0; i < cards.size(); i++) {
            System.out.print(cards.get(i).getValue() + " ");
        }
        System.out.println(" (" + this.calculate() + ")");

    }

    public int calculate() {
        int numOfAces = 0; // num of Aces with price 11
        int sum = 0;
        int i = 0;
        String[] values1 = {"2", "3", "4", "5", "6", "7", "8", "9", "10"};
        String[] values2 = {"J" , "Q" , "K"};
        for(var card : cards) {
            if( !card.isOpened()) {
                continue;
            }
            String value = card.getExactValue();
            if(Arrays.asList(values1).contains(value)) {
                sum += Integer.parseInt(value);
            } else if(Arrays.asList(values2).contains(value)){
                sum += 10;
            } else if( value.equals("A")) {
                numOfAces++;
            }
        }
        if(numOfAces == 0) {
            return sum;
        }
        return (sum + numOfAces + 10 > 21) ? sum + numOfAces : sum + numOfAces + 10;
    }

}
