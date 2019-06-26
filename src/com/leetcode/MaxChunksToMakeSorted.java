package com.leetcode;

/**
 * 2019-06-26 09:57
 * 769, Medium
 *
 * @author Yu Zhen
 **/
public class MaxChunksToMakeSorted {
    public int maxChunksToSorted (int[] arr) {
        int ans = 0;
        int leftMax = arr[0];
        for (int i = 0; i < arr.length; i++) {
            leftMax = Math.max(leftMax, arr[i]);
            if (leftMax == i) ans++;
        }
        return ans;
    }

    public static void main (String[] args) {
        MaxChunksToMakeSorted test = new MaxChunksToMakeSorted();
        int[] arr = {1, 0, 2, 3, 4};
        System.out.println(test.maxChunksToSorted(arr));
    }
}
