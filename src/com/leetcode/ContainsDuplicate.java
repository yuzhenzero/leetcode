package com.leetcode;

import java.util.HashSet;
import java.util.Set;

// 217#, Easy
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums)
    {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int num : nums) {
            if (set.contains(num))
                return true;
            set.add(num);
        }
        return false;
    }

    public static void main(String[] args)
    {
        ContainsDuplicate cd = new ContainsDuplicate();
        int[] a = {1, 2, 3, 1};
        int[] b = {1, 2, 3, 4};
        int[] c = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println(cd.containsDuplicate(a));
        System.out.println(cd.containsDuplicate(b));
        System.out.println(cd.containsDuplicate(c));
    }
}
