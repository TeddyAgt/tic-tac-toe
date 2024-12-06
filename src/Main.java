import com.teddy.game.TicTacToe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        final Scanner userInput = new Scanner(System.in);
        final TicTacToe game = new TicTacToe();

        while (true) {
            System.out.println(game);
            System.out.println("Saisissez la case que vous voulez jouer:");
            final int playerMove = userInput.nextInt();
        }
    }
}