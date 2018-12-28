package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 15#, Medium
public class ThreeSum {
    public List<List<Integer>> threeSum (int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if (nums.length < 3) {
            return ans;
        }

        Arrays.sort(nums);

        for (int i = 0; i + 2 < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int j = i + 1;
            int k = nums.length - 1;
            int target = -nums[i];
            while (j < k) {
                if (nums[j] + nums[k] == target) {
                    ans.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    while (j < k && nums[j] == nums[j - 1]) j++;
                    while (j < k && nums[k] == nums[k + 1]) k--;
                } else if (nums[j] + nums[k] < target) {
                    j++;
                } else {
                   k--;
                }
            }
        }
        return ans;
    }

    public static void main (String[] args) {
        ThreeSum ts = new ThreeSum();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(ts.threeSum(nums));

    }
}
