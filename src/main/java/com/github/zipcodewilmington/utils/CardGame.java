package com.github.zipcodewilmington.utils;

import com.github.zipcodewilmington.Player;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class CardGame implements GameInterface {
    protected boolean gameState;
    protected DeckCards deck;
    protected Map<Player, List<Card>> playerHands;
    protected Player dealer;
    protected Player activePlayer;

    public CardGame(Integer handSize, Player player){
        this.activePlayer = player;
        this.gameState = true;
        this.deck = new DeckCards();
        this.deck.shuffle();
        this.dealer = new Player("Dealer");
        this.playerHands = new HashMap<>();
        this.playerHands.put(this.activePlayer, new ArrayList<Card>());
        this.playerHands.put(this.dealer, new ArrayList<Card>());
        dealHands(handSize);
    }

    public CardGame(Player player) {
    }

    public String showHand(Player player) {
        StringBuilder sb = new StringBuilder();
        for(Card c : playerHands.get(player)){
            sb.append(c.toString());
        }
        return sb.toString();
    }

    public void dealHands(Integer handSize) {
        for(Player p : playerHands.keySet()){
            for(int i = 0; i < handSize; i++) {
                playerHands.get(p).add(this.deck.draw());
            }
        }
    }

    public Map<Player, List<Card>> getPlayerHands() {
        return playerHands;
    }

    public void setPlayerHands(Map<Player, List<Card>> playerHands) {
        this.playerHands = playerHands;
    }

    public Player getDealer(){
        return this.dealer;
    }
    @Override
    public void play() {
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






}
