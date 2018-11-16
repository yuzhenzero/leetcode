package com.leetcode;

// 190#, Easy
public class ReverseBits {
    public int reverseBits (int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans += (n&1);
            n >>>= 1;
            if (i < 31)
                ans <<= 1;
        }
        return ans;
    }

    public static void main (String[] args) {
        ReverseBits rb = new ReverseBits();
        System.out.println(rb.reverseBits(43261596));
    }
}
