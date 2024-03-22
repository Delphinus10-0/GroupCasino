package com.github.zipcodewilmington.casino.games.HigherCards;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GamblingGame;
import com.github.zipcodewilmington.casino.PlayerInterface;

/**
 * Created by leon on 7/21/2020.
 */
public class HigherCardPlayer implements PlayerInterface, GamblingGame {
    private CasinoAccount casinoAccount;
    private int totalChips;
    private int[] tally; // to keep track of win/loss ratio


    public HigherCardPlayer(CasinoAccount casinoAccount) {
        this.casinoAccount = casinoAccount;
        this.totalChips = casinoAccount.getBalance();

    }

    @Override
    public CasinoAccount getArcadeAccount() {
        return casinoAccount;
    }

    @Override
    public Boolean play() {
        // Player's play logic should be handled by the game class
        return this.play();
    }

    public int getTotalChips() {
        return totalChips;
    }

    public void setTotalChips(int totalChips) {
        this.totalChips = totalChips;
    }

    public int[] getTally() {
        return tally;
    }

    public void setTally(int[] tally) {
        this.tally = tally;
    }

    @Override
    public Double placeBets(double moneyToBet) {
        return moneyToBet;
    }
}
