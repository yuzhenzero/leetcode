package com.leetcode;

// 162#, Medium
public class FindPeakElement {
    public int findPeakElement (int[] nums) {
        return iterative_helper(nums, 0, nums.length - 1);
    }

    private int recursive_helper (int[] nums, int lo, int hi) {
        if (lo == hi) {
            return lo;
        } else {
            int mid1 = (lo + hi) / 2;
            int mid2 = mid1 + 1;
            if (nums[mid1] > nums[mid2]) {
                return recursive_helper(nums, lo, mid1);
            } else {
                return recursive_helper(nums, mid2, hi);
            }
        }
    }

    private int iterative_helper (int[] nums, int lo, int hi) {

        while (lo < hi) {
            int mid1 = (lo + hi) / 2;
            int mid2 = mid1 + 1;
            if (nums[mid1] < nums[mid2]) {
                lo = mid2;
            } else {
                hi = mid1;
            }
        }
        return lo;
    }

    public static void main (String[] args) {
        FindPeakElement fpe = new FindPeakElement();
        int[] nums = {1, 2, 3, 1};
        System.out.println(fpe.findPeakElement(nums));
    }
}
