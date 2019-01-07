package com.leetcode;

// 5#， Medium
public class LongestPalindromicSubstring {
    public String longestPalindrome (String s) {
        if (s == null || s.length() == 0) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i); // 一字母回文拓展
            int len2 = expandAroundCenter(s, i, i + 1); // 二字母回文拓展
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    // 返回一个回文字串的长度
    private int expandAroundCenter (String s, int l, int r) {
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        return r - l - 1;
    }

    public static void main (String[] args) {
        LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
        String s = "babad";
        System.out.println(lps.longestPalindrome(s));
    }
}
