package com.leetcode;

/**
 * 2019-07-01 17:08
 * 476, Easy
 *
 * @author Yu Zhen
 **/
public class NumberComplement {
    public int findComplement (int num) {
        if (num == 0) return 1;
        int mask = Integer.highestOneBit(num);
        mask = (mask << 1) - 1;
        return num ^ mask;
    }

    public static void main (String[] args) {
        NumberComplement test = new NumberComplement();
        System.out.println(test.findComplement(5));
    }
}
