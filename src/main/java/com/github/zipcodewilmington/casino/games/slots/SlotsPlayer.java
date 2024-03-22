package com.github.zipcodewilmington.casino.games.slots;
import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.Gambler;
import com.github.zipcodewilmington.casino.GamblingGame;
import com.github.zipcodewilmington.casino.PlayerInterface;
/**
 * Created by leon on 7/21/2020.
 */
public class SlotsPlayer  implements PlayerInterface, GamblingGame {
    private  int totalChips;
    private CasinoAccount casinoAccount;

    public SlotsPlayer(CasinoAccount casinoAccount) {
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


    @Override
    public Double placeBets(double moneyToBet) {
        return moneyToBet;
    }
}