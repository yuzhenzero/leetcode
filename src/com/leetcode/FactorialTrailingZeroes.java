package com.leetcode;

/**
 * 2019-07-25 19:39
 * 172, Easy
 *
 * @author Yu Zhen
 **/
public class FactorialTrailingZeroes {
    public int trailingZeroes (int n) {
        return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
    }

    public static void main (String[] args) {
        FactorialTrailingZeroes test = new FactorialTrailingZeroes();
        int n = 26;
        System.out.println(test.trailingZeroes(n));
    }
}
