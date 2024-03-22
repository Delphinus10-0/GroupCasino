
package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.games.BlackJack.BlackJack;
import com.github.zipcodewilmington.casino.games.BlackJack.BlackJackPlayer;
import org.junit.Assert;
import org.junit.Test;

public class BlackJackTest {
    public BlackJackTest() {
    }

    @Test
    public void testBlackJackInstanceOfGameInterface() {
        BlackJack bj = new BlackJack();
        Assert.assertTrue(bj instanceof GameInterface);
    }

    @Test
    public void testBlackJackConstructor() {
        BlackJack bj = new BlackJack();
        Assert.assertNotNull(bj);
    }

    @Test
    public void testBlackJackAddPlayer() {
        CasinoAccount acc = new CasinoAccount("user", "pass", 100);
        BlackJackPlayer bjPlayer = new BlackJackPlayer(acc);
        BlackJack bj = new BlackJack();
        boolean actual = bj.add(bjPlayer);
        Assert.assertTrue(actual);
    }

    @Test
    public void testBlackJackRemovePlayer() {
        CasinoAccount acc = new CasinoAccount("user", "pass", 100);
        CasinoAccount acc2 = new CasinoAccount("user2", "pass2", 200);
        BlackJackPlayer bjPlayer = new BlackJackPlayer(acc);
        BlackJackPlayer bjPlayer2 = new BlackJackPlayer(acc2);
        BlackJack bj = new BlackJack();
        bj.add(bjPlayer);
        bj.add(bjPlayer2);
        boolean actual = bj.remove(bjPlayer);
        Assert.assertTrue(actual);
    }

    @Test
    public void testBlackJackPlayAgain() {
        new BlackJack();
    }

    @Test
    public void testBlackJackQuit() {
        BlackJack bj = new BlackJack();
        Assert.assertFalse(bj.quit());
    }

    @Test
    public void testDealHands() {
        CasinoAccount acc = new CasinoAccount("user", "pass", 100);
        BlackJackPlayer bjPlayer = new BlackJackPlayer(acc);
        BlackJack bj = new BlackJack();
        bj.add(bjPlayer);
        bj.dealHands(bjPlayer);
        Assert.assertEquals(2L, (long)bjPlayer.getHand().size());
    }

    @Test
    public void testCheckPlayerCards() {
        CasinoAccount acc = new CasinoAccount("user", "pass", 100);
        BlackJackPlayer bjPlayer = new BlackJackPlayer(acc);
        BlackJack bj = new BlackJack();
        bjPlayer.setSumOfCards(21);
        Assert.assertFalse(bj.checkPlayerCards(bjPlayer));
    }

    @Test
    public void testCheckPlayerCards2() {
        CasinoAccount acc = new CasinoAccount("user", "pass", 100);
        BlackJackPlayer bjPlayer = new BlackJackPlayer(acc);
        BlackJack bj = new BlackJack();
        bjPlayer.setSumOfCards(24);
        Assert.assertFalse(bj.checkPlayerCards(bjPlayer));
    }

    @Test
    public void testCheckPlayerCards3() {
        CasinoAccount acc = new CasinoAccount("user", "pass", 100);
        BlackJackPlayer bjPlayer = new BlackJackPlayer(acc);
        BlackJack bj = new BlackJack();
        bjPlayer.setSumOfCards(20);
        Assert.assertTrue(bj.checkPlayerCards(bjPlayer));
    }

    @Test
    public void testDetermineAfterDealerMove() {
        CasinoAccount acc = new CasinoAccount("user", "pass", 100);
        BlackJackPlayer bjPlayer = new BlackJackPlayer(acc);
        BlackJack bj = new BlackJack();
        bj.getDealer().setSumOfCards(24);
        bjPlayer.setSumOfCards(20);
        Assert.assertFalse(bj.determineAfterDealerMove(bjPlayer));
    }

    @Test
    public void testDetermineAfterDealerMove2() {
        CasinoAccount acc = new CasinoAccount("user", "pass", 100);
        BlackJackPlayer bjPlayer = new BlackJackPlayer(acc);
        BlackJack bj = new BlackJack();
        bj.getDealer().setSumOfCards(21);
        bjPlayer.setSumOfCards(20);
        Assert.assertFalse(bj.determineAfterDealerMove(bjPlayer));
    }

