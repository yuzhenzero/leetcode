package com.leetcode;

// 70#, Easy
// Dynamic Programming
public class ClimbingStairs {
    public int climbStairs (int n) {
        if (n == 1){
            return 1;
        }// 防止数组越界
        int[] step = new int[n + 1];
        step[1] = 1;
        step[2] = 2;
        for (int i = 3; i <= n; i++) {
            step[i] = step[i - 1] + step[i - 2];
        }
        return step[n];
    }

    public int climbStairs2 (int n) {
        if (n <= 2) {
            return n;
        }
        int pre1 = 2, pre2 = 1;
        for (int i = 2; i < n; i++) {
            int cur = pre1 + pre2;
            pre2 = pre1;
            pre1 = cur;
        }
        return pre1;
    }

    public static void main (String[] args) {
        ClimbingStairs cs = new ClimbingStairs();
        System.out.println(cs.climbStairs2(5));
    }
}
