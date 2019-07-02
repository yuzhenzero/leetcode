package com.leetcode;

// 198#, Easy
public class HouseRobber {
    public int rob (int[] nums) {
        if (nums.length == 0) return 0;
        int[] dp = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i-1],dp[i-2] + nums[i-1]);
        }
        return dp[nums.length];
    }

    public int rob2 (int[] nums) {
        int pre1 = 0, pre2 = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = Math.max(pre1, pre2 + nums[i]);
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }

    public static void main (String[] args) {
        HouseRobber hr = new HouseRobber();
        int[] nums1 = {2,7,9,3,1};
        int[] nums2 = {1,2,3,1};
        System.out.println(hr.rob2(nums1));
        System.out.println(hr.rob2(nums2));
    }
}
