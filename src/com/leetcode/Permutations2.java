package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 47#, Medium
public class Permutations2 {
    public List<List<Integer>> permuteUnique (int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> curList = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        backtrack(curList, ans, visited, nums);

        return ans;
    }

    /**
     * 回溯法
     * @param curList 当前正在处理的字符串
     * @param permutations 排列组合结果集合
     * @param visited 标记当前递归链已经访问过的元素
     * @param nums 给定数组
     */
    private void backtrack (List<Integer> curList,
                            List<List<Integer>> permutations,
                            boolean[] visited,
                            int[] nums) {
        if (curList.size() == nums.length) {
            permutations.add(new ArrayList<>(curList));
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (i != 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                    continue;
                }
                if (visited[i]) {
                    continue;
                }
                visited[i] = true;
                curList.add(nums[i]);
                backtrack(curList, permutations, visited, nums);
                curList.remove(curList.size() - 1);
                visited[i] = false;
            }
        }
    }

    public static void main (String[] args) {
        Permutations2 p2 = new Permutations2();
        int[] nums = {1, 1, 2};
        System.out.println(p2.permuteUnique(nums));

    }
}
