package com.leetcode.sort;

import java.util.Random;

/**
 * 2019-07-29 10:50
 *
 * @author Yu Zhen
 **/
public class Sort {
    public static void swap (int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static boolean isSorted (int[] nums) {
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 用于随机打乱一组数，并且时间复杂度为 O(N)。
     * <p>
     * 算法的基本思想是，
     * 每次从一组数中随机选出一个数，
     * 然后与最后一个数交换位置，并且不再考虑最后一个数。
     *
     * @param nums 待打乱的数组
     */
    public static void shuffle (int[] nums) {
        Random random = new Random();
        for (int i = nums.length - 1; i >= 0; i--) {
            int j = random.nextInt(i + 1); // [0,i]
            swap(nums, i, j);
        }
    }
}
