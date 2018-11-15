package com.leetcode;
// 747#

public class LargestNumberAtLeastTwiceofOthers {
    public int dominantIndex(int[] nums)
    {
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= nums[maxIndex])
                maxIndex = i;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != nums[maxIndex] && nums[maxIndex] < 2 * nums[i])
                return -1;
        }
        return maxIndex;
    }

    public static void main(String[] args)
    {
        LargestNumberAtLeastTwiceofOthers ln = new LargestNumberAtLeastTwiceofOthers();
        int[] a = new int[]{3, 6, 1, 0};
        System.out.println(ln.dominantIndex(a));
        int[] b = new int[]{1, 2, 3, 4};
        System.out.println(ln.dominantIndex(b));
    }
}
