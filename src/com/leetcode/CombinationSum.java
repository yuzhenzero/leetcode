package com.leetcode;

import java.util.ArrayList;
import java.util.List;

// 39#, Medium
public class CombinationSum {
    public List<List<Integer>> combinationSum (int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curList = new ArrayList<>();
        backtrack(curList, ans, 0, candidates, target);
        return ans;
    }

    private void backtrack (List<Integer> curList,
                            List<List<Integer>> combinationSum,
                            int start,
                            int[] candidates,
                            int target) {
        if (target == 0) {
            combinationSum.add(new ArrayList<>(curList));
        } else {
            for (int i = start; i < candidates.length; i++) {
                if (candidates[i] <= target) {
                    curList.add(candidates[i]);
                    backtrack(curList,
                            combinationSum,
                            i,
                            candidates,
                            target - candidates[i]);
                    curList.remove(curList.size() - 1);
                }
            }

        }
    }

    public static void main (String[] args) {
        CombinationSum cs = new CombinationSum();
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(cs.combinationSum(candidates, target));
    }
}
