package com.leetcode;

import java.util.Arrays;

// 130#, Medium
public class SurroundedRegions {
    private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private int m, n;

    public void solve (char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            dfs(board, i, 0);
            dfs(board, i, n - 1);
        }
        for (int i = 0; i < n; i++) {
            dfs(board, 0, i);
            dfs(board, m - 1, i);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 'T') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs (char[][] board, int i, int j) {
        if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'T';
        for (int[] d : direction) {
            dfs(board, i + d[0], j + d[1]);
        }
    }

    public static void main (String[] args) {
        SurroundedRegions sr = new SurroundedRegions();
        char[][] board =
               {{'X', 'X', 'X', 'X'},
                {'X', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'O', 'X', 'X'}};
        sr.solve(board);
        for (char[] chars : board) {
            System.out.println(Arrays.toString(chars));
        }
    }
}
