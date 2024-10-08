package az.edu.turing.games.shipbattle;

import java.util.Scanner;

public class GameController {
    private GameArea gameArea;
    private Scanner sc;

    public GameController(GameArea gameArea, Scanner sc) {
        this.gameArea = gameArea;
        this.sc = sc;
    }

    public void startGame() {
        System.out.println("All set. Get ready to rumble");
        gameArea.displayGamePlace();
        while (true) {
            int row = getValidInput("Enter row (1-5): ") - 1;
            int col = getValidInput("Enter column (1-5): ") - 1;

            if (gameArea.checkHit(row, col)) {
                System.out.println("hit");
                gameArea.markTarget();
            } else {
                System.out.println("miss");
                gameArea.markShot(row, col);
            }

            if (gameArea.isTargetDefeated()) {
                gameArea.displayGamePlace();
                System.out.println("you have won ");
                break;
            }
            gameArea.displayGamePlace();
        }
    }

    private int getValidInput(String text) {
        int num = -1;
        while (true) {
            System.out.print(text);
            if (sc.hasNextInt()) {
                num = sc.nextInt();
                if (num >= 1 && num <= GameArea.size) {
                    break;
                } else {
                    System.out.println("Invalid input. Please enter a number between 1 and " + GameArea.size);
                }
            } else {
                System.out.println("Invalid input.Please enter a valid number ");
                sc.next();
            }
        }
        return num;
    }
}
