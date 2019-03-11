package com.leetcode;

import java.util.Arrays;

// 34#, Medium
public class FindFirstandLastPositionofElementinSortedArray {
    public int[] searchRange (int[] nums, int target) {
        int start = firstGreaterEqual(nums, target);
        if (start == nums.length || nums[start] != target) {
            return new int[]{-1, -1};
        }
        return new int[]{start, firstGreaterEqual(nums, target + 1) - 1};
    }

    private int firstGreaterEqual (int[] nums, int target) {
        int low = 0;
        int high = nums.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            } else {
                // 使 high 总是倾向于往左移
                high = mid;
            }
        }
        return low;
    }

    public static void main (String[] args) {
        FindFirstandLastPositionofElementinSortedArray fflpesa = new FindFirstandLastPositionofElementinSortedArray();
        int[] nums = {5, 7, 7, 8, 8, 10};
        System.out.println(Arrays.toString(fflpesa.searchRange(nums, 8)));
    }

}
