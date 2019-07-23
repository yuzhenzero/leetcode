package com.leetcode;

/**
 * 2019-07-23 15:57
 * 474, Medium
 *
 * @author Yu Zhen
 **/
public class OnesandZeroes {
    public int findMaxForm (String[] strs, int m, int n) {
        if (strs == null || strs.length == 0) {
            return 0;
        }
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            int ones = 0, zeros = 0;
            for (char c : str.toCharArray()) {
                if (c == '0') {
                    zeros++;
                } else {
                    ones++;
                }
            }
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - zeros][j - ones] + 1);
                }
            }
        }
        return dp[m][n];
    }

    public static void main (String[] args) {
        OnesandZeroes test = new OnesandZeroes();
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m = 5, n = 3;
        test.findMaxForm(strs, m, n);

    }
}
