package com.leetcode;

/**
 * 2019-07-25 10:15
 * 650, Medium
 *
 * @author Yu Zhen
 **/
public class TwoKeysKeyboard {
    public int minSteps (int n) {
        int[] dp = new int[n + 1];
        int h = (int) Math.sqrt(n);
        for (int i = 2; i <= n; i++) {
            dp[i] = i;
            for (int j = 2; j <= h; j++) {
                if (i % j == 0) {
                    dp[i] = dp[j] + dp[i / j];
                    break;
                }
            }
        }
        return dp[n];
    }

    public static void main (String[] args) {
        TwoKeysKeyboard test = new TwoKeysKeyboard();
        int n = 12;
        System.out.println(test.minSteps(n));
    }
}
