package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.games.HigherCards.HigherCardGame;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class HigherCardTest {
    Player player1 = new Player("Ann", 2000, 21);
    HigherCardGame higherCardGame = new HigherCardGame(player1);

    @Test
    public void findWinnerTest(){
        int expected = 2500;
        higherCardGame.findWinner(500.0,10,21);
        int actual = player1.getTotalChips();
        Assert.assertEquals(actual, expected);
    }
//    @Test
//    public void badBetTest(){
//        higherCardGame.setBet(-10);
//        assertTrue(higherCardGame.badBet());
//    }
}
