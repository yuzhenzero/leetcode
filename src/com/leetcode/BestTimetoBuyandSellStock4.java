package com.leetcode;

/**
 * 2019-07-25 17:28
 * 188, Hard
 *
 * @author Yu Zhen
 **/
public class BestTimetoBuyandSellStock4 {
    public int maxProfit (int k, int[] prices) {
        int n = prices.length;
        if (k > n / 2) {
            int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
            for (int price : prices) {
                int tmp = dp_i_0;
                dp_i_0 = Math.max(dp_i_0, dp_i_1 + price);
                dp_i_1 = Math.max(dp_i_1, tmp - price);
            }
            return dp_i_0;
        }

        int[][][] dp = new int[n][k + 1][2];
        for (int i = 0; i < n; i++) {
            for (int j = k; j >= 1; j--) {
                if (i - 1 == -1) {
                    dp[i][j][0] = 0;
                    dp[i][j][1] = -prices[i];
                    continue;
                }
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }

        return dp[n - 1][k][0];
    }

    public static void main (String[] args) {
        BestTimetoBuyandSellStock4 test = new BestTimetoBuyandSellStock4();
        int k = 2;
        int[] prices = {3, 2, 6, 5, 0, 3};
        System.out.println(test.maxProfit(k, prices));
    }
}
