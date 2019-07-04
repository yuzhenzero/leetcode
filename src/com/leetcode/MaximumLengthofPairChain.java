package com.leetcode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 2019-07-04 16:28
 * 646, Medium
 *
 * @author Yu Zhen
 **/
public class MaximumLengthofPairChain {
    public int findLongestChain (int[][] pairs) {
        if (pairs.length == 0 || pairs[0].length == 0) {
            return 0;
        }
        int n = pairs.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        Arrays.sort(pairs, Comparator.comparingInt(o -> o[0]));
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int max = 0;
        for (int i : dp) {
            max = Math.max(max, i);
        }
        return max;
    }

    public static void main (String[] args) {
        MaximumLengthofPairChain test = new MaximumLengthofPairChain();
        int[][] pairs = {
                {1, 2}, {2, 3}, {3, 4}
        };
        System.out.println(test.findLongestChain(pairs));
    }
}
