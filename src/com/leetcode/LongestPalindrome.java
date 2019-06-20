package com.leetcode;

/**
 * 2019-06-20 11:35
 * 409, Easy
 *
 * @author Yu Zhen
 **/
public class LongestPalindrome {
    public int longestPalindrome(String s) {
        int[] count = new int[256];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        int longest = 0;
        for (int i : count) {
            longest += (i / 2) * 2;
        }
        if (longest < s.length()) {
            longest++;
        }
        return longest;
    }

    public static void main (String[] args) {
        LongestPalindrome longestPalindrome = new LongestPalindrome();
        String s = "abccccdd";
        System.out.println(longestPalindrome.longestPalindrome(s));
    }
}
