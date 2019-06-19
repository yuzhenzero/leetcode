package com.leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * 2019-06-19 21:16
 * 128, Hard
 * @author Yu Zhen
 **/
public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int longest = 0;

        for (Integer num : set) {
            if (!set.contains(num - 1)) {
                int curNum = num;
                int sequenceLength = 1;
                while (set.contains(curNum + 1)) {
                    curNum += 1;
                    sequenceLength += 1;
                }
                longest = Math.max(longest, sequenceLength);
            }
        }
        return longest;
    }

    public static void main (String[] args) {
        LongestConsecutiveSequence longestConsecutiveSequence = new LongestConsecutiveSequence();
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutiveSequence.longestConsecutive(nums));
    }
}
