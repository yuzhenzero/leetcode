package com.leetcode;

import com.leetcode.repository.TreeNode;
import com.leetcode.repository.TreeNodeWrapper;

// 98#, Medium
public class ValidateBinarySearchTree {
    public boolean isValidBST (TreeNode root) {
        if (root == null) {
            return true;
        }
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left != null && root.val <= searchMax(root.left).val) {
            // 根节点是否小于左子树中最大节点
            return false;
        }
        if (root.right != null && root.val >= searchMin(root.right).val) {
            // 根节点是否大于右子树中最小节点
            return false;
        }
        return isValidBST(root.left) && isValidBST(root.right);

    }

    private TreeNode searchMin (TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    private TreeNode searchMax (TreeNode root) {
        while (root.right != null) {
            root = root.right;
        }
        return root;
    }

    public static void main (String[] args) {
        ValidateBinarySearchTree vbst = new ValidateBinarySearchTree();
        String root_string = "[10,5,15,null,null,6,20]";
        TreeNode root = TreeNodeWrapper.stringToTreeNode(root_string);
        System.out.println(vbst.isValidBST(root));
    }
}
