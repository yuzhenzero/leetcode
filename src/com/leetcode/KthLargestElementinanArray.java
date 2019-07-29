package com.leetcode;

import java.util.Arrays;
import java.util.PriorityQueue;

// 215#, Medium
public class KthLargestElementinanArray {

    // 调用排序方法
    public int findKthLargest (int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    // 堆排序法
    public int findKthLargest1 (int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(); // 默认是小顶堆
        for (int num : nums) {
            pq.add(num);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    // 快速选择法
    public int findKthLargest2 (int[] nums, int k) {
        k = nums.length - k;
        int l = 0, h = nums.length - 1;
        while (l < h) {
            int j = partition(nums, l, h);
            if (j == k) {
                break;
            } else if (j < k) {
                l = j + 1;
            } else {
                h = j - 1;
            }
        }
        return nums[k];
    }

    private int partition (int[] nums, int lo, int hi) {
        int pivot = lo;
        int index = pivot + 1;
        for (int i = index; i <= hi; i++) {
            if (nums[i] < nums[pivot]) {
                swap(nums, i, index);
                index++;
            }
        }
        swap(nums, pivot, index - 1);
        return index - 1;
    }

    private void swap (int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main (String[] args) {
        KthLargestElementinanArray klea = new KthLargestElementinanArray();
        int[] nums = {3, 2, 1, 5, 6, 4};
        System.out.println(klea.findKthLargest1(nums, 2));
    }


}
