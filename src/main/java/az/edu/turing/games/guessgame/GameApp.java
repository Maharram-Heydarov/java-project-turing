package az.edu.turing.games.guessgame;

import java.util.Scanner;

public class GameApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("please enter your name : ");
        String name = sc.nextLine();
        Player player = new Player(name);
        GuessGame game = new GuessGame(player);
        game.startGame();
    }
}
