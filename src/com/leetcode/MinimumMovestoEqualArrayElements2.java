package com.leetcode;

import java.util.Arrays;

/**
 * 2019-07-26 09:28
 * 462, Medium
 *
 * @author Yu Zhen
 **/
public class MinimumMovestoEqualArrayElements2 {
    public int minMoves2 (int[] nums) {
        Arrays.sort(nums);
        int ans = 0;
        int l = 0, r = nums.length - 1;
        while (l < r) {
            ans += nums[r] - nums[l];
            l++;
            r--;
        }
        return ans;
    }

    public static void main (String[] args) {
        MinimumMovestoEqualArrayElements2 test = new MinimumMovestoEqualArrayElements2();
        int[] nums = {1, 2, 3};
        System.out.println(test.minMoves2(nums));
    }
}
