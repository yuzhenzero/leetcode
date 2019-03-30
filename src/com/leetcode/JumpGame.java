package com.leetcode;

// 55#, Medium
public class JumpGame {
    public boolean canJump (int[] nums) {
        int[] memo = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            memo[i] = 0;
        }
        memo[nums.length-1] = 1;
        for (int i = nums.length -2; i >=0 ; i--) {
            int furthestJump = Math.min(i + nums[i], nums.length - 1);
            for (int j = i + 1; j <= furthestJump; j++) {
                if (memo[j] == 1) {
                    memo[i] = 1;
                }
            }
        }
        return memo[0] == 1;
    }

    public static void main (String[] args) {
        JumpGame jg = new JumpGame();
        int[] nums = {3,2,1,0,4};
        System.out.println(jg.canJump(nums));
    }
}
