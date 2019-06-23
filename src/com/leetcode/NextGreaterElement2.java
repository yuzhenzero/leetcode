package com.leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * 2019-06-23 14:37
 * 503, Medium
 *
 * @author Yu Zhen
 **/
public class NextGreaterElement2 {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        Stack<Integer> pre = new Stack<>();
        for (int i = 0; i < 2 * n; i++) {
            int num = nums[i % n];
            while (!pre.isEmpty() && num > nums[pre.peek()]) {
                ans[pre.pop()] = num;
            }
            if (i < n) {
                pre.push(i);
            }
        }
        return ans;
    }

    public static void main (String[] args) {
        NextGreaterElement2 nextGreaterElement2 = new NextGreaterElement2();
        int[] nums = {1, 2, 1};
        System.out.println(Arrays.toString(nextGreaterElement2.nextGreaterElements(nums)));
    }
}
