package com.leetcode;

import com.leetcode.repository.TreeNode;
import com.leetcode.repository.TreeNodeWrapper;

/**
 * 226, Easy
 *
 * @author Yu Zhen
 **/
public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = root.left;
        root.left = invertTree(root.right);
        root.right = invertTree(left);
        return root;
    }

    public static void main (String[] args) {
        InvertBinaryTree ibt = new InvertBinaryTree();
        TreeNode root = TreeNodeWrapper.stringToTreeNode("[4,2,7,1,3,6,9]");
        TreeNodeWrapper.prettyPrintTree(root);
        TreeNodeWrapper.prettyPrintTree(ibt.invertTree(root));
    }


}
