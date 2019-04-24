package com.leetcode;

import java.util.ArrayList;
import java.util.List;

// 131#, Medium
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<String>(), s);
        return ans;
    }

    private void backtrack (List<List<String>> partitions,
                            List<String> curList,
                            String s) {
        if (s.length() == 0) {
            partitions.add(new ArrayList<>(curList));
        } else {
            for (int i = 0; i < s.length(); i++) {
                if (isPalindrome(s, 0, i)) {
                    curList.add(s.substring(0, i + 1));
                    backtrack(partitions, curList, s.substring(i + 1));
                    curList.remove(curList.size() - 1);
                }
            }
        }
    }

    private boolean isPalindrome (String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }

    public static void main (String[] args) {
        PalindromePartitioning palindromePartitioning = new PalindromePartitioning();
        String s = "aab";
        System.out.println(palindromePartitioning.partition(s));
    }
}
