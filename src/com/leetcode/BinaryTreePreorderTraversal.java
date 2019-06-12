package com.leetcode;

import com.leetcode.repository.TreeNode;
import com.leetcode.repository.TreeNodeWrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 2019-06-12 09:25
 * 144, Medium
 * @author Yu Zhen
 **/
public class BinaryTreePreorderTraversal {
    // 递归法
    public List<Integer> preorderTraversal (TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        dfs(root, ans);
        return ans;
    }

    private void dfs (TreeNode root, List<Integer> ans) {
        ans.add(root.val);
        if (root.left != null) dfs(root.left, ans);
        if (root.right != null) dfs(root.right, ans);
    }

    // 迭代法
    public List<Integer> preorderTraversalByIteration (TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) {
                continue;
            }
            ans.add(node.val);
            stack.push(node.right);
            stack.push(node.left);
        }
        return ans;
    }

    public static void main (String[] args) {
        BinaryTreePreorderTraversal binaryTreePreorderTraversal = new BinaryTreePreorderTraversal();
        TreeNode root = TreeNodeWrapper.stringToTreeNode("[1,2,3]");
        System.out.println(binaryTreePreorderTraversal.preorderTraversal(root));
    }
}
