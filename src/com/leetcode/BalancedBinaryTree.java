package com.leetcode;

import com.leetcode.repository.TreeNode;
import com.leetcode.repository.TreeNodeWrapper;

/**
 * @author Yu Zhen
 **/
// 110, Easy
public class BalancedBinaryTree {
    private boolean result = true;

    public boolean isBalanced (TreeNode root) {
        maxDepth(root);
        return result;
    }

    private int maxDepth (TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        if (Math.abs(l - r) > 1) result = false;
        return Math.max(l, r) + 1;
    }

    public static void main (String[] args) {
        BalancedBinaryTree bbt = new BalancedBinaryTree();
        TreeNode root = TreeNodeWrapper.stringToTreeNode("[1,2,2,3,3,null,null,4,4]");
        System.out.println(bbt.isBalanced(root));
    }
}
