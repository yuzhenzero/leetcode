package com.leetcode;

import java.util.Arrays;

// 167#, Easy
public class TwoSum2 {
    public int[] twoSum(int[] numbers, int target)
    {
        int[] result = new int[2];
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] == target) {
                result[0] = i + 1;
                result[1] = j + 1;
                break;
            } else if (numbers[i] + numbers[j] < target) {
                i++;
            } else {
                j--;
            }
        }
        return result;
    }

    public static void main(String[] args)
    {
        TwoSum2 ts2 = new TwoSum2();
        int[] num = {2, 7, 11, 15};
        int tar = 9;
        System.out.println(Arrays.toString(ts2.twoSum(num, tar)));
    }
}
