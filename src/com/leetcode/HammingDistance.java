package com.leetcode;

// 461#, Easy
public class HammingDistance {
    public int hammingDistance (int x, int y) {
        int z = x ^ y;
//        System.out.println(Integer.bitCount(z));
        int ans = 0;
        while (z != 0) {
            if ((z & 1) != 0) ans++;
            z >>= 1;
        }
        return ans;
    }

    public static void main (String[] args) {
        HammingDistance hd = new HammingDistance();
        System.out.println(hd.hammingDistance(1, 4));
    }
}
