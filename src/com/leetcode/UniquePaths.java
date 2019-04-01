package com.leetcode;

// 66#, Medium
public class UniquePaths {
    public int uniquePaths (int m, int n) {
        int[][] matrix = new int[m][n];

        for (int i = 0; i < m; i++) {
            matrix[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            matrix[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
            }
        }
        return matrix[m - 1][n - 1];
    }

    public static void main (String[] args) {
        UniquePaths up = new UniquePaths();
        int m = 7, n = 3;
        System.out.println(up.uniquePaths(m, n));
    }
}
