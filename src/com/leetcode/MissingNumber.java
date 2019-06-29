package com.leetcode;

import java.util.HashSet;

// 268#, Easy
public class MissingNumber {
    public int missingNumber (int[] nums) {
        int len = nums.length;
        int ans = -1;
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i : nums) {
            set.add(i);
        }
        for (int i = 0; i < len + 1; i++) {
            if (!set.contains(i)) {
                ans = i;
            }
        }
        return ans;
    }

    public int missingNumber_2 (int[] nums) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += i;
            sum -= nums[i];
        }
        return sum + nums.length;
    }

    public int missingNumber_3 (int[] nums) {
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing = missing ^ i ^ nums[i];
        }
        return missing;
    }

    public static void main (String[] args) {
        MissingNumber mn = new MissingNumber();
        int[] nums = {3, 0, 1};
        System.out.println(mn.missingNumber_3(nums));
    }
}
