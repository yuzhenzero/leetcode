package com.leetcode;

/**
 * 2019-06-21 15:08
 * 205, Easy
 * @author Yu Zhen
 **/
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        int[] lastIndexOfS = new int[256];
        int[] lastIndexOfT = new int[256];
        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);
            if (lastIndexOfS[charS] != lastIndexOfT[charT]) {
                return false;
            }
            lastIndexOfS[charS] = i + 1;
            lastIndexOfT[charT] = i + 1;
        }
        return true ;
    }

    public static void main (String[] args) {
        IsomorphicStrings isomorphicStrings = new IsomorphicStrings();
        String s = "add";
        String t = "egg";
        String z = "abc";
        System.out.println(isomorphicStrings.isIsomorphic(s,z));
    }
}
