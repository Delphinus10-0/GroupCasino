//package com.github.zipcodewilmington.casino.games.Trivia;
//
//import com.github.zipcodewilmington.casino.PlayerInterface;
//import com.github.zipcodewilmington.casino.CasinoAccount;
//import com.github.zipcodewilmington.casino.games.Trivia.Trivia;

//public class TriviaPlayer implements PlayerInterface {
//    private final int totalChips;
//    private CasinoAccount casinoAccount;
//
//    public TriviaPlayer(CasinoAccount casinoAccount) {
//        this.casinoAccount = casinoAccount;
//        this.totalChips = casinoAccount.getBalance();
//
//    }
//
//    @Override
//    public CasinoAccount getArcadeAccount() {
//        return casinoAccount;
//    }
//
//    @Override
//    public Boolean play() {
//        return this.play();
//    }
//    @Override
//    public Double placeBets(double moneyToBet) {
//        return moneyToBet;
//    }
//}
package com.github.zipcodewilmington.casino.games.Trivia;

import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.games.Trivia.Trivia;

public class TriviaPlayer implements PlayerInterface {
    private CasinoAccount arcadeAccount;

    public TriviaPlayer(CasinoAccount arcadeAccount) {
        this.arcadeAccount = arcadeAccount;
    }

    @Override
    public CasinoAccount getArcadeAccount() {
        return arcadeAccount;
    }

    @Override
    public Double placeBets(double moneyToBet) {
        return null;
    }

    @Override
    public Boolean play() {
        Trivia trivia = new Trivia();
        trivia.play();
        return true;
    }


}
