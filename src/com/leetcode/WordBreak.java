package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2019-07-23 20:13
 * 139, Medium
 *
 * @author Yu Zhen
 **/
public class WordBreak {
    public boolean wordBreak (String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (String word : wordDict) {
                int length = word.length();
                if (length <= i && word.equals(s.substring(i - length, i))) {
                    dp[i] = dp[i] || dp[i - length];
                }
            }
        }
        return dp[n];
    }

    public static void main (String[] args) {
        WordBreak test = new WordBreak();
        String s = "leetcode";
        String[] dict = {"leet", "code"};
        List<String> wordDict = new ArrayList<>(Arrays.asList(dict));
        System.out.println(test.wordBreak(s, wordDict));
    }
}
