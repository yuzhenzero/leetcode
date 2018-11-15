package com.leetcode;

import java.util.Arrays;

// 498# , Medium
public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] matrix)
    {
        if (matrix.length == 0) return new int[0];
        int m = matrix.length;      // 待处理的矩阵有M行、N列
        int n = matrix[0].length;
        int[] result = new int[m * n];
        int r = 0;
        int c = 0;
        for (int i = 0; i < result.length; i++) {
            result[i] = matrix[r][c];
            if ((r + c) % 2 == 0) {
                if (c == n - 1) {
                    r++;
                } else if (r == 0) {
                    c++;
                } else {
                    r--;
                    c++;
                }
            } else {
                if (r == m - 1) {
                    c++;
                } else if (c == 0) {
                    r++;
                } else {
                    r++;
                    c--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args)
    {
        DiagonalTraverse dt = new DiagonalTraverse();
        int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[] b = dt.findDiagonalOrder(a);
        System.out.println(Arrays.toString(b));
    }
}
