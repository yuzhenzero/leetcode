package com.leetcode;

import java.util.Arrays;

/**
 * 2019-07-25 21:43
 * 169, Easy
 *
 * @author Yu Zhen
 **/
public class MajorityElement {
    public int majorityElement (int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }

    public int majorityElement2 (int[] nums) {
        int majority = nums[0];
        int count = 0;
        for (int num : nums) {
            if (count == 0) {
                majority = num;
            }
            count += (num == majority ? 1 : -1);
        }
        return majority;
    }

    public static void main (String[] args) {
        MajorityElement test = new MajorityElement();
        int[] nums = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(test.majorityElement(nums));
    }
}
