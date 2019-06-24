package com.leetcode;

import java.util.Arrays;

/**
 * 2019-06-24 09:20
 * 566, Easy
 *
 * @author Yu Zhen
 **/
public class ReshapetheMatrix {
    public int[][] matrixReshape (int[][] nums, int r, int c) {
        int m = nums.length;
        int n = nums[0].length;
        if (m * n != r * c) {
            return nums;
        }

        int[][] reshape = new int[r][c];
        int count = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                reshape[i][j] = nums[count / m][count % n];
                count++;
            }
        }
        return reshape;
    }

    public static void main (String[] args) {
        ReshapetheMatrix test = new ReshapetheMatrix();
        int[][] nums = {{1, 2}, {3, 4}};
        int r = 1, c = 4;

        int[][] reshape = test.matrixReshape(nums, r, c);
        for (int[] ints : reshape) {
            System.out.println(Arrays.toString(ints));

        }
    }
}
