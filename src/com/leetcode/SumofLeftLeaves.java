package com.leetcode;

import com.leetcode.repository.TreeNode;
import com.leetcode.repository.TreeNodeWrapper;

/**
 * 2019-06-10 17:28
 * 404, Easy
 * @author Yu Zhen
 **/
public class SumofLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (isLeaf(root.left)) {
            return root.left.val + sumOfLeftLeaves(root.right);
        }
        return sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

    private boolean isLeaf (TreeNode root) {
        if (root == null) {
            return false;
        }
        return root.left == null && root.right == null;
    }

    public static void main (String[] args) {
        SumofLeftLeaves sumofLeftLeaves = new SumofLeftLeaves();
        TreeNode root = TreeNodeWrapper.stringToTreeNode("[3,9,20,null,null,15,7]");
        System.out.println(sumofLeftLeaves.sumOfLeftLeaves(root));
    }
}
