package com.leetcode;

import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.List;

/**
 * @author Yu Zhen
 **/
public class UniqueBinarySearchTrees2 {
    public List<TreeNode> generateTrees (int n) {
        if (n == 0) {
            return new LinkedList<>();
        }
        return generateSubtrees(1, n);
    }

    private List<TreeNode> generateSubtrees (int s, int e) {
        List<TreeNode> ans = new LinkedList<>();
        if (s > e) {
            ans.add(null);
            return ans;
        }

        for (int i = s; i <= e; i++) {
            List<TreeNode> leftSubtree = generateSubtrees(s, i - 1);
            List<TreeNode> rightSubtree = generateSubtrees(i + 1, e);
            for (TreeNode left : leftSubtree) {
                for (TreeNode right : rightSubtree) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    ans.add(root);
                }
            }
        }

        return ans;
    }

    public static void main (String[] args) {
        UniqueBinarySearchTrees2 ubst2 = new UniqueBinarySearchTrees2();
        for (TreeNode treeNode : ubst2.generateTrees(3)) {
            TreeNodeWrapper.prettyPrintTree(treeNode);
        }
    }
}
