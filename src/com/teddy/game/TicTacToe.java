package com.teddy.game;

import com.teddy.exceptions.TicTacToeInvalidInputException;

import java.util.Arrays;

import static com.teddy.game.StringConstants.LINE_SEPARATOR;
import static com.teddy.game.StringConstants.SPACE;

public class TicTacToe {
    private char[][] grid = new char[][]{
            {'.', '.', '.'},
            {'.', '.', '.'},
            {'.', '.', '.'}
    };

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Grille du Morpion: ")
                .append(LINE_SEPARATOR);
        for (char[] line : grid) {
            for (char cell : line) {
                builder.append(SPACE).append(cell).append(SPACE);
            }
            builder.append(LINE_SEPARATOR);
        }
        return builder.toString();
    }

    public void processInput(Player player, int playerMove) throws TicTacToeInvalidInputException {
        int row = (playerMove - 1) / 3;
        int column = (playerMove - 1) % 3;

        if (grid[row][column] == '.') {
            if (player.equals(Player.FIRST)) {
                grid[row][column] = 'X';
            } else {
                grid[row][column] = 'O';
            }
        } else {
            throw new TicTacToeInvalidInputException("Cette case a déjà été jouée !");
        }
    }

    public boolean checkWin() {
        for(int i = 0; i < 3; i++) {
            boolean checkLine = grid[i][0] == grid[i][1] && grid[i][1] == grid[i][2] && grid[i][2] != '.';
            boolean checkColumn = grid[0][i] == grid[1][i] && grid[1][i] == grid[2][i] && grid[2][i] != '.';

            if (checkLine || checkColumn) return true;
        }

        boolean checkDiagonal1 = grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2] && grid[2][2] != '.';
        boolean checkDiagonal2 = grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0] && grid[2][0] != '.';

        if (checkDiagonal1 || checkDiagonal2) return true;
        return false;
    }

    public boolean checkDraw() {
        for (char[] row : grid) {
            for (char cell : row) {
                if (cell == '.') {
                    return false;
                }
            }
        }
        return true;
    }
}
