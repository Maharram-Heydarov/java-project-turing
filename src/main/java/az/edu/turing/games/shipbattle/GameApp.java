package az.edu.turing.games.shipbattle;

import java.util.Scanner;

public class GameApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        GameArea gameArea = new GameArea();
        gameArea.setTarget();
        GameController game = new GameController(gameArea, sc);
        game.startGame();
        sc.close();
    }
}
