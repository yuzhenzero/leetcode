package com.leetcode;

/**
 * 2019-07-04 10:00
 * 91, Medium
 *
 * @author Yu Zhen
 **/
public class DecodeWays {
    public int numDecodings (String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= n; i++) {
            int one = Integer.valueOf(s.substring(i - 1, i));
            if (one != 0) {
                dp[i] = dp[i] + dp[i - 1];
            }
            if (s.charAt(i - 2) == '0') {
                continue;
            }
            int two = Integer.valueOf(s.substring(i - 2, i));
            if (two < 26) {
                dp[i] = dp[i] + dp[i - 2];
            }
        }
        return dp[n];
    }

    public static void main (String[] args) {
        DecodeWays test = new DecodeWays();
        String s = "111";
        System.out.println(test.numDecodings(s));
    }
}
