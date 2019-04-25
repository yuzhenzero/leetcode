package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 51#, Hard
public class NQueens {
    private List<List<String>> solutions;
    private char[][] nQueens;
    private int n;
    private boolean[] colUsed;
    private boolean[] diagonals45Used;
    private boolean[] diagonals135Used;

    public List<List<String>> solveNQueens (int n) {
        solutions = new ArrayList<>();
        nQueens = new char[n][n];
        for (char[] nQueen : nQueens) {
            Arrays.fill(nQueen, '.');
        }
        colUsed = new boolean[n];
        diagonals45Used = new boolean[2 * n - 1];
        diagonals135Used = new boolean[2 * n - 1];
        this.n = n;
        backtrack(0);
        return solutions;
    }

    private void backtrack (int row) {
        if (row == n) {
            List<String> list = new ArrayList<>();
            for (char[] nQueen : nQueens) {
                list.add(new String(nQueen));
            }
            solutions.add(list);
        } else {
            for (int col = 0; col < n; col++) {
                int diagonals45Index = row + col;
                int diagonals135Index = n - 1 - (row - col);
                if (colUsed[col]
                        || diagonals45Used[diagonals45Index]
                        || diagonals135Used[diagonals135Index]) {
                    continue;
                }
                nQueens[row][col] = 'Q';
                colUsed[col]
                        = diagonals45Used[diagonals45Index]
                        = diagonals135Used[diagonals135Index]
                        = true;
                backtrack(row + 1);
                nQueens[row][col] = '.';
                colUsed[col]
                        = diagonals45Used[diagonals45Index]
                        = diagonals135Used[diagonals135Index]
                        = false;
            }
        }
    }

    public static void main (String[] args) {
        NQueens nq = new NQueens();
        for (List<String> solveNQueen : nq.solveNQueens(4)) {
            for (String s : solveNQueen) {
                System.out.println(s);
            }
            System.out.println("---");
        }
    }
}
