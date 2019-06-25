package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 2019-06-25 11:01
 * 697, Easy
 *
 * @author Yu Zhen
 **/
public class DegreeofanArray {
    public int findShortestSubArray (int[] nums) {
        Map<Integer, Integer> firstIndex = new HashMap<>();
        Map<Integer, Integer> lastIndex = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            count.put(num, count.getOrDefault(num, 0) + 1);
            lastIndex.put(num, i);
            if (!firstIndex.containsKey(num)) {
                firstIndex.put(num, i);
            }
        }
        int degree = 0;
        for (int num : nums) {
            degree = Math.max(degree, count.get(num));
        }
        int ans = nums.length;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            int cnt = count.get(num);
            if (cnt != degree) continue;
            ans = Math.min(ans, lastIndex.get(num) - firstIndex.get(num) + 1);
        }
        return ans;
    }

    public static void main (String[] args) {
        DegreeofanArray test = new DegreeofanArray();
        int[] nums = {1, 2, 2, 3, 1};
        System.out.println(test.findShortestSubArray(nums));
    }
}
