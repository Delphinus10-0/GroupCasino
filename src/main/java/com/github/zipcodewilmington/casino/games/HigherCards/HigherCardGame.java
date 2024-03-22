package com.github.zipcodewilmington.casino.games.HigherCards;

/**
 * Created by leon on 7/21/2020.
 */
import com.github.zipcodewilmington.Player;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.utils.*;

public class HigherCardGame extends CardGame implements GameInterface {

    IOConsole console = new IOConsole();
    DeckCards deck = new DeckCards();
    Player player1;
    boolean playAgain = true;
    int player, croupier;
    private Double bet;

    public HigherCardGame(Player player) {
        super(player);
    }

    @Override
    public boolean add(PlayerInterface player) {
        return false;
    }

    @Override
    public boolean remove(PlayerInterface player) {
        return false;
    }

    @Override
    public void run() {

    }

    @Override
    public void play() {
        console.print("Welcome to HigherCardGame!\nWe both will draw a card, and the higher card wins the wager.\nThe House wins on ties\n");

        while (playAgain) {
            deck.shuffle();
            Double wageAmount = wageMoney();
            console.println("You Got :");
            playerDrawingCard();
            console.println("House Got :");
            houseDrawingCard();

            findWinner(wageAmount, player, croupier);
            console.println("Your current available Chips: " + player1.getTotalChips());
            repeat();
        }
    }

    public void repeat() {
        if(player1.getTotalChips() == 0) {
            console.println("You are out of chips. You may no longer play\n");
            playAgain = false;
        } else if(console.getStringInput("Would you like to play again?").equalsIgnoreCase("no")) {
            playAgain = false;
        }
    }

    public void playerDrawingCard() {
        Card acard = deck.draw();
        Rank rank = acard.getRank();
        player = rank.getValue();
        Suit suit = acard.getSuit();
        printCard(suit.getSuitSymbol(), rank.getFaceValue());
    }

    public void houseDrawingCard() {
        Card acard2 = deck.draw();
        Rank rank2 = acard2.getRank();
        croupier = rank2.getValue();
        Suit suit2 = acard2.getSuit();
        printCard(suit2.getSuitSymbol(), rank2.getFaceValue());
    }

    public void findWinner(Double wageAmount, int playerCardValue, int croupierCardValue) {
        if (playerCardValue > croupierCardValue) {
            console.println("Congrats! You Won");
            int[] change = {player1.getTally()[0] + 1, player1.getTally()[1]};
            player1.setTally(change);
            player1.setTotalChips((int) (player1.getTotalChips() + wageAmount));
        } else {
            console.println("You Lose");
            int[] change = {player1.getTally()[0], player1.getTally()[1] + 1};
            player1.setTally(change);
            player1.setTotalChips((int) (player1.getTotalChips() - wageAmount));
        }
        console.println("Your current Win/Loss Ratio is " + player1.getTally()[0] + "/" +
                player1.getTally()[1] + "\n");
    }

    public Double wageMoney() {
        do {
            bet = console.getDoubleInput("How much would you like to bet? You can only bet what you currently have.\n" + "Current chips= " + player1.getTotalChips());
        } while (badBet());
        return bet;
    }

    public boolean badBet() {
        return (bet > player1.getTotalChips() || bet < 0);
    }

    public void printCard(String suitSymbol, String playerFace) {
        console.println(" ---------");
        console.println("| %s %s |", playerFace, suitSymbol);
        for(int i = 0; i < 5; i++) {
            console.println("|           |");
        }
        console.println("| %s %s |", suitSymbol, playerFace);
        console.println("---------");
    }



    @Override
    public void nextTurn() {

    }

    @Override
    public Boolean checkGameState() {
        return null;
    }

    @Override
    public String printGameRules() {
        return null;
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
        return false;
    }
}
