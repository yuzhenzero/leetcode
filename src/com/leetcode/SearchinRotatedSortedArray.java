package com.leetcode;

// 33#, Medium
public class SearchinRotatedSortedArray {
    public int search (int[] nums, int target) {
        int n = nums.length;
        int lo = 0, hi = n - 1;
        // 找到旋转中心（数组最小值的索引）
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] > nums[hi]) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        int rot = lo;
        lo = 0;
        hi = n - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            int realmid = (mid + rot) % n;
            if (nums[realmid] == target) return realmid;
            if (nums[realmid] < target) lo = mid + 1;
            else hi = mid - 1;
        }
        return -1;
    }

    public int search2 (int[] nums, int target) {
        int n = nums.length;
        int lo = 0, hi = n - 1;
        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target)
                return mid;

            if (nums[mid] >= nums[lo]) {
                if (target >= nums[lo] && target < nums[mid])
                    hi = mid - 1;
                else
                    lo = mid + 1;
            }
            else if (nums[mid] <= nums[hi]) {
                if (target > nums[mid] && target <= nums[hi])
                    lo = mid + 1;
                else
                    hi = mid - 1;
            }
        }
        return -1;
    }

    public static void main (String[] args) {
        SearchinRotatedSortedArray srsa = new SearchinRotatedSortedArray();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(srsa.search2(nums, target));
    }
}
