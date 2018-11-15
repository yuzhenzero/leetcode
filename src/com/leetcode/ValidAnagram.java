package com.leetcode;

import java.util.Arrays;

// 242#, Easy
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        char[] c_s = s.toCharArray();
        char[] c_t = t.toCharArray();
        Arrays.sort(c_s);
        Arrays.sort(c_t);

        return Arrays.equals(c_s,c_t);
    }

    public static void main(String[] args)
    {
        ValidAnagram va = new ValidAnagram();
        String s = "rat";
        String t = "car";
        System.out.println(va.isAnagram(s,t));
    }
}
