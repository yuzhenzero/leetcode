package com.leetcode;

// 215#, Medium
public class KthLargestElementinanArray {
    public int findKthLargest (int[] nums, int k) {
        int n = nums.length;
        int p = quickSelect(nums, 0, n - 1, n - k + 1);
        return nums[p];
    }

    // 此处的 k 是按从小到大排的顺序
    // return the index of the kth smallest number
    private int quickSelect (int[] nums, int lo, int hi, int k) {
        int i = lo;
        int j = hi;
        int pivot = nums[hi];
        // < pivot 放左边
        // >= pivot 放右边
        while (i < j) {
            if (nums[i++] > pivot) swap(nums, --i, --j);
        }
        swap(nums, i, hi); // 将 pivot 放入正确位置

        // 计算 pivot 在数组中的位置
        int m = i - lo + 1;

        if (m == k) return i;
        else if (m > k) return quickSelect(nums, lo, i - 1, k);
        else return quickSelect(nums, i + 1, hi, k - m);
    }

    private void swap (int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main (String[] args) {
        KthLargestElementinanArray klea = new KthLargestElementinanArray();
        int[] nums = {3, 2, 1, 5, 6, 4};
        System.out.println(klea.findKthLargest(nums, 2));
    }


}
