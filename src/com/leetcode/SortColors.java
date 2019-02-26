package com.leetcode;

import java.util.Arrays;

// 75#, Medium
public class SortColors {
    public void sortColors (int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private static void sort (int[] nums, int lo, int hi) {
        if (hi <= lo) return;
        int left = lo, current = lo + 1, right = hi;
        int v = nums[lo];
        while (current <= right) {
            if (nums[current] < v) exch(nums, left++, current++);
            else if (nums[current] > v) exch(nums, current, right--);
            else current++;
        }
        sort(nums, lo, left - 1);
        sort(nums, right + 1, hi);
    }

    private static void exch (int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main (String[] args) {
        SortColors sc = new SortColors();
        int[] nums = {2,0,2,1,1,0};
        sc.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
