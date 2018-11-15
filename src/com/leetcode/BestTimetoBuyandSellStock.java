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

    public static void main (String[] args) {
        BestTimetoBuyandSellStock btbss = new BestTimetoBuyandSellStock();
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(btbss.maxProfit(prices));
    }
}
