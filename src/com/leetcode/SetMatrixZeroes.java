package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 73#, Medium
public class SetMatrixZeroes {
    public void setZeroes (int[][] matrix) {
        List<List<Integer>> flag = new ArrayList<List<Integer>>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    flag.add(Arrays.asList(i,j));
                }
            }
        }

        for (List<Integer> integers : flag) {
            int row = integers.get(0);
            int col = integers.get(1);
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][col] = 0;
                for (int j = 0; j < matrix[i].length; j++) {
                    matrix[row][j] = 0;
                }
            }

        }
    }

    public static void main (String[] args) {
        SetMatrixZeroes smz = new SetMatrixZeroes();
        int[][] matrix = {{1,1,1},{1,0,1},{1,1,1}};
        smz.setZeroes(matrix);
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.println(anInt);
            }
        }
    }
}
