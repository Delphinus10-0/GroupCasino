package com.github.zipcodewilmington.casino.games.HigherCards;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GamblingGame;
import com.github.zipcodewilmington.casino.PlayerInterface;

/**
 * Created by leon on 7/21/2020.
 */
public class HigherCardPlayer implements PlayerInterface, GamblingGame {
    public HigherCardPlayer(CasinoAccount casinoAccount) {
    }

    public HigherCardPlayer() {

    }

    @Override
    public CasinoAccount getArcadeAccount() {
        return null;
    }

    @Override
    public Boolean play() {
        return null;
    }


    @Override
    public Double placeBets(double moneyToBet) {
        return null;
    }
}
