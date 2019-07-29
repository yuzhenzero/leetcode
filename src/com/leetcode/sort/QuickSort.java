package com.leetcode.sort;

import java.util.Arrays;

/**
 * 2019-07-29 19:30
 *
 * @author Yu Zhen
 **/
public class QuickSort extends Sort {
    public static void quickSort (int[] nums) {
        shuffle(nums); // 打乱数组，消除对输入的依赖
        quickSort(nums, 0, nums.length - 1);
    }

    private static void quickSort (int[] nums, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(nums, lo, hi);
        quickSort(nums, lo, j - 1);
        quickSort(nums, j + 1, hi);
    }

    private static int partition (int[] nums, int lo, int hi) {
        int pivot = lo;
        int index = pivot + 1;
        for (int i = index; i <= hi; i++) {
            if (nums[i] < nums[pivot]) {
                swap(nums, i, index);
                index++;
            }
        }
        swap(nums, pivot, index - 1);
        return index - 1;
    }

    public static void main (String[] args) {
        int[] nums = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        quickSort(nums);
        assert isSorted(nums);
        System.out.println(Arrays.toString(nums));
    }
}
