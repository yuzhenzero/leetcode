package com.leetcode;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring (String s) {
        if (s.length() == 0) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int length = s.length();
        int ans = 0, i = 0, j = 0;
        while (i < length && j < length) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public static void main (String[] args) {
        LongestSubstringWithoutRepeatingCharacters lswrc
                 = new LongestSubstringWithoutRepeatingCharacters();
        String s = "pwwkew";
        System.out.println(lswrc.lengthOfLongestSubstring(s));

    }
}
