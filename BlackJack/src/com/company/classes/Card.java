package com.company.classes;

import java.util.Arrays;
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
        String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        if(Arrays.asList(values).contains(aNum)) {
            this.value = aNum;
        } else {
            throw new IllegalArgumentException("Wrong card value!");
        }
        this.isOpened = aStatus;
    }

    public Card(String aSuit, String aNum) {
        this(aSuit, aNum, true);
    }

    public String getValue() {
        if(!isOpened) {
            return "XX";
        } else {
            return value + suitSymbol;
        }
    }

    public String getExactValue() {
        return value;
    }

    public void open() {
        this.isOpened = true;
    }

    public void close() {
        this.isOpened = false;
    }

    public boolean isOpened() {
        return isOpened;
    }
}
