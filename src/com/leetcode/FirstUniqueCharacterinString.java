package com.leetcode;

import java.util.Arrays;
// 387#, Easy
public class FirstUniqueCharacterinString {
    public int firstUniqChar(String s) {
        int freq[] = new int[26];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (freq[s.charAt(i) - 'a'] == 1)
                return i;
        }
        return -1;
    }

    public static void main(String[] args)
    {
        String s = "leetcode";
        FirstUniqueCharacterinString fucs = new FirstUniqueCharacterinString();
        int ans = fucs.firstUniqChar(s);
        System.out.println(ans);
    }
}
