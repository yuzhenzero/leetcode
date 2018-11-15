package com.leetcode;

// 53#, Easy
public class MaximumSubarray {
    // 一次遍历法
    public int maxSubArray (int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum < 0) {
                sum = nums[i];
            } else {
                sum += nums[i];
            }
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }

    // 动态规划法
    // 定义一个数组，dp[]，dp[i]是**以第i个元素为结尾的一段最大子序和**。
    // 求dp[i]时，假设前面dp[0]~dp[i-1]都已经求出来了，dp[i-1]表示的是以i-1为结尾的最大子序和，
    // 若dp[i-1]小于0，则dp[i]加上前面的任意长度的序列和都会小于不加前面的序列
    // （即自己本身一个元素是以自己为结尾的最大自序和）
    public int maxSubArray_dp (int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < dp.length; i++) {
            if (dp[i - 1] > 0) {
                dp[i] = dp[i - 1] + nums[i];
            } else {
                dp[i] = nums[i];
            }

            max = Math.max(dp[i],max);
        }
        return max;

    }

    public static void main (String[] args) {
        MaximumSubarray msb = new MaximumSubarray();
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(msb.maxSubArray(nums));
        System.out.println(msb.maxSubArray_dp(nums));
    }

}
