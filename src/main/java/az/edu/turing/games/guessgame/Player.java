package az.edu.turing.games.guessgame;

public class Player {
    private String name;
    private int[] guessedNumbers;
    private int guessCount;

    public Player(String name) {
        this.name = name;
        this.guessCount = 0;
        this.guessedNumbers = new int[100];
    }

    public String getName() {
        return name;
    }

    public void addGuess(int guess) {
        guessedNumbers[guessCount] = guess;
        guessCount++;
    }

    public int[] getGuessedNumbers() {
        int[] validGuess = new int[guessCount];
        for (int i = 0; i < guessCount; i++) {
            validGuess[i] = guessedNumbers[i];
        }
        return validGuess;
    }

    public int getGuessCount() {
        return guessCount;
    }
}