    @Test
    public void testDetermineAfterDealerMove3() {
        CasinoAccount acc = new CasinoAccount("user", "pass", 100);
        BlackJackPlayer bjPlayer = new BlackJackPlayer(acc);
        BlackJack bj = new BlackJack();
        bj.getDealer().setSumOfCards(19);
        bjPlayer.setSumOfCards(20);
        Assert.assertTrue(bj.determineAfterDealerMove(bjPlayer));
    }

    @Test
    public void testGetWinner() {
        double bet = 100.0;
        CasinoAccount acc = new CasinoAccount("user", "pass", 100);
        BlackJackPlayer bjPlayer = new BlackJackPlayer(acc);
        BlackJack bj = new BlackJack();
        bj.getDealer().setSumOfCards(24);
        bjPlayer.setSumOfCards(20);
        bj.determineWinner(bjPlayer, bet);
        Assert.assertEquals(200.0, (double)acc.getBalance(), 2.0);
    }

    @Test
    public void testGetWinner2() {
        double bet = 100.0;
        CasinoAccount acc = new CasinoAccount("user", "pass", 100);
        BlackJackPlayer bjPlayer = new BlackJackPlayer(acc);
        BlackJack bj = new BlackJack();
        bj.getDealer().setSumOfCards(19);
        bjPlayer.setSumOfCards(21);
        bj.determineWinner(bjPlayer, bet);
        Assert.assertEquals(200.0, (double)acc.getBalance(), 2.0);
    }

    @Test
    public void testGetWinner3() {
        double bet = 100.0;
        CasinoAccount acc = new CasinoAccount("user", "pass", 100);
        BlackJackPlayer bjPlayer = new BlackJackPlayer(acc);
        BlackJack bj = new BlackJack();
        bj.getDealer().setSumOfCards(18);
        bjPlayer.setSumOfCards(20);
        bj.determineWinner(bjPlayer, bet);
        Assert.assertEquals(200.0, (double)acc.getBalance(), 2.0);
    }

    @Test
    public void testGetWinner4() {
        double bet = 100.0;
        CasinoAccount acc = new CasinoAccount("user", "pass", 100);
        BlackJackPlayer bjPlayer = new BlackJackPlayer(acc);
        BlackJack bj = new BlackJack();
        bj.getDealer().setSumOfCards(19);
        bjPlayer.setSumOfCards(24);
        bj.determineWinner(bjPlayer, bet);
        Assert.assertEquals(0.0, (double)acc.getBalance(), 2.0);
    }

    @Test
    public void testClearGame() {
        CasinoAccount acc = new CasinoAccount("user", "pass", 100);
        BlackJackPlayer bjPlayer = new BlackJackPlayer(acc);
        BlackJack bj = new BlackJack();
        bj.add(bjPlayer);
        bj.dealHands(bjPlayer);
        bj.printHands(bjPlayer);
        bj.clearGame(bjPlayer);
        Assert.assertEquals(0L, (long)bj.getDealer().getHand().size());
        Assert.assertEquals(0L, (long)bjPlayer.getHand().size());
    }

    @Test
    public void testHit() {
        CasinoAccount acc = new CasinoAccount("user", "pass", 100);
        BlackJackPlayer bjPlayer = new BlackJackPlayer(acc);
        BlackJack bj = new BlackJack();
        bj.getDealer().setSumOfCards(20);
        bjPlayer.setSumOfCards(10);
        Assert.assertTrue(bj.hit(bjPlayer));
    }

    @Test
    public void testHit2() {
        CasinoAccount acc = new CasinoAccount("user", "pass", 100);
        BlackJackPlayer bjPlayer = new BlackJackPlayer(acc);
        BlackJack bj = new BlackJack();
        bj.getDealer().stand();
        bj.getDealer().setSumOfCards(20);
        bjPlayer.setSumOfCards(10);
        Assert.assertTrue(bj.hit(bjPlayer));
    }
}
