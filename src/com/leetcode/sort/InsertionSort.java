package com.leetcode.sort;

import java.util.Arrays;

/**
 * 2019-07-29 11:06
 *
 * @author Yu Zhen
 **/
public class InsertionSort extends Sort {
    public static void insertionSort (int[] nums) {
        int N = nums.length;
        for (int i = 1; i < N; i++) {
            for (int j = i; j > 0 && nums[j - 1] > nums[j]; j--) {
                swap(nums, j, j - 1);
            }
        }
    }

    public static void main (String[] args) {
        int[] nums = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        insertionSort(nums);
        assert isSorted(nums);
        System.out.println(Arrays.toString(nums));
    }
}
