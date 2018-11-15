package com.leetcode;
// 136#, Easy
public class SingleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int i : nums) {
            result ^= i;
        }
        return result;
    }

    public static void main(String[] args)
    {
        SingleNumber sn = new SingleNumber();
        int[] a = {2,2,1};
        System.out.println(sn.singleNumber(a));
    }
}
