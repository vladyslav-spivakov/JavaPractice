package com.company.classes;

public class DealerHand extends Hand {
    @Override
    public void showHand() {
        if( cards.size() == 0) {
            System.out.println("Dealer has no cards.");
        } else if( cards.size() == 1) {
            System.out.println("Dealer holds this card:");
        } else {
            System.out.println("Dealer holds these cards:");
        }
        for (int i = 0; i < cards.size(); i++) {
            System.out.print(cards.get(i).getValue() + " ");
        }
        System.out.println();
    }
    public void openHand() {
        for ( var card : cards) {
            card.open();
        }
    }

}
