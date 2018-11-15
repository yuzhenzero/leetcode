package com.leetcode;

import java.util.Arrays;

// 88#, Easy
// 如果从左往右遍历，会改变`nums1`的前面的元素，对后面造成影响
public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0)
        {
            nums1[k--] = nums1[i] > nums2[j] ? nums1[i--] : nums2[j--];
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    public static void main (String[] args) {
        MergeSortedArray msa = new MergeSortedArray();
        int[] a = new int[] {1,2,3,0,0,0};
        int m = 3;
        int[] b = new int[] {2,5,6};
        int n = 3;
        msa.merge(a,m,b,n);
        System.out.println(Arrays.toString(a));
    }
}
