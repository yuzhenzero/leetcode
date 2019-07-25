package com.leetcode;

/**
 * 2019-07-25 09:37
 * 583, Medium
 *
 * @author Yu Zhen
 **/
public class DeleteOperationforTwoStrings {
    public int minDistance (String word1, String word2) {
        int m = word1.length(), n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return m + n - 2 * dp[m][n];
    }

    public static void main (String[] args) {
        DeleteOperationforTwoStrings test = new DeleteOperationforTwoStrings();
        String word1 = "fish";
        String word2 = "gosh";
        System.out.println(test.minDistance(word1, word2));
    }


}
