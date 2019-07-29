package com.leetcode;

import com.leetcode.repository.TreeNode;
import com.leetcode.repository.TreeNodeWrapper;

/**
 * 2019-07-29 09:49
 * 236, Medium
 *
 * @author Yu Zhen
 **/
public class LowestCommonAncestorofaBinaryTree {
    public TreeNode lowestCommonAncestor (TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else {
            return root;
        }
    }

    public static void main (String[] args) {
        LowestCommonAncestorofaBinaryTree test = new LowestCommonAncestorofaBinaryTree();
        TreeNode root = TreeNodeWrapper.stringToTreeNode("[3,5,1,6,2,0,8,null,null,7,4]");
    }
}
