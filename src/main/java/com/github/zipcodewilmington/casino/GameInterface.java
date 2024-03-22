package com.github.zipcodewilmington.casino;

/**
 * Created by leon on 7/21/2020.
 */
public interface GameInterface extends Runnable {
    void Runplay();
    /**
     * adds a player to the game
     *
     * @param player the player to be removed from the game
     * @return
     */
    boolean add(PlayerInterface player);

    /**
     * removes a player from the game
     *
     * @param player the player to be removed from the game
     * @return
     */
    boolean remove(PlayerInterface player);

    /**
     * specifies how the game will run
     */
    void run();
    void play();
    void nextTurn();
    Boolean checkGameState();
    String printGameRules();
    void exit();

    boolean quit();

    boolean playAgain(String prompt);
}
