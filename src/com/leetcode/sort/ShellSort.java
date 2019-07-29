package com.leetcode.sort;

import java.util.Arrays;

/**
 * 2019-07-29 11:32
 *
 * @author Yu Zhen
 **/
public class ShellSort extends Sort {
    public static void shellSort (int[] nums) {
        int N = nums.length;
        int h = 1;
        while (h < N / 3) {
            h = 3 * h + 1;
        }
        while (h >= 1) {
            // 将数组变为 h 有序
            for (int i = h; i < N; i++) {
                // 对 h 有序数组使用 插入排序
                for (int j = i; j >= h && nums[j - h] > nums[j]; j -= h) {
                    swap(nums, j, j - h);
                }
            }
            h = h / 3;
        }
    }

    public static void main (String[] args) {
        int[] nums = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        shellSort(nums);
        assert isSorted(nums);
        System.out.println(Arrays.toString(nums));
    }
}
