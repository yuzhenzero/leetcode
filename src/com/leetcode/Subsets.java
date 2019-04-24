package com.leetcode;

import java.util.ArrayList;
import java.util.List;

// 78#, Medium
public class Subsets {
    public List<List<Integer>> subsets (int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int size = 0; size <= nums.length; size++) {
            backtrack(0,size,new ArrayList<>(),ans,nums);
        }
        return ans;
    }

    private void backtrack (int start,int size, ArrayList<Integer> curList, List<List<Integer>> subsets,int[] nums) {
        if (curList.size() == size) {
            subsets.add(new ArrayList<>(curList));
        } else {
            for (int i = start; i < nums.length; i++) {
                curList.add(nums[i]);
                backtrack(i + 1, size, curList, subsets, nums);
                curList.remove(curList.size() - 1);
            }
        }
    }

    public static void main (String[] args) {
        Subsets subsets = new Subsets();
        int[] nums = {1,2,3};
        System.out.println(subsets.subsets(nums));
    }
}
