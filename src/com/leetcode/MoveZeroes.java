package com.leetcode;

import java.util.Arrays;
// 283#, Easy
public class MoveZeroes {
    public void moveZeroes(int[] nums)
    {
        int non_zero = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
            {
                int temp = nums[i];
                nums[i] = nums[non_zero];
                nums[non_zero] = temp;
                non_zero++;
            }
        }
    }

    public static void main(String[] args)
    {
        MoveZeroes mz = new MoveZeroes();
        int[] a = {0,1,0,3,12};
        mz.moveZeroes(a);
        System.out.println(Arrays.toString(a));
    }
}
