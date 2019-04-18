package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 417#, Medium
public class PacificAtlanticWaterFlow {
    private int[][] matrix;
    private int m, n;
    private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public List<int[]> pacificAtlantic (int[][] matrix) {
        List<int[]> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return ans;
        }
        m = matrix.length;
        n = matrix[0].length;
        this.matrix = matrix;
        boolean[][] canReachP = new boolean[m][n];
        boolean[][] canReachA = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(i, 0, canReachP);
            dfs(i, n - 1, canReachA);
        }
        for (int j = 0; j < n; j++) {
            dfs(0, j, canReachP);
            dfs(m - 1, j, canReachA);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (canReachA[i][j] && canReachP[i][j]) {
                    ans.add(new int[]{i, j});
                }
            }
        }
        return ans;
    }

    private void dfs (int r, int c, boolean[][] canReach) {
        if (canReach[r][c]) {
            return;
        }
        canReach[r][c] = true;
        for (int[] d : direction) {
            int nextRow = r + d[0];
            int nextCol = c + d[1];
            if (nextRow < 0 || nextRow >= m || nextCol < 0 || nextCol >= n
                    || matrix[r][c] > matrix[nextRow][nextCol]) {
                continue;
            }
            dfs(nextRow, nextCol, canReach);
        }
    }

    public static void main (String[] args) {
        PacificAtlanticWaterFlow pawf = new PacificAtlanticWaterFlow();
        int[][] matrix = {
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}};
        for (int[] p : pawf.pacificAtlantic(matrix)) {
            System.out.println(Arrays.toString(p));
        }
    }
}
