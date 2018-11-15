package com.leetcode;

// 209#, Medium
public class MinimumSizeSubarraySum {
    public int minSubArrayLen(int s, int[] nums)
    {
        int len = nums.length;
        int ans = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        for (int i = 0; i < len; i++) {
            sum += nums[i]; // 把前i个元素累加起来
            while (sum >= s) {
                ans = Math.min(ans, i - left + 1);
                sum -= nums[left++]; // 依次剔除元素，使sum尽量接近s
            }
        }
        return (ans != Integer.MAX_VALUE) ? ans : 0;
    }

    public static void main(String[] args)
    {
        MinimumSizeSubarraySum msss = new MinimumSizeSubarraySum();
        int[] a = {2, 3, 1, 2, 4, 3};
        int s = 7;
        int b = msss.minSubArrayLen(s, a);
        System.out.println(b);
    }

}
