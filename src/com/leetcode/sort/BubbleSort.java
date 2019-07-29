package com.leetcode.sort;

import java.util.Arrays;

/**
 * 2019-07-29 17:13
 *
 * @author Yu Zhen
 **/
public class BubbleSort extends Sort {
    public static void bubbleSort (int[] nums) {
        int N = nums.length;
        for (int i = 1; i < N; i++) {
            // 总共需要 N-1 趟遍历使数组排好序
            boolean isSorted = true;
            for (int j = 0; j < N - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    isSorted = false;
                }
            }
            if (isSorted) break;
        }
    }

    public static void main (String[] args) {
        int[] nums = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        bubbleSort(nums);
        assert isSorted(nums);
        System.out.println(Arrays.toString(nums));
    }
}
