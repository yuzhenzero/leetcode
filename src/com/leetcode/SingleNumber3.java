package com.leetcode;

import java.util.Arrays;

/**
 * 2019-06-29 15:37
 * 260, Medium
 * @author Yu Zhen
 **/
public class SingleNumber3 {
    public int[] singleNumber (int[] nums) {
        int diff = 0;
        for (int num : nums) {
            diff = diff ^ num;
        }
        diff = diff & (-diff);
        int[] ans = new int[2];
        for (int num : nums) {
            if ((num & diff) == 0)
                ans[0] ^= num;
            else
                ans[1] ^= num;
        }
        return ans;
    }

    public static void main (String[] args) {
        SingleNumber3 test = new SingleNumber3();
        int[] nums = {1, 2, 1, 3, 2, 5};
        int[] ans = test.singleNumber(nums);
        System.out.println(Arrays.toString(ans));
    }
}
