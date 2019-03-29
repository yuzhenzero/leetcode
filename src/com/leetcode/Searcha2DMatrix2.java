package com.leetcode;

// 240#, Medium
public class Searcha2DMatrix2 {
    public boolean searchMatrix (int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }
        int row = 0;
        int col = matrix[0].length - 1;
        while (row <= matrix.length - 1 && col >= 0) {
            if (target == matrix[row][col]) {
                return true;
            } else if (target > matrix[row][col]) {
                row++;
            } else if (target < matrix[row][col]) {
                col--;
            }
        }
        return false;
    }

    public static void main (String[] args) {
        Searcha2DMatrix2 sm2 = new Searcha2DMatrix2();
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };

        int target = 20;
        System.out.println(sm2.searchMatrix(matrix, target));
    }
}
