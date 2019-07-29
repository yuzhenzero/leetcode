package com.leetcode.sort;

import java.util.Arrays;

/**
 * 2019-07-29 10:48
 *
 * @author Yu Zhen
 **/
public class SelectionSort extends Sort {
    public static void selectionSort (int[] nums) {
        int N = nums.length;
        for (int i = 0; i < N; i++) {
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            swap(nums, i, min);
        }
    }

    public static void main (String[] args) {
        int[] nums = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        selectionSort(nums);
        assert isSorted(nums);
        System.out.println(Arrays.toString(nums));
    }
}
