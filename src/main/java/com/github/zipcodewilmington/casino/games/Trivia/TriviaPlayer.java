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
    public Boolean play() {
        Trivia trivia = new Trivia();
        trivia.play();
        return true;
    }
}
