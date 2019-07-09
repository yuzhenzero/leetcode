package com.leetcode;

/**
 * 2019-07-09 09:44
 * 416, Medium
 *
 * @author Yu Zhen
 **/
public class PartitionEqualSubsetSum {
    public boolean canPartition (int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                dp[i] = dp[i] || dp[i - num];
            }
        }
        return dp[target];
    }

    public static void main (String[] args) {
        PartitionEqualSubsetSum test = new PartitionEqualSubsetSum();
        int[] nums = {1, 5, 5, 11};
        System.out.println(test.canPartition(nums));
    }
}
