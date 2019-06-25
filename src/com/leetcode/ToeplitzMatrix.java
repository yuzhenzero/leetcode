package com.leetcode;

/**
 * 2019-06-25 11:27
 *
 * @author Yu Zhen
 **/
public class ToeplitzMatrix {
    public boolean isToeplitzMatrix (int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            if (!check(matrix, matrix[i][0], i, 0)) {
                return false;
            }
        }

        for (int i = 0; i < matrix[0].length; i++) {
            if (!check(matrix, matrix[0][i], 0, i)) {
                return false;
            }
        }
        return true;
    }

    private boolean check (int[][] matrix, int expectValue, int row, int col) {
        if (row >= matrix.length || col >= matrix[0].length) {
            return true;
        }
        if (matrix[row][col] != expectValue) {
            return false;
        }
        return check(matrix, expectValue, row + 1, col + 1);
    }

    public static void main (String[] args) {
        ToeplitzMatrix test = new ToeplitzMatrix();
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 1, 2, 3},
                {9, 5, 1, 2}
        };
        int[][] matrix2 = {
                {1, 2},
                {2, 2}
        };
        System.out.println(test.isToeplitzMatrix(matrix2));
    }
}
