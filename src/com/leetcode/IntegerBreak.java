package com.leetcode;

/**
 * 2019-07-03 20:46
 * 343, Medium
 *
 * @author Yu Zhen
 **/
public class IntegerBreak {
    public int integerBreak (int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i - 1; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * dp[i - j], j * (i - j)));
            }
        }
        return dp[n];
    }

    public int integerBreak2 (int n) {
        if (n == 2 || n == 3) {
            return n - 1;
        }
        int ans = 1;
        while (n > 4) {
            ans *= 3;
            n -= 3;
        }
        return ans * n;
    }

    public static void main (String[] args) {
        IntegerBreak test = new IntegerBreak();
        System.out.println(test.integerBreak2(8));
    }
}
