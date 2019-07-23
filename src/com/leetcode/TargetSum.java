package com.leetcode;

/**
 * 2019-07-23 10:18
 * 494, Medium
 * @author Yu Zhen
 **/
public class TargetSum {
    public int findTargetSumWays (int[] nums, int S) {
        int sum = computeSum(nums);
        if (sum < S || (sum + S) % 2 == 1) {
            return 0;
        }
        int target = (sum + S) / 2;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                dp[i] = dp[i] + dp[i - num];
            }
        }
        return dp[target];
    }

    private int computeSum (int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        return sum;
    }

    public static void main (String[] args) {
        TargetSum test = new TargetSum();
        int[] nums = {1, 1, 1, 1, 1};
        int S = 3;
        System.out.println(test.findTargetSumWays(nums, S));
    }
}
