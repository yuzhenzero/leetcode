package com.leetcode;

/**
 * 2019-07-25 15:09
 * 309, Medium
 *
 * @author Yu Zhen
 **/
public class BestTimetoBuyandSellStockwithCooldown {
    public int maxProfit (int[] prices) {
        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        int dp_pre_0 = 0;
        for (int i = 0; i < n; i++) {
            int tmp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, dp_pre_0 - prices[i]);
            dp_pre_0 = tmp;
        }
        return dp_i_0;
    }

    public static void main (String[] args) {
        BestTimetoBuyandSellStockwithCooldown test = new BestTimetoBuyandSellStockwithCooldown();
        int[] prices = {1, 2, 3, 0, 2};
        System.out.println(test.maxProfit(prices));
    }
}
