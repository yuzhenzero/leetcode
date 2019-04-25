package com.leetcode;

import java.util.Arrays;

// 37#, Hard
public class SudokuSolver {
    private boolean[][] rowUsed = new boolean[9][10];
    private boolean[][] colUsed = new boolean[9][10];
    private boolean[][] cubeUsed = new boolean[9][10];
    private char[][] board = new char[9][9];

    public void solveSudoku (char[][] board) {
        this.board = board;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                int num = board[i][j] - '0';
                rowUsed[i][num] = true;
                colUsed[j][num] = true;
                cubeUsed[cubeNum(i, j)][num] = true;
            }
        }
        backtrack(0, 0);
    }

    private boolean backtrack (int row, int col) {
        while (row < 9 && board[row][col] != '.') {
            row = col == 8 ? row + 1: row;
            col = col == 8 ? 0 : col + 1;
        }
        if (row == 9) {
            return true;
        }
        for (int num = 1; num <= 9; num++) {
            if (rowUsed[row][num] || colUsed[col][num] || cubeUsed[cubeNum(row, col)][num]) {
                continue;
            }
            rowUsed[row][num] = colUsed[col][num] = cubeUsed[cubeNum(row, col)][num] = true;
            board[row][col] = (char) (num + '0');
            if (backtrack(row, col)) {
                return true;
            }
            board[row][col] = '.';
            rowUsed[row][num] = colUsed[col][num] = cubeUsed[cubeNum(row, col)][num] = false;
        }
        return false;
    }


    private int cubeNum (int row, int col) {
        int r = row / 3;
        int c = col / 3;
        return r * 3 + c;
    }

    public static void main (String[] args) {
        SudokuSolver sudokuSolver = new SudokuSolver();
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        sudokuSolver.solveSudoku(board);
        for (char[] chars : board) {
            System.out.println(Arrays.toString(chars));
        }
    }
}
