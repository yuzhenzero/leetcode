package com.leetcode;

/**
 * 2019-07-23 19:32
 * 518, Medium
 *
 * @author Yu Zhen
 **/
public class CoinChange2 {
    public int change (int amount, int[] coins) {
        if (amount == 0 || coins == null || coins.length == 0) {
            return 0;
        }
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] = dp[i] + dp[i - coin];
            }
        }
        return dp[amount];
    }

    public static void main (String[] args) {
        CoinChange2 test = new CoinChange2();
        int amount = 5;
        int[] coins = {1, 2, 5};
        System.out.println(test.change(amount, coins));
    }
}
