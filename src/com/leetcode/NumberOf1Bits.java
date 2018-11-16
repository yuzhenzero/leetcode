package com.leetcode;

// 191#, Easy
public class NumberOf1Bits {
    public int hammingWeight (int n) {
        int mask = 1;
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if ((n&mask) != 0) {
                ans++;
            }
            mask <<=1;
        }
        return ans;
    }

    public static void main (String[] args) {
        NumberOf1Bits nob = new NumberOf1Bits();
        System.out.println(nob.hammingWeight(11));
    }
}
