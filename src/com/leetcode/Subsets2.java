package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets2 {
    public List<List<Integer>> subsetsWithDup (int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        for (int size = 0; size <= nums.length; size++) {
            backtrack(ans,new ArrayList<>(),visited,0,size,nums);
        }
        return ans;
    }

    private void backtrack (List<List<Integer>> subsets,
                            List<Integer> curList,
                            boolean[] visited,
                            int start,
                            int size,
                            int[] nums) {
        if (curList.size() == size) {
            subsets.add(new ArrayList<>(curList));
        } else {
            for (int i = start; i < nums.length; i++) {
                if (i != 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                    continue;
                }

                visited[i] = true;
                curList.add(nums[i]);
                backtrack(subsets, curList, visited, i + 1, size, nums);
                curList.remove(curList.size() - 1);
                visited[i] = false;
            }
        }
    }

    public static void main (String[] args) {
        Subsets2 subsets2 = new Subsets2();
        int[] nums = {1, 2, 2};
        System.out.println(subsets2.subsetsWithDup(nums));
    }
}
