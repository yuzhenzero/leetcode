package com.leetcode;

/**
 * 2019-07-01 19:20
 * 318, Medium
 *
 * @author Yu Zhen
 **/
public class MaximumProductofWordLengths {
    public int maxProduct (String[] words) {
        int n = words.length;
        int[] var = new int[n];
        for (int i = 0; i < n; i++) {
            String word = words[i];
            for (char c : word.toCharArray()) {
                var[i] |= 1 << (c - 'a');
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((var[i] & var[j]) == 0) {
                    ans = Math.max(ans, words[i].length() * words[j].length());
                }
            }

        }
        return ans;
    }

    public static void main (String[] args) {
        MaximumProductofWordLengths test = new MaximumProductofWordLengths();
        String[] words = {"abcw", "baz", "foo", "bar", "xtfn", "abcdef"};
        System.out.println(test.maxProduct(words));
    }

}
