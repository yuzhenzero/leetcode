package com.leetcode;

import java.util.Arrays;

/**
 * 2019-07-23 21:02
 * 377, Medium
 *
 * @author Yu Zhen
 **/
public class CombinationSum4 {
    public int combinationSum4 (int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] dp = new int[target + 1];
        dp[0] = 1;
        Arrays.sort(nums);

        for (int i = 1; i <= target; i++) {
            for (int j = 0; j < nums.length && nums[j] <= i; j++) {
                dp[i] = dp[i] + dp[i - nums[j]];
            }
            System.out.println(Arrays.toString(dp));
        }
        return dp[target];
    }

    public static void main (String[] args) {
        CombinationSum4 test = new CombinationSum4();
        int[] nums = {1, 2, 3};
        int target = 4;
        System.out.println(test.combinationSum4(nums, target));
    }
}
