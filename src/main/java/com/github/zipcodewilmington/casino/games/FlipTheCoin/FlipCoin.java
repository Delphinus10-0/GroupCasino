package com.github.zipcodewilmington.casino.games.FlipTheCoin;


import com.github.zipcodewilmington.utils.Suit;

import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class FlipCoin {
    CoinSide selectedCoinSide;
    CoinSide winningSide = CoinSide.HEAD;
    int bet = 1;
    Balance balance = new Balance(0);
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] arg){
        new FlipCoin().playGame();
    }

    public void playGame() {
        System.out.println("Welcome to the FlipCoin Game! Please flip the coin and may the luck be with you!");
        boolean isYesAnswer;
        int value;

        try {
            //Set balance, calling the yesOrNo method to receive user input Y/N.If yes the user is asked to enter a deposit.
            isYesAnswer = yesOrNo("Your balance is " + balance.getBalance() + ". Would you like to add additional amount");
            if (isYesAnswer) {
                System.out.println("Enter your amount:");
                value = scanner.nextInt();
                balance.deposit(value);
            }

            //check balance.If 0 show the message and exit the game using a if statement.
            if(balance.getBalance() > 0) {

                while (true) {
                    // ask the user if they want to change the bet, and set the bet.
                    isYesAnswer = yesOrNo("The bet is " + getBet() + ". Would you like to change it");
                    if (isYesAnswer){
                        System.out.println("Enter your amount:");
                        value = scanner.nextInt();
                        setBet(value);
                    }

                    //ask the user to pick a coin side.
                    String coinSide = "";
                    while (true){
                        System.out.println("Please pick a coin side: HEAD or TAIL?");
                        coinSide = scanner.next();
                        if(coinSide.equals("HEAD")) {
                            this.selectedCoinSide = CoinSide.HEAD;
                            break;
                        }

                        if(coinSide.equals("TAIL")) {
                            this.selectedCoinSide = CoinSide.TAIL;
                            break;
                        }
                    }
                    System.out.println("You picked " + coinSide);

                    //flip the coin.
                    String result = flipTheCoin();
                    System.out.println("The drawn coin side is " + result);

                    //determine if the player wins.
                    Boolean isWinner = this.checkForWin();
                    if(isWinner){
                        System.out.println("Congratulations you win!");
                        balance.deposit(this.getBet());
                    }
                    else {
                        System.out.println("I am sorry, you lost!");
                        balance.deposit(-1 * this.getBet());

                        //update balance.If balance is 0 the player exit the game,
                        if(balance.getBalance() <= 0){
                            System.out.println("Sorry you ran out of money!");
                            break;
                        }
                    }
                    //Ask the user if they want to play again.
                    isYesAnswer = yesOrNo("Would you like to play again");
                    if (!isYesAnswer) {
                        break;
                    }
                }
            }
            else{
                System.out.println("I am sorry, you do not have enough money!");
            }
        }
        catch(Exception e){
            System.out.println("You entered invalid input!");
        }
          //display exit message.
        System.out.println("Thank you for playing Flip The Coin game!");
    }


    //This is method for yes or no answers from the user.
    //It uses infinite loop until it receives the right answer.
    private boolean yesOrNo(String message){
        String answer = "";
        while (true){
            System.out.println(message + "(Y/N)?");
            answer = scanner.next();
            if(answer.equals("Y"))
                return true;

            if(answer.equals("N"))
                return false;
        }

    }



    public int getBet() {
        return bet;
    }

    public void setBet(int amount) {
        if (amount > 0) {
            bet = amount;
        }
    }


    public String flipTheCoin() {
        CoinSide[] values = CoinSide.values();
        this.winningSide = values[new Random().nextInt(values.length)];
        return String.valueOf(this.winningSide);
    }

    public boolean checkForWin() {
        return selectedCoinSide.equals(winningSide);
    }

    public void setCoinSide(CoinSide coinSide) {
        this.selectedCoinSide = coinSide;
    }

    public CoinSide getCoinSide(){
        return CoinSide.TAIL;
    }
}
