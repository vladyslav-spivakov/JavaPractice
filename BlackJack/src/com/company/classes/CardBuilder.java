package com.company.classes;

import com.company.classes.Card;

import java.util.Arrays;


public class CardBuilder {
    private String _suit = null;
    private String _value = null;
    private boolean _isOpened = true;

    public CardBuilder() {}

    public Card build() {
        if( _suit == null || _value == null) {
            throw new IllegalArgumentException("Trying to create a Card without value or suit!");
        }
        return new Card(_suit, _value, _isOpened);
    }

    public CardBuilder value(int aValue) {
        return value(Integer.toString(aValue));
    }

    public CardBuilder value(String aValue) {
        String[] values = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J" , "Q" , "K", "A"};
        if(!Arrays.asList(values).contains(aValue)) {
            throw new IllegalArgumentException(aValue.length() == 0 ? "Value can`t be blank!" : "Wrong value: " + aValue);
        }
        this._value = aValue;
        return this;
    }

    public CardBuilder suit(String aSuit) {
        String[] suits = {"diamonds", "clubs", "hearts", "spades"};
        if(!Arrays.asList(suits).contains(aSuit.toLowerCase())) {
            throw new IllegalArgumentException(aSuit.length() == 0 ? "Suit can`t be blank!" : aSuit + " is not a suit");
        }
        this._suit = aSuit;
        return this;
    }

    public CardBuilder closed() {
        this._isOpened = false;
        return this;
    }
}
