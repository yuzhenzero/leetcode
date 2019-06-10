package com.leetcode;

import com.leetcode.repository.TreeNode;
import com.leetcode.repository.TreeNodeWrapper;

/**
 * 2019-06-10 16:26
 * 572, Easy
 *
 * @author Yu Zhen
 **/
public class SubtreeofAnotherTree {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null) {
            return true;
        }
        return isSubtreeWithRoot(s, t) || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean isSubtreeWithRoot (TreeNode s, TreeNode t) {
        if (s == null && t == null) return true;
        if (s == null || t == null) return false;
        if (s.val != t.val) return false;
        return isSubtreeWithRoot(s.left, t) || isSubtreeWithRoot(s.right, t);
    }

    public static void main (String[] args) {
        SubtreeofAnotherTree subtreeofAnotherTree = new SubtreeofAnotherTree();
        TreeNode s = TreeNodeWrapper.stringToTreeNode("[3,4,5,1,2]");
        TreeNode t = TreeNodeWrapper.stringToTreeNode("[4,1,2]");
        System.out.println(subtreeofAnotherTree.isSubtree(s,t));
    }

}
