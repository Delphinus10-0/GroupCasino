package com.github.zipcodewilmington;

import com.github.zipcodewilmington.casino.*;

//import com.github.zipcodewilmington.casino.games.HigherCards.HigherCardGame;
//import com.github.zipcodewilmington.casino.games.HigherCards.HigherCardPlayer;
import com.github.zipcodewilmington.casino.games.BlackJack.BlackJack;
import com.github.zipcodewilmington.casino.games.BlackJack.BlackJackPlayer;
import com.github.zipcodewilmington.casino.games.Trivia.Trivia;
//import com.github.zipcodewilmington.casino.games.Trivia.TriviaPlayer;
import com.github.zipcodewilmington.casino.games.Trivia.TriviaPlayer;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;
//M
/**
SMsbranch
 * Created by leon on 7/21/2020.
 * SM Test
 *11 Created by leon on 7/21/2020.
 master
 meeee
 */
//Angelina
public class Casino implements Runnable {
    private final IOConsole console = new IOConsole(AnsiColor.BLUE);

    @Override
    public void run() {
        String arcadeDashBoardInput;
        CasinoAccountManager casinoAccountManager = new CasinoAccountManager();
        casinoAccountManager.readFile();
        do {
            arcadeDashBoardInput = getArcadeDashboardInput();
            if ("select-game".equals(arcadeDashBoardInput)) {
                String accountName = console.getStringInput("Enter your account name:");
                String accountPassword = console.getStringInput("Enter your account password:");
                CasinoAccount casinoAccount = casinoAccountManager.getAccount(accountName, accountPassword);
                boolean isValidLogin = casinoAccount != null;
                if (isValidLogin) {

                    String gameSelectionInput = getGameSelectionInput().toUpperCase();
                    switch (gameSelectionInput) {
                        case "BLACKJACK":
                            play(new BlackJack(), new BlackJackPlayer(casinoAccount));
                            break;
                        case "TRIVIA":
                            play(new Trivia(), new TriviaPlayer(casinoAccount)); // Ensure this line executes
                            break;
                        default:
                            console.println("Invalid game selection. Please try again.");
                            break;
                    }
                } else {
                    // Handle invalid login
                    String errorMessage = "No account found with name of [ %s ] and password of [ %s ]";
                    throw new RuntimeException(String.format(errorMessage, accountName, accountPassword));
                }
            } else if ("create-account".equals(arcadeDashBoardInput)) {
                // Handle account creation
            }
            // Save account manager state after operations
            casinoAccountManager.saveFile();
        } while (!"logout".equals(arcadeDashBoardInput));
    }

    private String getGameSelectionInput() {
        return console.getStringInput(new StringBuilder()
                .append("Welcome to the Game Selection Dashboard!")
                .append("\nFrom here, you can select any of the following options:")
                .append("\n\t[ BLACKJACK ], [ TRIVIA ]") // Added TRIVIA as an option
                .toString());
    }

    private String getArcadeDashboardInput() {
        return console.getStringInput(new StringBuilder()
                .append("Welcome to the Arcade Dashboard!")
                .append("\nFrom here, you can select any of the following options:")
                .append("\n\t[ create-account ], [ select-game ]")
                .toString());
    }


    private void play(Object gameObject, Object playerObject) {
        GameInterface game = (GameInterface) gameObject;
        PlayerInterface player = (PlayerInterface) playerObject;
        game.add(player);
        game.run();
    }
}
