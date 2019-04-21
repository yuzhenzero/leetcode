package com.leetcode;

import java.util.ArrayList;
import java.util.List;

// 257#, Easy
public class BinaryTreePaths {
    public List<String> binaryTreePaths (TreeNode root) {
        List<String> ans = new ArrayList<>();
        backtracking(root,new ArrayList<Integer>(),ans);
        return ans;

    }

    private void backtracking (TreeNode root, List<Integer> values, List<String> paths) {
        if (root == null) {
            return;
        }
        values.add(root.val);
        if (isLeaf(root)) {
            paths.add(buildPath(values));
        } else {
            backtracking(root.left, values, paths);
            backtracking(root.right, values, paths);
        }
        values.remove(values.size() - 1);
    }

    private boolean isLeaf (TreeNode root) {
        return root.left == null && root.right == null;
    }

    private String buildPath (List<Integer> values) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < values.size(); i++) {
            str.append(values.get(i));
            if (i != values.size() - 1) {
                str.append("->");
            }
        }
        return str.toString();
    }

    public static void main (String[] args) {
        BinaryTreePaths btp = new BinaryTreePaths();
        TreeNode root = TreeNodeWrapper.stringToTreeNode("[1,2,3,null,5]");
        System.out.println(btp.binaryTreePaths(root));
    }
}
