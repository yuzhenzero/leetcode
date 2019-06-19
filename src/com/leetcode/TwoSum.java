package com.leetcode;

import java.util.Arrays;
import java.util.HashMap;
// 1#, Easy
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> indexOfNums = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int compensation = target - nums[i];
            if (indexOfNums.containsKey(compensation)) {
                return new int[]{indexOfNums.get(compensation), i};
            }else {
                indexOfNums.put(nums[i], i);
            }
        }
        return null;
    }

    public static void main(String[] args)
    {
        TwoSum ts = new TwoSum();
        int[] nums = {3,2,4};
        int target = 6;
        System.out.println(Arrays.toString(ts.twoSum(nums, target)));
    }
}
