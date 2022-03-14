package com.company.classes;

import java.util.Locale;

public class Card {
    private String value;
    private String suit;
    private String suitSymbol;
    private boolean isOpened;

    public Card(String aSuit, String aNum, boolean aStatus) {
        switch(aSuit.toLowerCase()) {
            case "diamonds" -> this.suitSymbol = "♦";
            case "spades" -> this.suitSymbol = "♠";
            case "clubs" -> this.suitSymbol = "♣";
            case "hearts" -> this.suitSymbol = "♥";
            default -> throw new IllegalArgumentException(aSuit.length() == 0 ? "Suit can`t be blank!" : aSuit + " is not a suit");
        }
        this.suit = aSuit;
        this.value = aNum;
        this.isOpened = aStatus;
    }

    public String getValue() {
        if(!isOpened) {
            return "XX";
        } else {
            return value + suitSymbol;
        }
    }

    public void open() {
        this.isOpened = true;
    }

    public void close() {
        this.isOpened = false;
    }
}
