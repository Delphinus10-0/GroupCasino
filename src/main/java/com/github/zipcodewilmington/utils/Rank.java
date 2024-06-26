package com.github.zipcodewilmington.utils;

public enum Rank {
    //enum
    ACE(14,"A"),
    KING(13,"K"),
    QUEEN(12, "Q"),
    JACK(11, "J"),
    TEN(10, "T"),
    NINE(9,"9"),
    EIGHT(8, "8"),
    SEVEN(7, "7"),
    SIX(6, "6"),
    FIVE(5, "5"),
    FOUR(4, "4"),
    THREE(3, "3"),
    TWO(2, "2");

    private int value;
    private String faceValue;

    Rank(int value, String faceValue) {
        this.value = value;
        this.faceValue = faceValue;
    }

    public int getValue() {
        return value;
    }

    public String getFaceValue() {
        return faceValue;
    }

    public int getCardValue()
    {
        return value;
    }
}
