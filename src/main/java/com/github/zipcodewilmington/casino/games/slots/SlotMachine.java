package com.github.zipcodewilmington.casino.games.slots;
import com.github.zipcodewilmington.casino.Gambler;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;

import java.util.Random;
import java.util.Scanner;
public class SlotMachine implements Gambler {
    private static final int JACKPOT_MULTIPLIER = 100;
    private static final int MATCH_MULTIPLIER = 10;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        System.out.println("Welcome to the Slot Machine!");
        System.out.println("Press Enter to spin the reels. Type 'exit' to quit.");
        while (playGame(scanner, random)) {
            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainInput = scanner.nextLine();
            if (!playAgainInput.equalsIgnoreCase("yes") && !playAgainInput.equalsIgnoreCase("y")) {
                break;
            }
        }
        System.out.println("Thanks for playing!");
        scanner.close();
    }

    public static boolean playGame(Scanner scanner, Random random) {
        System.out.print("Press Enter to spin: ");
        String input = scanner.nextLine();
        int[] result = spinReels(random);
        System.out.println("Spinning...");
        System.out.printf("%d - %d - %d%n", result[0], result[1], result[2]);
        int payout = calculatePayout(result);
        if (payout == JACKPOT_MULTIPLIER) {
            System.out.println("Congratulations! You hit the Jackpot! You win " + JACKPOT_MULTIPLIER + " times your bet!");
        } else if (payout == MATCH_MULTIPLIER) {
            System.out.println("Matched 2 symbols! You win " + MATCH_MULTIPLIER + " times your bet!");
        } else {
            System.out.println("Sorry, you didn't win this time.");
        }
        return true;
    }
    public static int[] spinReels(Random random) {
        int[] result = new int[3];
        for (int i = 0; i < 3; i++) {
            result[i] = random.nextInt(5) + 1;
        }
        return result;
    }
    public static int calculatePayout(int[] result) {
        if (result[0] == result[1] && result[1] == result[2]) {
            return JACKPOT_MULTIPLIER;
        } else if (result[0] == result[1] || result[1] == result[2] || result[0] == result[2]) {
            return MATCH_MULTIPLIER;
        } else {
            return 0;
        }
    }
    @Override
    public void withdraw(Integer amount) {
    }
    @Override
    public void deposit(Integer amount) {
    }
}