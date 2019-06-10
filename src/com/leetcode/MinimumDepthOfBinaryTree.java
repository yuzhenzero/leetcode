package com.leetcode;

import com.leetcode.repository.TreeNode;
import com.leetcode.repository.TreeNodeWrapper;

/**
 * 2019-06-10 17:11
 * 111, Easy
 *
 * @author Yu Zhen
 **/
public class MinimumDepthOfBinaryTree {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = minDepth(root.left);
        int rightDepth = minDepth(root.right);
        if (leftDepth == 0 || rightDepth == 0) {
            return leftDepth + rightDepth + 1;
        }
        return Math.min(leftDepth,rightDepth) + 1;
    }

    public static void main (String[] args) {
        MinimumDepthOfBinaryTree minimumDepthOfBinaryTree = new MinimumDepthOfBinaryTree();
        TreeNode root = TreeNodeWrapper.stringToTreeNode("[3,9,20,null,null,15,7]");
        System.out.println(minimumDepthOfBinaryTree.minDepth(root));
    }
}
