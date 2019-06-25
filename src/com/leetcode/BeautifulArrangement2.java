package com.leetcode;

import java.util.Arrays;

/**
 * 2019-06-25 10:17
 * 667, Medium
 *
 * @author Yu Zhen
 **/
public class BeautifulArrangement2 {
    public int[] constructArray (int n, int k) {
        int[] ans = new int[n];
        ans[0] = 1;
        for (int i = 1, interval = k; i <= k; i++, interval--) {
            ans[i] = i % 2 == 0 ? i / 2 + 1 : k + 1 - i / 2;
        }
        for (int i = k + 1; i < n; i++) {
            ans[i] = i + 1;
        }
        return ans;

    }

    public static void main (String[] args) {
        BeautifulArrangement2 test = new BeautifulArrangement2();
        int[] ans = test.constructArray(3, 2);
        System.out.println(Arrays.toString(ans));
    }
}
