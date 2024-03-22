package com.github.zipcodewilmington.casino.games.FlipTheCoin;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;

public class FlipCoinPlayer implements PlayerInterface {

    private CasinoAccount arcadeAccount;

    FlipCoinPlayer(CasinoAccount arcadeAccount){
        this.arcadeAccount = arcadeAccount;
    }

    @Override
    public CasinoAccount getArcadeAccount() {
        return arcadeAccount;
    }

   @Override
   public Boolean play() {
        return true;
    }

//    @Override
//    public <SomeReturnType> SomeReturnType play() {
//        FlipCoin flipCoin = new FlipCoin();
//        flipCoin.playGame();
//        return null;
//    }
}
