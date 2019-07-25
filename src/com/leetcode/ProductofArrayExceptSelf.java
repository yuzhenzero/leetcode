package com.leetcode;

import java.util.Arrays;

/**
 * 2019-07-25 21:08
 * 238, Medium
 *
 * @author Yu Zhen
 **/
public class ProductofArrayExceptSelf {
    public int[] productExceptSelf (int[] nums) {
        int n = nums.length;
        int left = 1;
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        for (int i = 1; i < n; i++) {
            left *= nums[i - 1];
            ans[i] *= left;
        }
        int right = 1;
        for (int i = n - 2; i >= 0; i--) {
            right *= nums[i + 1];
            ans[i] *= right;
        }
        return ans;
    }

    public static void main (String[] args) {
        ProductofArrayExceptSelf test = new ProductofArrayExceptSelf();
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(test.productExceptSelf(nums)));
    }
}
