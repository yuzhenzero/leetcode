package com.leetcode;

// 485#, Easy
public class MaxConsecutiveOnes {
    public int findMaxConsecutiveOnes (int[] nums) {
        int max_num = 0;

        int max_temp = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] == 1) {
                max_temp++;
            }
            if (nums[i] == 0) {
                max_temp = 0;
            }

            if (max_temp > max_num) {
                max_num = max_temp;
            }
        }

        return max_num;
    }

    public int findMaxConsecutiveOnes2 (int[] nums) {
        int max = 0, count = 0;
        for (int num : nums) {
            count = num == 1 ? count + 1 : 0;
            max = Math.max(count, max);
        }
        return max;
    }

    public static void main (String[] args) {
        MaxConsecutiveOnes mco = new MaxConsecutiveOnes();
        int[] a = {1, 1, 0, 1, 1, 1};
        System.out.println(mco.findMaxConsecutiveOnes2(a));
    }
}
