package com.leetcode;
// 485#, Easy
public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums)
    {
        int max_num = 0;

        int max_temp = 0;
        for (int i = 0; i < nums.length; i++)
        {

            if (nums[i] == 1)
            {
                max_temp++;
            }
            if (nums[i] == 0)
            {
                max_temp = 0;
            }

            if (max_temp > max_num) {
                max_num = max_temp;
            }
        }

        return max_num;
    }

    public static void main(String[] args)
    {
        MaxConsecutiveOnes mco = new MaxConsecutiveOnes();
        int[] a = {1,1,0,1,1,1};
        System.out.println(mco.findMaxConsecutiveOnes(a));
    }
}
