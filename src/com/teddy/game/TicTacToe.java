package com.teddy.game;

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
}
