package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 40#, Medium
public class CombinationSum2 {
    public List<List<Integer>> combinationSum2 (int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curList = new ArrayList<>();
        boolean[] visited = new boolean[candidates.length];
        Arrays.sort(candidates);
        backtrack(ans, curList, visited, 0, candidates, target);
        return ans;
    }

    private void backtrack (List<List<Integer>> combinationSum,
                            List<Integer> curList,
                            boolean[] visited,
                            int start,
                            int[] candidates,
                            int target) {
        if (target == 0) {
            combinationSum.add(new ArrayList<>(curList));
        } else {
            for (int i = start; i < candidates.length; i++) {
                if (i != 0 && candidates[i] == candidates[i - 1] && !visited[i - 1]) {
                    continue;
                }
                if (candidates[i] <= target) {
                    visited[i] = true;
                    curList.add(candidates[i]);
                    backtrack(combinationSum,
                            curList,
                            visited,
                            i + 1,
                            candidates,
                            target - candidates[i]);
                    curList.remove(curList.size() - 1);
                    visited[i] = false;
                }

            }
        }
    }

    public static void main (String[] args) {
        CombinationSum2 combinationSum2 = new CombinationSum2();
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(combinationSum2.combinationSum2(candidates, target));
    }
}
