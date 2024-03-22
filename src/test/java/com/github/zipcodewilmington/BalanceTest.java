package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.games.FlipTheCoin.Balance;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


//+withdraw(Integer): int +deposit(Integer): int

public class BalanceTest {

      @Test
      public void getBalanceTest(){
         int expected = 100;
         Balance bal = new Balance(expected);
         int actual = bal.getBalance();
         assertEquals(expected, actual);
      }

    @Test
    public void withdrawTest() {
       Balance bal = new Balance(100);
       bal.withdraw(30);
       int expected = 70;
       int actual = bal.getBalance();
       assertEquals(expected, actual);
   }

   @Test
   public void depositTest() {
      Balance bal = new Balance(100);
      bal.deposit(50);
      int expected = 150;
      int actual = bal.getBalance();
      assertEquals(expected, actual);
   }
}
