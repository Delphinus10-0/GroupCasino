package com.github.zipcodewilmington;

public class Player {
    String name;
    Integer totalChips;

    public Player(String name, Integer totalChips) {
        this.name = name;
        this.totalChips = totalChips;
    }

    public Player(String aName) {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getTotalChips() {
        return totalChips;
    }

    public void setTotalChips(Integer totalChips) {
        this.totalChips = totalChips;
    }

    public void deposit(int winnings) {
    }

    public Integer getBalance()
    {
        return null;
    }

    public void withdraw(Integer wager) {
    }
}
