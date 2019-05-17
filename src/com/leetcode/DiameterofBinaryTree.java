package com.leetcode;

import com.leetcode.repository.TreeNode;
import com.leetcode.repository.TreeNodeWrapper;

/**
 * @author Yu Zhen
 **/
public class DiameterofBinaryTree {
    private int longestPath = 0;

    public int diameterOfBinaryTree (TreeNode root) {
        depth(root);
        return longestPath;
    }

    private int depth (TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = depth(root.left);
        int r = depth(root.right);
        longestPath = Math.max(longestPath, l + r);
        return Math.max(l, r) + 1;
    }

    public static void main (String[] args) {
        DiameterofBinaryTree dbt = new DiameterofBinaryTree();
        TreeNode root = TreeNodeWrapper.stringToTreeNode("[1,2,3,4,5]");
        System.out.println(dbt.diameterOfBinaryTree(root));
    }
}
