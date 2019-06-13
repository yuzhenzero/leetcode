package com.leetcode;

import com.leetcode.repository.TreeNode;
import com.leetcode.repository.TreeNodeWrapper;

// 230#, Medium
public class KthSmallestElementinaBST {
    int cnt = 0;
    int val;

    // 计算节点数法
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

    // 中序遍历法
    public int kthSmallestInorder (TreeNode root, int k) {
        inorder(root, k);
        return val;
    }

    private void inorder (TreeNode root, int k) {
        if (root == null) {
            return;
        }
        inorder(root.left, k);
        cnt++;
        if (cnt == k) {
            val = root.val;
            return;
        }
        inorder(root.right, k);
    }

    public static void main (String[] args) {
        KthSmallestElementinaBST kseBST = new KthSmallestElementinaBST();
        TreeNode root = TreeNodeWrapper.stringToTreeNode("[5,3,6,2,4,null,null,1]");
        TreeNodeWrapper.prettyPrintTree(root);
        int k = 3;
        int ans = kseBST.kthSmallestInorder(root, k);
        System.out.println(ans);
    }
}
