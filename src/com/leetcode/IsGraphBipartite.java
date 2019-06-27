package com.leetcode;

/**
 * 2019-06-27 09:40
 *
 * @author Yu Zhen
 **/
public class IsGraphBipartite {
    public boolean isBipartite (int[][] graph) {
        int[] colors = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {  // 处理图不是连通的情况
            if (colors[i] == 0) {
                if (!dfs(i, -1, colors, graph))
                    return false;
            }
        }
        return true;
    }

    private boolean dfs (int curNode, int curColor, int[] colors, int[][] graph) {
        if (colors[curNode] != 0 && colors[curNode] != curColor) return false;
        if (colors[curNode] != 0) return true;
        colors[curNode] = curColor;
        for (int adj : graph[curNode]) {
            if (!dfs(adj, -curColor, colors, graph)) {
                return false;
            }
        }
        return true;
    }

    public static void main (String[] args) {
        IsGraphBipartite test = new IsGraphBipartite();
        int[][] graph = {
                {1, 3},
                {0, 2},
                {1, 3},
                {0, 2}
        };
        System.out.println(test.isBipartite(graph));
    }
}
