package com.leetcode;

/**
 * 2019-06-26 09:32
 * 565, Medium
 *
 * @author Yu Zhen
 **/
public class ArrayNesting {
    public int arrayNesting (int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            for (int j = i; nums[j] != -1; ) {
                count++;
                int t = nums[j];
                nums[j] = -1;
                j = t;
            }
            max = Math.max(max, count);
        }
        return max;
    }

    public static void main (String[] args) {
        ArrayNesting test = new ArrayNesting();
        int[] nums = {5, 4, 0, 3, 1, 6, 2};
        System.out.println(test.arrayNesting(nums));
    }
}
