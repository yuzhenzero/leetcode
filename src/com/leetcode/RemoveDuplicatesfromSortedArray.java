package com.leetcode;

import java.util.Arrays;

// 26#, Easy
public class RemoveDuplicatesfromSortedArray {
    public int removeDuplicates(int[] nums)
    {

        int current = 1;
        for (int i = 0; i < nums.length - 1; i++) {

            if (nums[i] != nums[i + 1]) {
                nums[current++] = nums[i + 1];
            }

        }
        return current;
    }

    public static void main(String[] args)
    {
        RemoveDuplicatesfromSortedArray rd = new RemoveDuplicatesfromSortedArray();
        int[] nums1 = {1, 1, 2};
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(rd.removeDuplicates(nums1));
        System.out.println(Arrays.toString(nums1));
        System.out.println(rd.removeDuplicates(nums2));
        System.out.println(Arrays.toString(nums2));
    }
}
