package com.leetcode;

import com.leetcode.repository.TreeNode;
import com.leetcode.repository.TreeNodeWrapper;

/**
 * 2019-06-13 10:06
 * 538, Easy
 *
 * @author Yu Zhen
 **/
public class ConvertBSTtoGreaterTree {
    int sum = 0;
    public TreeNode convertBST (TreeNode root) {
        traver(root);
        return root;
    }

    private void traver (TreeNode node) {
        if (node == null) {
            return;
        }
        traver(node.right);
        sum += node.val;
        node.val = sum;
        traver(node.left);
    }

    public static void main (String[] args) {
        ConvertBSTtoGreaterTree convertBSTtoGreaterTree = new ConvertBSTtoGreaterTree();
        TreeNode root = TreeNodeWrapper.stringToTreeNode("[5,2,13]");
        TreeNodeWrapper.prettyPrintTree(convertBSTtoGreaterTree.convertBST(root));
    }

}
