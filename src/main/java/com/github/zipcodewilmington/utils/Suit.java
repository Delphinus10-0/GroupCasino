package com.github.zipcodewilmington.utils;

public enum Suit {
    SPADES("\u2660"),
    HEARTS("\u2665"),
    DIAMONDS("\u2666"),
    CLUBS("\u2663");
    private final String suitSymbol;

    Suit(String suitSymbol)
    {
        this.suitSymbol = suitSymbol;
    }

    public String getSuitSymbol()
    {
        return suitSymbol;
    }

}
