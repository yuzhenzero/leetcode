package com.leetcode;

/**
 * 2019-06-21 115:27
 * 647, Medium
 *
 * @author Yu Zhen
 **/
public class PalindromicSubstrings {
    private int count = 0;
    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            extendSubstring(s, i, i); // 奇数
            extendSubstring(s, i, i + 1);  // 偶数
        }
        return count;
    }

    private void extendSubstring (String s, int start, int end) {
        while (start >= 0 && end <= s.length() - 1 && s.charAt(start) == s.charAt(end)) {
            count++;
            start--;
            end++;
        }
    }

    public static void main (String[] args) {
        PalindromicSubstrings palindromicSubstrings = new PalindromicSubstrings();
        String s = "abc";
        System.out.println(palindromicSubstrings.countSubstrings(s));
    }
}
