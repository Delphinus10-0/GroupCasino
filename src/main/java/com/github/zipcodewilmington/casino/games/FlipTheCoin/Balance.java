package com.github.zipcodewilmington.casino.games.FlipTheCoin;

import com.github.zipcodewilmington.casino.Gambler;

public class Balance implements Gambler {
    int amount = 0;

    public Balance(int amount) {
        this.amount = amount;
    }

    public int getBalance() {
        return amount;
    }

    public void withdraw(Integer amountToWithdraw) {
        this.amount -= amountToWithdraw;
    }

    public void deposit(Integer amountToDeposit) {
           this.amount += amountToDeposit;
    }
}
