package com.leetcode;

/**
 * 2019-07-02 10:27
 * 213, Medium
 *
 * @author Yu Zhen
 **/
public class HouseRobber2 {
    public int rob (int[] nums) {
        if (nums.length == 0 || nums == null) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(rob(nums, 0, nums.length - 2), rob(nums, 1, nums.length - 1));
    }

    private int rob (int[] nums, int start, int end) {
        int pre1 = 0, pre2 = 0;
        for (int i = start; i <= end; i++) {
            int cur = Math.max(pre1, pre2 + nums[i]);
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }

    public static void main (String[] args) {
        HouseRobber2 test = new HouseRobber2();
        int[] nums = {1, 2, 3, 1};
        System.out.println(test.rob(nums));
    }
}
