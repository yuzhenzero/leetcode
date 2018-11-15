package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> temp = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int compensation = target - nums[i];
            if (temp.containsKey(compensation)) {
                return new int[] {temp.get(compensation), i};
            }else {
                temp.put(nums[i], i);
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    public static void main(String[] args)
    {
        TwoSum ts = new TwoSum();
        int[] nums = {3,2,4};
        int target = 6;
        System.out.println(Arrays.toString(ts.twoSum(nums, target)));
    }
}
