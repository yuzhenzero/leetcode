package com.leetcode;

// 200#, Medium
public class NumberofIslands {
    private int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int numIslands (char[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfs (char[][] grid, int i, int j) {
        if (i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == '1') {
            grid[i][j] = '0';
            for (int[] d : direction) {
                dfs(grid, i + d[0], j + d[1]);
            }
        }
    }

    public static void main (String[] args) {
        NumberofIslands ni = new NumberofIslands();
        char[][] grid = {
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '1'}};
        System.out.println(ni.numIslands(grid));
    }
}
