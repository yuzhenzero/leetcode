package com.leetcode;

import com.leetcode.repository.TreeNode;
import com.leetcode.repository.TreeNodeWrapper;

import java.util.ArrayList;
import java.util.List;

// 257#, Easy
public class BinaryTreePaths {
    List<String> ans = new ArrayList<>();

    public List<String> binaryTreePaths (TreeNode root) {
        if (root == null)
            return ans;
        String cur = "";
        findPaths(root,cur);
        return ans;
    }

    private void findPaths (TreeNode node, String curStr) {
        if (node.right == null && node.left == null) {
            curStr += node.val;
            ans.add(curStr);
            return;
        }
        curStr += node.val + "->";
        if (node.left != null)
            findPaths(node.left, curStr);
        if (node.right != null)
            findPaths(node.right, curStr);
    }

    public static void main (String[] args) {
        BinaryTreePaths btp = new BinaryTreePaths();
        TreeNode root = TreeNodeWrapper.stringToTreeNode("[1,2,3,null,5]");
        System.out.println(btp.binaryTreePaths(root));
    }
}
