package com.ajd.prep.dsa.matrix;

import java.util.HashSet;
import java.util.Set;

public class SudokuValidator {
    public boolean isValid(char[][] board) {
        char dot = '.';
        for(int i = 0; i < 9; i++) {
            Set<Character> rowDupChecker = new HashSet<>();
            Set<Character> colDupChecker = new HashSet<>();
            Set<Character> gridDupChecker = new HashSet<>();

            for(int j = 0; j < 9; j++) {
                int x = (j/3) + (i/3)*3;
                int y = (j%3) + (i%3)*3;
                if(
                        (board[i][j] != dot && rowDupChecker.contains(board[i][j])) ||
                                (board[j][i] != dot && colDupChecker.contains(board[j][i])) ||
                                (board[x][y] != dot && gridDupChecker.contains(board[x][y]))
                ) {
                    return false;
                }

                rowDupChecker.add(board[i][j]);
                colDupChecker.add(board[j][i]);
                gridDupChecker.add(board[x][y]);
            }

            rowDupChecker.clear();
            colDupChecker.clear();
            gridDupChecker.clear();
        }

        return true;
    }
}
