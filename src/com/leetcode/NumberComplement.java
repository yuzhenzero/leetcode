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

    public int findComplement2 (int num) {
        int mask = num;
        mask |= mask >> 1;
        mask |= mask >> 2;
        mask |= mask >> 4;
        mask |= mask >> 8;
        mask |= mask >> 16;
        return (mask ^ num);
    }

    public static void main (String[] args) {
        NumberComplement test = new NumberComplement();
        System.out.println(test.findComplement2(5));
    }
}
