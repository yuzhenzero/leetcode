package com.leetcode;

import java.util.Arrays;

/**
 * 2019-06-27 15:34
 * 684, Medium
 *
 * @author Yu Zhen
 **/
public class RedundantConnection {
    public int[] findRedundantConnection (int[][] edges) {
        int N = edges.length;
        UF uf = new UF(N);
        for (int[] edge : edges) {
            int p = edge[0];
            int q = edge[1];
            if (uf.isConnected(p, q)) {
                return edge;
            }
            uf.union(p, q);
        }
        return new int[]{-1, -1};
    }

    class UF {
        private int[] id;
        private int[] size;

        UF (int N) {
            id = new int[N + 1];
            for (int i = 0; i < id.length; i++) {
                id[i] = i;
            }
            size = new int[N + 1];
            Arrays.fill(size, 1);
        }

        void union (int p, int q) {
            int pRoot = find(p);
            int qRoot = find(q);
            if (pRoot == qRoot) {
                return;
            }
            if (size[pRoot] < size[pRoot]) {
                id[pRoot] = qRoot;
                size[qRoot] += size[pRoot];
            } else {
                id[qRoot] = pRoot;
                size[pRoot] += size[qRoot];
            }


        }

        int find (int p) {
            while (p != id[p]) {
                p = id[p];
            }
            return p;
        }

        boolean isConnected (int p, int q) {
            return find(p) == find(q);
        }
    }

    public static void main (String[] args) {
        RedundantConnection test = new RedundantConnection();
        int[][] edges = {
                {1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}
        };
        int[] ans = test.findRedundantConnection(edges);
        System.out.println(Arrays.toString(ans));
    }

}
