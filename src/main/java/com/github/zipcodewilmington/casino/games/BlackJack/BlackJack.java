package com.github.zipcodewilmington.casino.games.BlackJack;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
//import com.github.zipcodewilmington.casino.Card;
//import com.github.zipcodewilmington.casino.DeckCards;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.DeckCards;
import com.github.zipcodewilmington.utils.IOConsole;
import com.github.zipcodewilmington.utils.*;

import java.util.ArrayList;

public class BlackJack implements GameInterface {

    private final IOConsole console = new IOConsole(AnsiColor.BLUE);
    ArrayList<PlayerInterface> players = new ArrayList<>();
    //DeckCards deck = new DeckCards();
    BlackJackDeck deck = new BlackJackDeck();
    BlackJackPlayer dealer = new BlackJackPlayer(new CasinoAccount("Mills", "FM111123"));

    @Override
    public void Runplay() {

    }

    @Override
    public boolean add(PlayerInterface player) {
        return players.add(player);
    }

    @Override
    public boolean remove(PlayerInterface player) {
        return players.remove(player);
    }

    public Card deal(){
//        return deck.pop();
        return deck.pop();
    }
    @Override
    public void run() {
        console.println("Balance");
        BlackJackPlayer player = (BlackJackPlayer) players.get(0);
        double bet = 0.0;

        do {
            player.printBalance();
            bet = player.placeBets(console.getDoubleInput("How much would you like to bet?: "));
            dealHands(player);
            boolean playAgain = true;

            while (playAgain){
                // checks if anyone is dealt a blackjack from beginning
                if(!checkPlayerCards(player) || !checkPlayerCards(this.dealer)){
                    break;
                }
                // prints out cards in dealer's & player's hands
                printHands(player);
                String input = console.getStringInput("Dealer's hand is: " + dealer.getSumOfCards() + "\nYour current hand is: " + player.getSumOfCards() + "\nWould you like to hit or stand?\n" +
                        "    [ HIT ] , [ STAND ] ");
                if (input.equalsIgnoreCase("hit")) {
                    playAgain = hit(player);
                } else if (input.equalsIgnoreCase("stand")){
                    player.stand();

                    // dealer keeps hitting until it gets to the point where it wins or busts
                    dealerMove();
                    while (!dealer.getStand() && (this.dealer.getSumOfCards() != player.getSumOfCards())) {
                        printHands(player);
                        System.out.println("(stand)Dealer's hand is: " + this.dealer.getSumOfCards() + "\nYour current hand is: " + player.getSumOfCards() + "\n");
                        determineAfterDealerMove(player);
                        dealerMove();
                    }
                    break;
                }

                if(player.getStand() && this.dealer.getStand()){;
                    break;
                }

            }

            printHands(player);
            System.out.println("*** ENDING SCORE *** \nDealer's hand is: " + this.dealer.getSumOfCards() + "\nYour current hand is: " + player.getSumOfCards() + "\n****");

            determineWinner(player, bet);
            clearGame(player);
        }
        while(playAgain("\nWould you like to play again?\n [ YES ], [ NO ]"));


    }

    @Override
    public void play() {

    }

    @Override
    public void nextTurn() {

    }

    @Override
    public Boolean checkGameState() {
        return checkGameState();
    }

    @Override
    public String printGameRules() {
        return printGameRules();
    }

    @Override
    public void exit() {

    }

    @Override
    public boolean quit() {
        return false;
    }

    @Override
    public boolean playAgain(String prompt) {
        return console.getStringInput(prompt).equalsIgnoreCase("yes");
    }

    public void dealHands(BlackJackPlayer player){
        this.dealer.addToHand(deal());
        this.dealer.addToHand(deal());
        player.addToHand(deal());
        player.addToHand(deal());
    }

    public void dealerMove(){
        if(this.dealer.getSumOfCards() < 16){
            this.dealer.addToHand(deal());
        }
        else {
            this.dealer.stand();
        }
    }

    public boolean hit(BlackJackPlayer player){
        player.addToHand(deal());
        boolean playAgain = checkPlayerCards(player);
        if(!dealer.getStand() && playAgain) {
            dealerMove();
            playAgain = determineAfterDealerMove(player);
            return playAgain;
        }
        else if(dealer.getStand() && (player.getSumOfCards() > this.dealer.getSumOfCards())){
            return playAgain;
        }
        return playAgain;
    }

    public boolean checkPlayerCards(BlackJackPlayer player){
        if(player.getSumOfCards() > 21){
            //System.out.println("Dealer's hand is: "+dealer.getSumOfCards()+"\nYour current hand is: " + player.getSumOfCards());
            System.out.println("*** BUST! ***");
            return false;
        }
        else if(player.getSumOfCards() == 21){
            //System.out.println("Dealer's hand is: "+dealer.getSumOfCards()+"\nYour current hand is: " + player.getSumOfCards());
            System.out.println("*** BLACK JACK! ***");
            return false;
        }
        return true;
    }


    public boolean determineAfterDealerMove(BlackJackPlayer player){
        if(this.dealer.getSumOfCards() > 21 && player.getSumOfCards() < 21){
            System.out.println("*** DEALER BUSTED! ***");
            return false;
        }
        else if(this.dealer.getSumOfCards() == 21){
            System.out.println("*** DEALER BLACKJACK! ***");
            return false;
        }

        return true;
    }

    public void determineWinner(BlackJackPlayer player, double bet){
        if((player.getSumOfCards() < this.dealer.getSumOfCards() && this.dealer.getSumOfCards() > 21)){
            System.out.println("YOU WIN!");
            player.getArcadeAccount().setBalance((int) (player.getArcadeAccount().getBalance() + bet));
            // player get winnings
        }
        else if(player.getSumOfCards() > this.dealer.getSumOfCards() && this.dealer.getSumOfCards() < 21 && player.getSumOfCards() <= 21){
            System.out.println("YOU WIN!");
            player.getArcadeAccount().setBalance((int) (player.getArcadeAccount().getBalance() + bet));
        }
        /*else if(player.getSumOfCards() == 21){
            System.out.println("YOU WIN! (winner)");
            player.getArcadeAccount().setBalance(player.getArcadeAccount().getBalance() + (bet * 2));
            // player get winnings
        }*/
        else{
            System.out.println("YOU LOSE!");
            player.getArcadeAccount().setBalance((int) (player.getArcadeAccount().getBalance() - bet));

        }
        player.printBalance();

    }

    public void clearGame(BlackJackPlayer player)
    {
        this.dealer.hand.clear();
        player.hand.clear();
        this.dealer.sumOfCards = 0;
        player.sumOfCards = 0;
        this.dealer.stand = false;
        player.stand = false;
    }

    public void printHands(BlackJackPlayer player){
        System.out.println("*** Dealer's ***");
        this.dealer.printHand();
        System.out.println("*** Player's ***");
        player.printHand();
    }

    public BlackJackPlayer getDealer() {
        return this.dealer;
    }
}