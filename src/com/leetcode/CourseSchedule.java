package com.leetcode;

import java.util.*;

/**
 * 2019-06-27 10:30
 * 207, Medium
 *
 * @author Yu Zhen
 **/
public class CourseSchedule {
    private Map<Integer, List<Integer>> adj = new HashMap<>();
    private Set<Integer> visitedPerm = new HashSet<>();
    private Set<Integer> visitedTmp = new HashSet<>();

    public boolean canFinish (int numCourses, int[][] prerequisites) {
        if (numCourses <= 0 || prerequisites == null)
            return true;
        buildAdjList(prerequisites);

        for (Integer key : adj.keySet()) {
            if (!dfs(key)) {
                return false;
            }
        }

        return true;
    }

    private void buildAdjList (int[][] prerequisites) {

        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int preCourse = prerequisite[1];
            if (!adj.containsKey(preCourse)) {
                adj.put(preCourse, new ArrayList<>());
            }
            adj.get(preCourse).add(course);
        }
    }

    private boolean dfs (int node) {
        if (visitedTmp.contains(node))
            return false;
        if (visitedPerm.contains(node))
            return true;

        visitedTmp.add(node);
        visitedPerm.add(node);

        if (adj.containsKey(node)) {
            for (Integer v : adj.get(node)) {
                if (!dfs(v)) {
                    return false;
                }
            }
        }

        visitedTmp.remove(node);
        return true;
    }

    public static void main (String[] args) {
        CourseSchedule test = new CourseSchedule();
        int[][] prerequisites = {
                {1, 0},
                {0, 1}
        };
        System.out.println(test.canFinish(2, prerequisites));
    }
}
