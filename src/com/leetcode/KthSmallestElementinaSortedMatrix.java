package com.leetcode;

/**
 * 2019-06-24 10:15
 * 378, Medium
 *
 * @author Yu Zhen
 **/
public class KthSmallestElementinaSortedMatrix {
    public int kthSmallest (int[][] matrix, int k) {
        int m = matrix.length;
        int n = matrix[0].length;

        int lo = matrix[0][0], hi = matrix[m - 1][n - 1];
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n && matrix[i][j] <= mid; j++) {
                    count++;
                }
            }
            if (count < k) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lo;
    }

    public static void main (String[] args) {
        KthSmallestElementinaSortedMatrix test = new KthSmallestElementinaSortedMatrix();
        int[][] matrix = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        int k = 8;
        System.out.println(test.kthSmallest(matrix, k));
    }
}

