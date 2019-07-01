package com.leetcode;

/**
 * 2019-07-01 16:52
 * 693, Easy
 * @author Yu Zhen
 **/
public class BinaryNumberwithAlternatingBits {
    public boolean hasAlternatingBits (int n) {
        int tmp = (n ^ (n >> 1));
        return (tmp & (tmp + 1)) == 0;
    }

    public static void main (String[] args) {
        BinaryNumberwithAlternatingBits test = new BinaryNumberwithAlternatingBits();
        System.out.println(test.hasAlternatingBits(5));
    }
}
