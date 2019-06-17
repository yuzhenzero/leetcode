package com.leetcode;

import com.leetcode.repository.TreeNode;
import com.leetcode.repository.TreeNodeWrapper;

/**
 * 2019-06-17 10:03
 * 530, Easy
 * @author Yu Zhen
 **/
public class MinimumAbsoluteDifferenceinBST {
    int minDiff = Integer.MAX_VALUE;
    TreeNode pre = null;
    public int getMinimumDifference (TreeNode root) {
        inorder(root);
        return minDiff;
    }

    private void inorder (TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (pre != null) {
            minDiff = Math.min(minDiff, root.val - pre.val);
        }
        pre = root;
        inorder(root.right);
    }

    public static void main (String[] args) {
        MinimumAbsoluteDifferenceinBST minimumAbsoluteDifferenceinBST = new MinimumAbsoluteDifferenceinBST();
        TreeNode root = TreeNodeWrapper.stringToTreeNode("[1,null,2]");
        System.out.println(minimumAbsoluteDifferenceinBST.getMinimumDifference(root));
    }
}
