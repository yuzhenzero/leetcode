package com.leetcode;

import java.util.Arrays;

/**
 * 2019-06-30 21:34
 * 338, Medium
 *
 * @author Yu Zhen
 **/
public class CountingBits {
    public int[] countBits (int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            ans[i] = Integer.bitCount(i);
        }
        return ans;
    }

    public int[] countBits2 (int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; i++) {
            ans[i] = ans[i & (i - 1)] + 1;
        }
        return ans;
    }

    public static void main (String[] args) {
        CountingBits test = new CountingBits();
        int[] ans = test.countBits2(5);
        System.out.println(Arrays.toString(ans));
    }
}
