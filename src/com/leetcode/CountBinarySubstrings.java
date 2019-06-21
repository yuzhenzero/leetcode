package com.leetcode;

/**
 * 2019-06-21 16:21
 * 696, Easy
 * @author Yu Zhen
 **/
public class CountBinarySubstrings {
    public int countBinarySubstrings(String s) {
        int ans = 0, pre = 0, cur = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                cur++;
            } else {
                pre = cur;
                cur = 1;
            }
            if (pre >= cur) {
                ans++;
            }
        }
        return ans;
    }

    public static void main (String[] args) {
        CountBinarySubstrings countBinarySubstrings = new CountBinarySubstrings();
        String s = "000011100";
        System.out.println(countBinarySubstrings.countBinarySubstrings(s));
    }
}
