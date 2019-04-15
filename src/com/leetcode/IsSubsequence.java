package com.leetcode;

// 392#, Medium
public class IsSubsequence {
    public boolean isSubsequence (String s, String t) {
        int index = -1;
        for (char c : s.toCharArray()) {
            index = t.indexOf(c, index + 1);
            if (index == -1)
                return false;
        }
        return true;
    }

    public static void main (String[] args) {
        IsSubsequence is = new IsSubsequence();
        String s = "abc";
        String t = "ahbgdc";
        System.out.println(is.isSubsequence(s, t));
    }
}
