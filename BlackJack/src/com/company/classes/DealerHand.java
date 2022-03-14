package com.company.classes;

public class DealerHand extends Hand {

    public DealerHand(Deck deck) {
        super();
        this.takeCard(deck);
        this.takeDealerCard(deck);
    }

    public void takeDealerCard(Deck deck) {
        if(deck.getSize() == 0) {
            System.out.println("You`ve not taken a card. Deck is empty!");
            throw new ArrayStoreException("Deck was empty!");
        }
        Card cardToAdd = deck.getCard();
        cardToAdd.close();
        cards.add(cardToAdd);
    }

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
        System.out.println(" (" + this.calculate() + ")");
    }
    public void openHand() {
        for ( var card : cards) {
            card.open();
        }
    }

}
