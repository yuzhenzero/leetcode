package com.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// 279#, Medium
public class PerfectSquares {

    /**
     * 使用 BFS
     *
     * @param n 目标数
     * @return 平方数个数
     */
    public int numSquares (int n) {
        List<Integer> squares =  generateSquares(n);
        Queue<Integer> queue = new LinkedList<>();
        boolean[] marked = new boolean[n + 1];
        queue.add(n);
        marked[n] = true;
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            while (size-- > 0) {
                int cur = queue.poll();
                for (Integer square : squares) {
                    int next = cur - square;
                    if (next < 0) {
                        break;
                    }
                    if (next == 0) {
                        return level;
                    }
                    if (marked[next]) {
                        continue;
                    }
                    marked[next] = true;
                    queue.add(next);
                }
            }
        }
        return n;
    }

    public int numSquares2 (int n) {
        List<Integer> squares = generateSquares(n);
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int min = Integer.MAX_VALUE;
            for (Integer square : squares) {
                if (square > i) {
                    break;
                }
                min = Math.min(min, dp[i - square] + 1);
            }
            dp[i] = min;
        }
        return dp[n];
    }

    /**
     * 生成小于 n 的平方数的序列
     * @param n 目标数
     * @return 1,4,9,...
     */
    private List<Integer> generateSquares(int n) {
        List<Integer> squares = new ArrayList<>();
        int square = 1;
        int diff = 3;
        while (square <= n) {
            squares.add(square);
            square += diff;
            diff += 2;
        }
        return squares;
    }

    public static void main (String[] args) {
        PerfectSquares ps = new PerfectSquares();
        int n = 12;
        System.out.println(ps.numSquares2(n));

    }
}
