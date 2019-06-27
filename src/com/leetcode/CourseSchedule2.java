package com.leetcode;

import java.util.*;

/**
 * 2019-06-27 14:51
 * 210, Medium
 *
 * @author Yu Zhen
 **/
public class CourseSchedule2 {
    private List<Integer>[] adj;
    private Set<Integer> visitedPerm = new HashSet<>();
    private Set<Integer> visitedTmp = new HashSet<>();
    private Stack<Integer> postOrder = new Stack<>();

    public int[] findOrder (int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return new int[0];
        }
        if (prerequisites.length == 0) {
            int[] ans = new int[numCourses];
            for (int i = 0; i < ans.length; i++) {
                ans[i] = i;
            }
            return ans;
        }
        adj = new List[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int[] p : prerequisites) {
            adj[p[1]].add(p[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!dfs(i)) {
                return new int[0];
            }
        }

        int[] ans = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            ans[i] = postOrder.pop();
        }
        return ans;
    }

    private boolean dfs (int node) {
        if (visitedTmp.contains(node))
            return false;
        if (visitedPerm.contains(node))
            return true;

        visitedTmp.add(node);
        visitedPerm.add(node);


        for (Integer v : adj[node]) {
            if (!dfs(v)) {
                return false;
            }
        }

        postOrder.push(node);
        visitedTmp.remove(node);
        return true;
    }

    public static void main (String[] args) {
        CourseSchedule2 test = new CourseSchedule2();
        int[][] prerequisites = {
                {1, 0},
                {2, 0},
                {3, 1},
                {3, 2}
        };
        int[] ans = test.findOrder(4, prerequisites);
        System.out.println(Arrays.toString(ans));
    }
}
