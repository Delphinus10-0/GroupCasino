package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.games.BlackJack.BlackJack;
import com.github.zipcodewilmington.casino.games.HigherCards.HigherCardGame;
import com.github.zipcodewilmington.casino.games.HigherCards.HigherCardPlayer;
import com.github.zipcodewilmington.utils.Card;
import com.github.zipcodewilmington.utils.IOConsole;
import com.github.zipcodewilmington.utils.Rank;
import com.github.zipcodewilmington.utils.Suit;
import org.junit.Assert;
import org.junit.Test;

import java.util.Optional;

import static org.junit.Assert.*;

public class HigherCardTest {
    @Test
    public void testHigherCardInstanceOfGameInterface() {
        HigherCardGame highestCard= new HigherCardGame();
        assertTrue(highestCard instanceof GameInterface);
    }
    @Test
    public void testHigherCardConstructor() {
        HigherCardGame highestCard= new HigherCardGame();
        Assert.assertNotNull(highestCard);
    }
    //HigherCard

    @Test
    public void testHigherCardAddPlayer() {
        CasinoAccount casinoAccount = new CasinoAccount("user", "pass", 100);
        HigherCardPlayer highestCardPlayer= new HigherCardPlayer(casinoAccount);
        HigherCardGame highestCard= new HigherCardGame();
        boolean actual = highestCard.add(highestCardPlayer);
        assertTrue(actual);
    }
    @Test
    public void testHigherCardRemovePlayer() {
        CasinoAccount acc = new CasinoAccount("user", "pass", 100);
        CasinoAccount acc2 = new CasinoAccount("user2", "pass2", 200);
        HigherCardPlayer hcPlayer1 = new HigherCardPlayer(acc);
        HigherCardPlayer hcPlayer2 = new HigherCardPlayer(acc2);
        HigherCardGame higherCard = new HigherCardGame();
        higherCard.add(hcPlayer1);
        higherCard.add(hcPlayer2);
        boolean actual = higherCard.remove(hcPlayer1);
        assertFalse(actual);
    }
    @Test
    public void testHigherCardPlayAgain() {
        new HigherCardGame();
    }
    @Test
    public void testHigherCardQuit() {
        HigherCardGame higherCardGame = new HigherCardGame();
        assertFalse(higherCardGame.quit());
    }
    @Test
    public void testPlayerWins() {
        HigherCardGame game = new HigherCardGame();
        game.player1 = new Player("PlayerName", 100); // Initialize player1
        // Manually set up the deck for player win scenario
        game.deck.getDeck().clear(); // Clear the existing deck
        game.deck.getDeck().add(new Card(Rank.ACE, Suit.HEARTS)); // Player's card
        game.deck.getDeck().add(new Card(Rank.KING, Suit.CLUBS)); // House's card
        game.bet = 50.0;
        game.findWinner(game.bet, 14, 13); // Player has ACE (value 14), house has KING (value 13)
        assertEquals(150, (long)game.player1.getTotalChips());
    }
    @Test
    public void testPlayerLoses() {
        HigherCardGame game = new HigherCardGame();
        game.player1 = new Player("PlayerName", 100);
        // Manually adjust the deck to represent a scenario where the player loses
        game.deck.getDeck().clear(); // Clear the existing deck
        game.deck.getDeck().add(new Card(Rank.NINE, Suit.HEARTS)); // Player's card
        game.deck.getDeck().add(new Card(Rank.TEN, Suit.CLUBS)); // House's card
        game.player1.setTotalChips(100);
        game.bet = 50.0;
        game.findWinner(game.bet, 9, 10); // Player has NINE (value 9), house has TEN (value 10)
        assertEquals(50, (long)game.player1.getTotalChips());
    }
    @Test
    public void testTie() {
        HigherCardGame game = new HigherCardGame();
        game.player1 = new Player("PlayerName", 100);
        game.deck.getDeck().add(new Card(Rank.TEN, Suit.HEARTS)); // Player's card
        game.deck.getDeck().add(new Card(Rank.TEN, Suit.CLUBS)); // House's card
        game.player1.setTotalChips(100);
        game.bet = 50.0;
        game.findWinner(game.bet, 10, 10); // Player and house both have TEN (value 10)
        assertEquals(50, (long)game.player1.getTotalChips());
    }
    @Test
    public void testValidBet() {
        HigherCardGame game = new HigherCardGame();
        game.player1 = new Player("PlayerName", 100); // Initialize player1 with name "PlayerName" and 100 chips
        boolean result = !game.badBet();
        assertFalse(result);
    }
//    @Test
//    public void testPlayAgainNo() {
//        HigherCardGame game = new HigherCardGame();
//        game.player1 = new Player("PlayerName", 100); // Initialize player1 with name "PlayerName" and 100 chips
//        game.console = new IOConsole(); // Initialize console
//        // Player chooses not to play again
//        game.console.getStringInput("no");
//        game.repeat();
//        assertFalse(game.playAgain);
//    }

//    @Test
//    public void testPlayAgainYes() {
//        HigherCardGame game = new HigherCardGame();
//        game.player1 = new Player("PlayerName", 100);
//        // Set player's total chips
//        game.player1.setTotalChips(100);
//        // Player chooses to play again
//        game.console.getStringInput("yes");
//        game.repeat();
//        assertTrue(game.playAgain);
//    }

}