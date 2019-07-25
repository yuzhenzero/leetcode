package com.leetcode;

// 121#, Easy
// 注意 只能进行一次交易（先买后卖），不能进行多次买卖
public class BestTimetoBuyandSellStock {
    public int maxProfit (int[] prices) {
        int min_price = Integer.MAX_VALUE;
        int max_profit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min_price) {
                min_price = prices[i];
            } else if (prices[i] - min_price > max_profit) {
                max_profit = prices[i] - min_price;
            }
        }
        return max_profit;
    }

    public int maxProfit_dp (int[] prices) {
        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, -prices[i]);
        }
        return dp_i_0;
    }

    public static void main (String[] args) {
        BestTimetoBuyandSellStock btbss = new BestTimetoBuyandSellStock();
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(btbss.maxProfit(prices));
        System.out.println(btbss.maxProfit_dp(prices));
    }
}
