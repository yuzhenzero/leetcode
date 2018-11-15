package com.leetcode;

// 27#, Easy
public class RemoveElement {
    public int removeElement(int[] nums, int val)
    {
        int k = 0;
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

    public static void main(String[] args)
    {
        RemoveElement re = new RemoveElement();
        int[] nums  = {0,1,2,2,3,0,4,2};
        int var = 2;
        int len = re.removeElement(nums, var);
        for (int i = 0;i < len; i++)
            System.out.println(nums[i]);
    }

}
