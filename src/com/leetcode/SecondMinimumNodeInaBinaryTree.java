package com.leetcode;

import com.leetcode.repository.TreeNode;
import com.leetcode.repository.TreeNodeWrapper;

/**
 * 2019-06-10 20:32
 * 671, Easy
 *
 * @author Yu Zhen
 **/
public class SecondMinimumNodeInaBinaryTree {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null) {
            return -1;
        }
        if (root.left == null && root.right == null) {
            return -1;
        }
        int leftVal = root.left.val;
        int rightVal = root.right.val;
        if (leftVal == root.val) leftVal = findSecondMinimumValue(root.left);
        if (rightVal == root.val) rightVal = findSecondMinimumValue(root.right);
        if (leftVal != -1 && rightVal != -1) {
            return Math.min(leftVal, rightVal);
        }
        if (leftVal != -1) {
            return leftVal;
        }
        return rightVal;
    }

    public static void main (String[] args) {
        SecondMinimumNodeInaBinaryTree secondMinimumNodeInaBinaryTree = new SecondMinimumNodeInaBinaryTree();
        TreeNode root = TreeNodeWrapper.stringToTreeNode("[2,2,5,null,null,5,7]");
        System.out.println(secondMinimumNodeInaBinaryTree.findSecondMinimumValue(root));
    }
}
