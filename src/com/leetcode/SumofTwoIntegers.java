package com.leetcode;

/**
 * 2019-07-01 18:57
 * 371, Easy
 *
 * @author Yu Zhen
 **/
public class SumofTwoIntegers {
    public int getSum (int a, int b) {
        return b == 0 ? a ^ b : getSum(a ^ b, (a & b) << 1);
    }

    public static void main (String[] args) {
        SumofTwoIntegers test = new SumofTwoIntegers();
        System.out.println(test.getSum(2, 3));
    }
}
