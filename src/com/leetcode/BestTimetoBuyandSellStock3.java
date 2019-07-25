package com.leetcode;

/**
 * 2019-07-25 17:10
 * 123, Hard
 *
 * @author Yu Zhen
 **/
public class BestTimetoBuyandSellStock3 {
    public int maxProfit (int[] prices) {
        int n = prices.length;
        int dp_i_2_0 = 0, dp_i_2_1 = Integer.MIN_VALUE;
        int dp_i_1_0 = 0, dp_i_1_1 = Integer.MIN_VALUE;
        for (int price : prices) {
            dp_i_2_0 = Math.max(dp_i_2_0, dp_i_2_1 + price);
            dp_i_2_1 = Math.max(dp_i_2_1, dp_i_1_0 - price);
            dp_i_1_0 = Math.max(dp_i_1_0, dp_i_1_1 + price);
            dp_i_1_1 = Math.max(dp_i_1_1, -price);
        }
        return dp_i_2_0;
    }

    public static void main (String[] args) {
        BestTimetoBuyandSellStock3 test = new BestTimetoBuyandSellStock3();
        int[] prices = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(test.maxProfit(prices));
    }
}
