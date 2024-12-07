import com.teddy.exceptions.TicTacToeInvalidInputException;
import com.teddy.game.Player;
import com.teddy.game.TicTacToe;

import java.util.HashMap;
import java.util.Scanner;

import static com.teddy.game.StringConstants.BLANK;

public class Main {
    public static void main(String[] args) {

        final TicTacToe game = new TicTacToe();

        Player player = Player.FIRST;
        HashMap<Player, String> players = initPlayers();

        while (true) {
            try {
                System.out.println(game);
                System.out.println(players.get(player) + " | Saisissez la case que vous voulez jouer:");
                final int playerMove = getPlayerMove();

                game.processInput(player, playerMove);
                if (game.checkWin()) {
                    System.out.println("Le joueur " + players.get(player) + " a gagné la partie !");
                    System.out.println(game);
                    break;
                }
                if (game.checkDraw()) {
                    System.out.println("Personne n'a gagné la partie !");
                    System.out.println(game);
                    break;
                }

                player = nextPlayer(player);
            } catch (TicTacToeInvalidInputException e) {
                System.out.println(e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("L'entrée doit être un chiffre");
            }
        }
    }

    private static HashMap<Player, String> initPlayers() {
        HashMap<Player, String> players = new HashMap<>();
        final Scanner userInput = new Scanner(System.in);

        do {
            System.out.println("Saisissez le nom du joueur 1:");
            players.put(Player.FIRST, userInput.nextLine());
        } while (players.get(Player.FIRST).equals(BLANK));

        do {
            System.out.println("Saisissez le nom du joueur 2:");
            players.put(Player.SECOND, userInput.nextLine());
        } while (players.get(Player.SECOND).equals(BLANK));

        return players;
    }

    private static int getPlayerMove() throws TicTacToeInvalidInputException {
        final Scanner userInput = new Scanner(System.in);
        String input = userInput.nextLine();

        if (input.equals("exit") || input.equals("quit")) {
            System.exit(0);
        }

        int inputInteger = Integer.parseInt(input);
        if (inputInteger < 1 || inputInteger > 9) {
            throw new TicTacToeInvalidInputException("Le chiffre doit être entre 1 et 9");
        }
        return inputInteger;
    }

    private static Player nextPlayer(Player player) {
        if (player == Player.FIRST) {
            return Player.SECOND;
        } else {
            return Player.FIRST;
        }
    }
}