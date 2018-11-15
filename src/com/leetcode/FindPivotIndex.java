package com.leetcode;
// #724
public class FindPivotIndex {
    public int pivotIndex(int[] nums)
    {
        int sum = 0;
        for (int num :
                nums) {
            sum += num;
        }
        int sum_left = 0;
        for (int p = 0; p<nums.length; p++)
        {
            if (p!=0)
            {
                sum_left += nums[p-1];
            }
            int sum_right = sum - nums[p] - sum_left;


            if (sum_left == sum_right)
                return p;
        }
        return -1;
    }

    public static void main(String[] args)
    {
        FindPivotIndex fpi = new FindPivotIndex();
        int[] a = new int[] {1, 7, 3, 6, 5, 6};
        int[] b = new int[] {1, 2, 3};
        int[] c = new int[] {0,-1,1};

        System.out.println(fpi.pivotIndex(a));
        System.out.println(fpi.pivotIndex(b));
        System.out.println(fpi.pivotIndex(c));
    }
}
