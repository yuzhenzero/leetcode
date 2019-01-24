package com.leetcode;


import java.util.Arrays;

public class Test {
    private void problem (String str, int n, int m) {
        boolean[] vis = new boolean[25];
        Arrays.fill(vis,false);
        for (int i = 0, j = -1; i < n; i++) {
            for (int p = 0; p < m; p++) {
                while (vis[(++j) % n]) ;
            }
            System.out.printf("%c", str.charAt(j % n));
            vis[j % n] = true;
        }
    }

    public static void main (String[] args) {
        String flag = "gmiaibnutt";
        Test test = new Test();
        test.problem(flag, 10, 2);
    }

}