package com.leetcode;

import java.util.Arrays;

/**
 * 2019-06-24 11:01
 * 645, Easy
 *
 * @author Yu Zhen
 **/
public class SetMismatch {
    public int[] findErrorNums (int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return new int[]{nums[i], i + 1};
            }
        }
        return null;
    }

    private void swap (int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main (String[] args) {
        SetMismatch test = new SetMismatch();
        int[] nums = {1, 4, 3, 4, 5};
        int[] ans = test.findErrorNums(nums);
        System.out.println(Arrays.toString(ans));
    }
}
