package com.leetcode;

/**
 * 2019-07-02 21:52
 * 413, Medium
 *
 * @author Yu Zhen
 **/
public class ArithmeticSlices {
    public int numberOfArithmeticSlices (int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        int[] dp = new int[n];
        for (int i = 2; i < n; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = dp[i - 1] + 1;
            }
        }

        int count = 0;
        for (int i : dp) {
            count += i;
        }
        return count;
    }

    public static void main (String[] args) {
        ArithmeticSlices test = new ArithmeticSlices();
        int[] A = {1, 2, 3, 4};
        System.out.println(test.numberOfArithmeticSlices(A));
    }
}
