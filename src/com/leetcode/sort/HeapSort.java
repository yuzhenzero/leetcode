package com.leetcode.sort;

import java.util.Arrays;

/**
 * 2019-09-23 15:14
 *
 * @author Yu Zhen
 **/
public class HeapSort extends Sort {
    public static void heapSort (int[] nums) {
        buildHeap(nums);// 构建堆
        int n = nums.length;
        for (int i = n - 1; i >= 1; i--) {
            swap(nums, 0, i);
            heapify(nums, 0, i);
        }
    }

    /**
     * 构建最大堆
     *
     * @param nums 乱序数组
     */
    private static void buildHeap (int[] nums) {
        int n = nums.length;// 数组中元素的个数
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(nums, i, n);
    }

    /**
     * 最大堆调整
     *
     * @param nums     待调整的数组
     * @param index    检查起始的下标
     * @param heapSize 堆大小
     */
    private static void heapify (int[] nums, int index, int heapSize) {
        int left = 2 * index + 1;// 左孩子的下标（如果存在的话）
        int right = 2 * index + 2;// 左孩子的下标（如果存在的话）
        int iMax = index;// 寻找3个节点中最大值节点的下标

        if (left < heapSize && nums[left] > nums[index])
            iMax = left;
        if (right < heapSize && nums[right] > nums[iMax])
            iMax = right;

        if (iMax != index) {
            swap(nums, iMax, index);
            heapify(nums, iMax, heapSize);
        }
    }

    public static void main (String[] args) {
        int[] nums = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};
        heapSort(nums);
        assert isSorted(nums);
        System.out.println(Arrays.toString(nums));
    }

}
