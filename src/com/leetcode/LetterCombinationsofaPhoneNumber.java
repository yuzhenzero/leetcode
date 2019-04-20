package com.leetcode;

import java.util.ArrayList;
import java.util.List;

// 17#, Medium
public class LetterCombinationsofaPhoneNumber {
    private final static String[] digitsToChars =
            {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations (String digits) {
        List<String> ans = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return ans;
        }
        doCombination(new StringBuilder(), ans, digits);
        return ans;
    }

    private void doCombination (StringBuilder prefix, List<String> combination, String digits) {
        if (prefix.length() == digits.length()) {
            combination.add(prefix.toString());
        } else {
            int curDiggit = digits.charAt(prefix.length()) - '0';
            for (char c : digitsToChars[curDiggit].toCharArray()) {
                prefix.append(c);
                doCombination(prefix,combination,digits);
                prefix.deleteCharAt(prefix.length() - 1);
            }
        }
    }

    public static void main (String[] args) {
        LetterCombinationsofaPhoneNumber lcpn = new LetterCombinationsofaPhoneNumber();
        String digits = "23";
        System.out.println(lcpn.letterCombinations(digits));
    }
}
