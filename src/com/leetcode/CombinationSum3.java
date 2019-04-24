package com.leetcode;

import java.util.ArrayList;
import java.util.List;

// 216#, Medium
public class CombinationSum3 {
    public List<List<Integer>> combinationSum3 (int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), 1, k, n);
        return ans;
    }

    private void backtrack (List<List<Integer>> combinationSum,
                            List<Integer> curList,
                            int start,
                            int k,
                            int n) {
        if (k == 0 && n == 0) {
            combinationSum.add(new ArrayList<>(curList));
        } else {
            for (int i = start; i <= 9; i++) {

                if (i <= n) {
                    curList.add(i);
                    backtrack(combinationSum, curList, i + 1, k - 1, n-i);
                    curList.remove(curList.size() - 1);
                }
            }
        }
    }

    public static void main (String[] args) {
        CombinationSum3 combinationSum3 = new CombinationSum3();
        int k = 3, n = 7;
        System.out.println(combinationSum3.combinationSum3(k, n));
    }
}
