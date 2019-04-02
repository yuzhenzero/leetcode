package com.leetcode;

import java.util.Arrays;

// 300#, Medium
public class LongestIncreasingSubsequence {
    public int lengthOfLIS (int[] nums) {
        int[] dp = new int[nums.length];
        int len = 0;
        for (int num : nums) {
            int i = Arrays.binarySearch(dp,0,len,num);
            if (i < 0) i = -(i+1);
            dp[i] = num;
            if (i == len) len++;
        }
        return len;
    }
    public static void main (String[] args) {
        LongestIncreasingSubsequence lis = new LongestIncreasingSubsequence();
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lis.lengthOfLIS(nums));
    }
}
