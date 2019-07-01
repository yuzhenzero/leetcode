package com.leetcode;

/**
 * 2019-07-01 16:36
 * 342, Easy
 *
 * @author Yu Zhen
 **/
public class PowerofFour {
    public boolean isPowerOfFour (int num) {
        return Integer.toString(num, 4).matches("10*");
    }

    public static void main (String[] args) {
        System.out.println(Integer.toString(16, 4));
        PowerofFour test = new PowerofFour();
        System.out.println(test.isPowerOfFour(16));
    }
}
