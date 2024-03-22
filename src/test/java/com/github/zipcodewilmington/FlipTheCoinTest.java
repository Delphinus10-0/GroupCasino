package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.games.FlipTheCoin.CoinSide;
import com.github.zipcodewilmington.casino.games.FlipTheCoin.FlipCoin;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class FlipTheCoinTest {
///+ playGame(): void
//+ getBet(): int
//+ setBet(amount: int): void
// + setCoinSide(side:CoinSide: String)
//   + flipCoin(): String
//+ checkForWin(): boolean
    @Test

    public void getBetTest(){
      FlipCoin flipTheCoin = new FlipCoin();
     int expected = 0;
     int actual = flipTheCoin.getBet();
     assertEquals(expected, actual, 0);
    }

    @Test

    public void setBetTest() {
        FlipCoin flipTheCoin = new FlipCoin();
        int expected = 1;
        flipTheCoin.setBet(1);
        int actual = flipTheCoin.getBet();
        assertEquals(expected, actual);

    }

    @Test

    public void setCoinSideTest() {
        FlipCoin flipTheCoin = new FlipCoin();
        CoinSide expected = CoinSide.TAIL;
        flipTheCoin.setCoinSide(expected);
        CoinSide actual = flipTheCoin.getCoinSide();
        assertEquals(expected, actual);
    }

//    @Test

//    public void flipCoinsTest() {
//        FlipCoin flipTheCoin = new FlipCoin();
//        String expected = "TAIL";
//        String actual = flipTheCoin.flipTheCoin();
//        assertEquals(expected, actual);
//
//
//    }

    @Test

    public void checkForWinTest() {
        FlipCoin flipTheCoin = new FlipCoin();
        flipTheCoin.setCoinSide(CoinSide.HEAD);
        boolean actual = flipTheCoin.checkForWin();
        assertTrue(actual);
    }
}
