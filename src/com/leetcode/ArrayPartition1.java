package com.leetcode;

import java.util.Arrays;

// 561#, Easy
public class ArrayPartition1 {
    public int arrayPairSum(int[] nums)
    {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i+=2)
        {
            sum += nums[i];
        }
        return sum;
    }

    public static void main(String[] args)
    {
        ArrayPartition1 ap1 = new ArrayPartition1();
        int[] a = {1,2,3,4};
        System.out.println(ap1.arrayPairSum(a));
    }
}
