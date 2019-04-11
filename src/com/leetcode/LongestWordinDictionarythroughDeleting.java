package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestWordinDictionarythroughDeleting {
    public String findLongestWord(String s, List<String> d) {
        String longestWord = "";
        for (String str : d){
            int l1 = longestWord.length();
            int l2 = str.length();
            if (isSubsequence(s, str)){
                if (l2 > l1 || (l2 == l1) && str.compareTo(longestWord)<0)
                    longestWord = str;
            }
        }
        return longestWord;
    }

    private boolean isSubsequence(String s, String target){
        int i = 0, j = 0;
        while (i < s.length() && j < target.length()){
            if (s.charAt(i) == target.charAt(j))
                j++;
            i++;
        }
        return j == target.length();
    }

    public static void main (String[] args) {
        LongestWordinDictionarythroughDeleting lwdd = new LongestWordinDictionarythroughDeleting();
        String s = "abpcplea";
        List<String> d = new ArrayList<String>(Arrays.asList("ale","apple","monkey","plea"));
        System.out.println(lwdd.findLongestWord(s,d));
    }
}
