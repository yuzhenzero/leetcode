package com.leetcode;

import com.leetcode.repository.TreeNode;
import com.leetcode.repository.TreeNodeWrapper;

/**
 * 617, Easy
 *
 * @author Yu Zhen
 **/
public class MergeTwoBinaryTrees {
    public TreeNode mergeTrees (TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return null;
        }
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode treeNode = new TreeNode(t1.val + t2.val);
        treeNode.left = mergeTrees(t1.left, t2.left);
        treeNode.right = mergeTrees(t1.right, t2.right);
        return treeNode;
    }

    public static void main (String[] args) {
        MergeTwoBinaryTrees mtbt = new MergeTwoBinaryTrees();
        TreeNode t1 = TreeNodeWrapper.stringToTreeNode("[1,3,2,5]");
        TreeNodeWrapper.prettyPrintTree(t1);
        TreeNode t2 = TreeNodeWrapper.stringToTreeNode("[2,1,3,null,4,null,7]");
        TreeNodeWrapper.prettyPrintTree(t2);

        TreeNodeWrapper.prettyPrintTree(mtbt.mergeTrees(t1, t2));
    }
}
