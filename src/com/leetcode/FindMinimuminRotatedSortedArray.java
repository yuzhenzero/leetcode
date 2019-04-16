package com.leetcode;

// 153#, Medium
public class FindMinimuminRotatedSortedArray {
    public int findMin (int[] nums) {
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int m = l + (h - l) / 2;
            if (nums[m] <= nums[h]) {
                h = m;
            } else {
                l = m + 1;
            }
        }
        return nums[l];
    }

    public static void main (String[] args) {
        FindMinimuminRotatedSortedArray fmrs = new FindMinimuminRotatedSortedArray();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(fmrs.findMin(nums));
    }
}
