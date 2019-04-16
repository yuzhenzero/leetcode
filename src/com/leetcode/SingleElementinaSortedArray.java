package com.leetcode;

// 540#, Medium
public class SingleElementinaSortedArray {
    public int singleNonDuplicate (int[] nums) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (m % 2 == 1)
                m--;
            if (nums[m] == nums[m + 1]) {
                l = m + 2;
            } else {
                h = m;
            }
        }
        return nums[l];
    }

    public static void main (String[] args) {
        SingleElementinaSortedArray sesa = new SingleElementinaSortedArray();
        int[] nums = {1, 1, 2, 3, 3, 4, 4, 8, 8};
        System.out.println(sesa.singleNonDuplicate(nums));
    }
}
