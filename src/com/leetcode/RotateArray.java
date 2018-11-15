package com.leetcode;

import java.util.Arrays;
// 189#, Easy
public class RotateArray {
    public void rotate(int[] nums, int k)
    {
        k %= nums.length; // 如果k大于数组的长度的话，执行第二个第三个reverse()方法，数组索引会越界。
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);

    }

    private void reverse(int[] nums, int left, int right)
    {

        while (left < right) {
            int temp = nums[left];
            nums[left] = nums[right];
            nums[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args)
    {
        RotateArray ra = new RotateArray();
        int[] a = {1, 2, 3, 4, 5, 6, 7};
        ra.rotate(a, 3);
        System.out.println(Arrays.toString(a));

        int[] b = {-1,-100,3,99};
        ra.rotate(b,2);
        System.out.println(Arrays.toString(b));
    }
}
