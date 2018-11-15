package com.leetcode;

import java.util.Arrays;
import java.util.Random;

// 384#, Medium
public class ShuffleAnArray {
    private int[] array;
    private int[] copy;

    private Random random = new Random();

    private void swap (int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private int randomRange (int min, int max) {
        return random.nextInt(max - min) + min;
    }

    public ShuffleAnArray(int[] nums) {
        array = nums;
        copy = nums.clone();
    }

    public int[] reset() {
        array = copy;
        copy = copy.clone();
        return array;
    }

    public int[] shuffle () {
        for (int i = 0; i < array.length; i++) {
            swap(i,randomRange(i,array.length));
        }
        return array;
    }

    public static void main (String[] args) {
        int[] nums = {1,2,3};
        ShuffleAnArray saa = new ShuffleAnArray(nums);
        int[] param_1 = saa.shuffle();
        System.out.println(Arrays.toString(param_1));
        int[] param_2 = saa.reset();
        System.out.println(Arrays.toString(param_2));

    }
}
