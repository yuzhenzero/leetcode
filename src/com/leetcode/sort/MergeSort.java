package com.leetcode.sort;

import java.util.Arrays;

/**
 * 2019-07-29 16:07
 *
 * @author Yu Zhen
 **/
public class MergeSort extends Sort {
    private static int[] tmp;

    /**
     * 自顶向下的归并排序
     *
     * @param nums 待排序的数组
     */
    public static void mergeSortUB (int[] nums) {
        tmp = new int[nums.length];
        mergeSortUB(nums, 0, nums.length - 1);
    }

    private static void mergeSortUB (int[] nums, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        mergeSortUB(nums, lo, mid);
        mergeSortUB(nums, mid + 1, hi);
        merge(nums, lo, mid, hi);
    }

    /**
     * 自底向上的归并排序
     *
     * @param nums 待排序的数组
     */
    private static void mergeSortBU (int[] nums) {
        int N = nums.length;
        tmp = new int[N];
        for (int sz = 1; sz < N; sz *= 2) {
            for (int lo = 0; lo < N - sz; lo += 2 * sz) {
                merge(nums, lo, lo + sz - 1, Math.min(lo + 2 * sz - 1, N - 1));
            }
        }
    }

    private static void merge (int[] nums, int lo, int mid, int hi) {
        // 将 nums[lo,mid] 和 nums[mid+1,hi] 归并到一起
        int i = lo, j = mid + 1;
        for (int k = lo; k <= hi; k++) {
            tmp[k] = nums[k];
        }
        for (int k = lo; k <= hi; k++) {
            if (i > mid) nums[k] = tmp[j++];
            else if (j > hi) nums[k] = tmp[i++];
            else if (tmp[i] > tmp[j]) nums[k] = tmp[j++];
            else nums[k] = tmp[i++];
        }
    }

    public static void main (String[] args) {
        int[] nums = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        mergeSortBU(nums);
        assert isSorted(nums);
        System.out.println(Arrays.toString(nums));
    }
}
