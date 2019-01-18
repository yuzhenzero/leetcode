package com.leetcode;

import java.util.ArrayList;
import java.util.List;

// 17#, Medium
public class LetterCombinationsofaPhoneNumber {
    private final static String[] digitsToChars =
            {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations (String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) return ans;
        helper(digits, 0, new StringBuilder(), ans);
        return ans;

    }

    private void helper (String digits, int i,  StringBuilder cur, List<String> ans) {
        if (digits.length() == i) {
            ans.add(cur.toString());
        } else {
            int digit = Character.getNumericValue(digits.charAt(i)); // 当前考察的数字
            char[] curLetters = digitsToChars[digit].toCharArray(); // 当前考察的数字对应的字母集合

            for (char c : curLetters) {
                cur.append(c);
                helper(digits, i + 1, cur, ans);
                cur.deleteCharAt(i); // 回溯：删掉刚才用过的字母
            }
        }
    }

    public static void main (String[] args) {
        LetterCombinationsofaPhoneNumber lcpn = new LetterCombinationsofaPhoneNumber();
        String digits = "23";
        System.out.println(lcpn.letterCombinations(digits));
    }
}
