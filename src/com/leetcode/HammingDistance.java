package com.leetcode;

// 461#, Easy
public class HammingDistance {
    public int hammingDistance (int x, int y) {
        int temp = x^y;
        int mask = 1;
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            if ((temp&mask) != 0) {
                ans++;
            }
            mask <<=1;
        }
        return ans;
    }

    public static void main (String[] args) {
        HammingDistance hd = new HammingDistance();
        System.out.println(hd.hammingDistance(1,4));
    }
}
