package com.github.zipcodewilmington.casino.games.slots;
import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.Gambler;
import com.github.zipcodewilmington.casino.PlayerInterface;
/**
 * Created by leon on 7/21/2020.
 */
public class SlotsPlayer  implements PlayerInterface, Gambler {
    @Override
    public CasinoAccount getArcadeAccount() {
        return null;
    }
    @Override
    public Boolean play() {
        return null;
    }

    @Override
    public void withdraw(Integer amount) {
    }
    @Override
    public void deposit(Integer amount) {
    }
}