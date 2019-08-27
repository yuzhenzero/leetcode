package com.leetcode;

/**
 * 2019-08-08 11:15
 * 287, Medium
 *
 * @author Yu Zhen
 **/
public class FindtheDuplicateNumber {
    public int findDuplicate (int[] nums) {
        int slow = nums[0], fast = nums[nums[0]];
        while (fast != slow) {
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        fast = 0;
        while (fast != slow) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public static void main (String[] args) {
        FindtheDuplicateNumber test = new FindtheDuplicateNumber();
        int[] nums = {1, 3, 4, 2, 2};
        System.out.println(test.findDuplicate(nums));
    }
}
