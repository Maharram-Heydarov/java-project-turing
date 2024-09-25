package az.edu.turing.games.guessgame;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class GuessGame {
    private int randomNumber;
    private Player player;

    public GuessGame(Player player) {
        this.player = player;
        Random random = new Random();
        this.randomNumber = random.nextInt(101);
    }

    private int getValidInput(Scanner sc) {
        while (true) {
            System.out.print("Pls guess the number :");
            if (sc.hasNextInt()) {
                return sc.nextInt();
            } else {
                System.out.println("Invalid input ,pls enter a valid input ");
                sc.next();
            }
        }
    }

    public void startGame() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Let the Game begin ");
        while (true) {
            int userGuess = getValidInput(sc);
            player.addGuess(userGuess);
            if (userGuess > randomNumber) {
                System.out.println("your guess is too big.please ,try again ");
            } else if (userGuess < randomNumber) {
                System.out.println("your guess is too small. please ,try again ");
            } else {
                System.out.println("congratulations  " + player.getName());
                break;
            }
        }
        int[] guessedNumbers = player.getGuessedNumbers();
        Arrays.sort(guessedNumbers);
        reverseArray(guessedNumbers);
        System.out.println("guessed numbers : " + Arrays.toString(guessedNumbers));
        System.out.println("you tried " + player.getGuessCount() + " time");
    }

    private void reverseArray(int[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int temp = array[i];
            array[i] = array[array.length - i - 1];
            array[array.length - i - 1] = temp;
        }
    }
}
