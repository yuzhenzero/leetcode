package com.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 2019-06-19 20:54
 * 594, Easy
 * @author Yu Zhen
 **/
public class LongestHarmoniousSubsequence {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> freqForNum = new HashMap<>();
        for (int num : nums) {
            freqForNum.put(num, freqForNum.getOrDefault(num, 0) + 1);
        }
        int longest = 0;
        for (Integer integer : freqForNum.keySet()) {
            if (freqForNum.containsKey(integer + 1)) {
                longest = Math.max(longest, freqForNum.get(integer) + freqForNum.get(integer + 1));
            }
        }
        return longest;
    }

    public static void main (String[] args) {
        LongestHarmoniousSubsequence longestHarmoniousSubsequence = new LongestHarmoniousSubsequence();
        int[] nums = {1, 3, 2, 2, 5, 2, 3, 7};
        System.out.println(longestHarmoniousSubsequence.findLHS(nums));
    }
}
