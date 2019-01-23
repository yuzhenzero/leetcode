package com.leetcode;

import java.util.ArrayList;
import java.util.List;

// 78#, Medium
public class Subsets {
    public List<List<Integer>> subsets (int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(0,new ArrayList<>(),ans,nums);
        return ans;
    }

    private void backtrack (int first, ArrayList<Integer> curList, List<List<Integer>> ans,int[] nums) {
        ans.add(new ArrayList<Integer>(curList));
        for (int i = first; i < nums.length;i++) {
            curList.add(nums[i]);
            backtrack(i+1,curList,ans,nums);
            curList.remove(curList.size()-1); // 回溯，删掉用过的元素
        }
    }

    public static void main (String[] args) {
        Subsets subsets = new Subsets();
        int[] nums = {1,2,3};
        System.out.println(subsets.subsets(nums));
    }
}
