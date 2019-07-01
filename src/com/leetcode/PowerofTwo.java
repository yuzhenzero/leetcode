package com.leetcode;

/**
 * 2019-07-01 16:30
 * 231, Easy
 *
 * @author Yu Zhen
 **/
public class PowerofTwo {
    public boolean isPowerOfTwo (int n) {
        return Integer.bitCount(n) == 1;
    }

    public static void main (String[] args) {
        PowerofTwo test = new PowerofTwo();
        System.out.println(test.isPowerOfTwo(128));
    }
}
