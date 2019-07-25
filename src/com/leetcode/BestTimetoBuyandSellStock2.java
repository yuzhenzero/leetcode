package com.leetcode;

// 122#, Easy
public class BestTimetoBuyandSellStock2 {
    public int maxProfit (int[] prices) {
        int maxprofit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                maxprofit += prices[i] - prices[i - 1];
            }
        }
        return maxprofit;
    }

    public int maxProfit_dp (int[] prices) {
        int n = prices.length;
        int dp_i_0 = 0, dp_i_1 = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int tmp = dp_i_0;
            dp_i_0 = Math.max(dp_i_0, dp_i_1 + prices[i]);
            dp_i_1 = Math.max(dp_i_1, tmp - prices[i]);
        }
        return dp_i_0;
    }


    public static void main (String[] args) {
        BestTimetoBuyandSellStock2 btbss2 = new BestTimetoBuyandSellStock2();
        int[] a = {7, 1, 5, 3, 6, 4};
        int[] b = {1, 7, 2, 3, 6, 7, 6, 7};

        System.out.println(btbss2.maxProfit(a));
        System.out.println(btbss2.maxProfit(b));

        System.out.println(btbss2.maxProfit_dp(a));
        System.out.println(btbss2.maxProfit_dp(b));
    }
}
