package com.leetcode;

import com.leetcode.repository.TreeNode;
import com.leetcode.repository.TreeNodeWrapper;

/**
 * 2019-06-13 09:26
 * 669, Easy
 *
 * @author Yu Zhen
 **/
public class TrimaBinarySearchTree {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) {
            return null;
        }
        if (root.val > R) return trimBST(root.left, L, R);
        if (root.val < L) return trimBST(root.right, L, R);
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }

    public static void main (String[] args) {
        TrimaBinarySearchTree trimaBinarySearchTree = new TrimaBinarySearchTree();
        TreeNode root = TreeNodeWrapper.stringToTreeNode("[3,0,4,null,2,null,null,1]");
        TreeNodeWrapper.prettyPrintTree(root);
        root = trimaBinarySearchTree.trimBST(root, 1, 3);
        TreeNodeWrapper.prettyPrintTree(root);
    }
}
