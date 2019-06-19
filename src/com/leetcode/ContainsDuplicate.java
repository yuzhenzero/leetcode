package com.leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

// 217#, Easy
public class ContainsDuplicate {
    // 利用 HashSet
    public boolean containsDuplicate (int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        return set.size() < nums.length;
    }

    // 先将数组排序
    public boolean containsDuplicateBySort (int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }

    public static void main (String[] args) {
        ContainsDuplicate cd = new ContainsDuplicate();
        int[] a = {1, 2, 3, 1};
        int[] b = {1, 2, 3, 4};
        int[] c = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println(cd.containsDuplicate(a));
        System.out.println(cd.containsDuplicate(b));
        System.out.println(cd.containsDuplicate(c));
    }
}
