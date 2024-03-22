package com.github.zipcodewilmington;

import com.github.zipcodewilmington.Player;
import com.github.zipcodewilmington.casino.games.HigherCards.HigherCardGame;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class HighestCardTest {

        @Test
        public void testWageMoney() {
            HigherCardGame game = new HigherCardGame();
            game.player1 = new Player("Test Player", 100);


            // Simulate user input


            double bet = game.wageMoney();
            assertEquals(50.0, bet);
        }

//        @Test
//        public void testBadBet() {
//            HigherCardGame game = new HigherCardGame();
//            game.player1 = new Player("Test Player", 100);
//
//            assertTrue(game.badBet(150.0));
//            assertFalse(game.badBet(50.0));
//        }


    }