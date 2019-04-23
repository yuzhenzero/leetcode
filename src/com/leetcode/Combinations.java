package com.leetcode;

import java.util.ArrayList;
import java.util.List;

// 77#, Medium
public class Combinations {
    public List<List<Integer>> combine (int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curList = new ArrayList<>();
        backtrack(curList, ans, 1, n, k);
        return ans;
    }

    private void backtrack (List<Integer> curList,
                            List<List<Integer>> combinations,
                            int start,
                            int n,
                            int k) {
        if (k == 0) {
            combinations.add(new ArrayList<>(curList));
        } else {
            for (int i = start; i <= n - k + 1; i++) {
                curList.add(i);
                backtrack(curList, combinations, i + 1, n, k-1);
                curList.remove(curList.size() - 1);
            }
        }
    }

    public static void main (String[] args) {
        Combinations combinations = new Combinations();
        System.out.println(combinations.combine(4, 2));
    }
}
