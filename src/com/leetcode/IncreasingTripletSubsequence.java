package com.leetcode;

// 334#, Medium
public class IncreasingTripletSubsequence {
    public boolean increasingTriplet (int[] nums) {
        if (nums.length < 3) return false;
        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i+1; j < nums.length - 1; j++) {
                if (nums[j] > nums[i]) {
                    for (int k = j+1; k < nums.length; k++) {
                        if (nums[k] > nums[j]) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    // 英文讨论区高赞回答
    public boolean increasingTriplet2 (int[] nums) {
        int min = Integer.MAX_VALUE;
        int second_min = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num<=min) min = num;
            else if (num < second_min) second_min = num;
            else if (num > second_min) return true;
        }
        return false;
    }

    public static void main (String[] args) {
        IncreasingTripletSubsequence its = new IncreasingTripletSubsequence();
        int[] nums = {2,1,5,6,7};
        System.out.println(its.increasingTriplet2(nums));
    }
}
