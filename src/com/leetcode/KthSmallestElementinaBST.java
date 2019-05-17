package com.leetcode;

import com.leetcode.repository.TreeNode;
import com.leetcode.repository.TreeNodeWrapper;

// 230#, Medium
public class KthSmallestElementinaBST {
    public int kthSmallest (TreeNode root, int k) {
        int t = size(root.left);
        if (t > k - 1) return kthSmallest(root.left, k);
        else if (t < k - 1) return kthSmallest(root.right, k - t - 1);
        else return root.val;
    }

    private int size (TreeNode root) {
        if (root == null) return 0;
        return size(root.left) + size(root.right) + 1;
    }

    public static void main (String[] args) {
        KthSmallestElementinaBST kseBST = new KthSmallestElementinaBST();
        TreeNode root = TreeNodeWrapper.stringToTreeNode("[5,3,6,2,4,null,null,1]");
        TreeNodeWrapper.prettyPrintTree(root);
        int k = 3;
        int ans = kseBST.kthSmallest(root, k);
        System.out.println(ans);
    }
}
