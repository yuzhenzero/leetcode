package com.leetcode;

// 55#, Medium
public class JumpGame {
    public boolean canJump (int[] nums) {
        // 0 代表不能到终点，1 代表能到
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
                    break; // 后续有一个能到终点，就代表该点能到，不需要继续考察了
                }
            }
        }
        return memo[0] == 1;
    }

    public boolean canJump2 (int[] nums) {
        // 表示最小的能到尾部的元素索引
        int minCanReach = nums.length - 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] + i >= minCanReach)
                minCanReach = i;
        }
        return minCanReach == 0;
    }

    public static void main (String[] args) {
        JumpGame jg = new JumpGame();
        int[] nums = {2,3,1,1,4};
        System.out.println(jg.canJump2(nums));
    }
}
