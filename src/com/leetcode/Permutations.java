package com.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// 46#, Medium
public class Permutations {
    public List<List<Integer>> permute (int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> curList = new ArrayList<>();
        for (int num : nums) {
            curList.add(num);
        }
        int n = nums.length;
        backtrack(0, curList, n, ans);

        return ans;
    }

    private void backtrack (int first, ArrayList<Integer> curList, int n, List<List<Integer>> ans) {
        if (first == n) {
            ans.add(new ArrayList<Integer>(curList));
        }

        for (int i = first; i < n; i++) {
            Collections.swap(curList, first, i);
            backtrack(first + 1, curList, n, ans);
            Collections.swap(curList, first, i); // 回溯，使数组回到原来的样子重新操作
        }

    }

    public static void main (String[] args) {
        Permutations p = new Permutations();
        int[] nums = {1, 2, 3};
        System.out.println(p.permute(nums));
    }

}
