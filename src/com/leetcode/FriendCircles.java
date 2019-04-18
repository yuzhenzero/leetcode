package com.leetcode;

// 547#, Medium
public class FriendCircles {
    private int n;

    public int findCircleNum (int[][] M) {
        n = M.length;
        boolean[] marked = new boolean[n];
        int circleCount = 0;
        for (int i = 0; i < n; i++) {
            if (!marked[i]) {
                dfs(M, i, marked);
                circleCount++;
            }
        }
        return circleCount;
    }

    private void dfs (int[][] M, int i, boolean[] marked) {
        marked[i] = true;
        for (int j = 0; j < n; j++) {
            if (M[i][j] == 1 && !marked[j]) {
                dfs(M, j, marked);
            }
        }
    }

    public static void main (String[] args) {
        FriendCircles fc = new FriendCircles();
        int[][] M = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}};
        System.out.println(fc.findCircleNum(M));
    }
}
