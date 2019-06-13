package com.leetcode;

import com.leetcode.repository.TreeNode;
import com.leetcode.repository.TreeNodeWrapper;

/**
 * 2019-06-13 10:20
 * 235, Easy
 * @author Yu Zhen
 **/
public class LowestCommonAncestorofaBinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val > q.val) return lowestCommonAncestor(root.left, p, q);
        if (root.val < p.val && root.val < q.val) return lowestCommonAncestor(root.right, p, q);
        return root;
    }

    public static void main (String[] args) {
        LowestCommonAncestorofaBinarySearchTree lowestCommonAncestorofaBinarySearchTree =
                new LowestCommonAncestorofaBinarySearchTree();
        TreeNodeWrapper.stringToTreeNode("[6,2,8,0,4,7,9,null,null,3,5]");

    }
}
