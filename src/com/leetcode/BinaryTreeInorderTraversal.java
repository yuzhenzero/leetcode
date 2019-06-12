package com.leetcode;

import com.leetcode.repository.TreeNode;
import com.leetcode.repository.TreeNodeWrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 2019-06-12 10:18
 * 94, Medium
 *
 * @author Yu Zhen
 **/
public class BinaryTreeInorderTraversal {
    // 递归法
    public List<Integer> inorderTraversal (TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        if (root.left != null) ans.addAll(inorderTraversal(root.left));
        ans.add(root.val);
        if (root.right != null) ans.addAll(inorderTraversal(root.right));
        return ans;
    }

    // 迭代法
    public List<Integer> inorderTraversalByIteration (TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) {
            return ans;
        }
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            ans.add(node.val);
            cur = node.right;
        }
        return ans;
    }

    public static void main (String[] args) {
        BinaryTreeInorderTraversal binaryTreeInorderTraversal = new BinaryTreeInorderTraversal();
        TreeNode root = TreeNodeWrapper.stringToTreeNode("[1,2,3]");
        System.out.println(binaryTreeInorderTraversal.inorderTraversalByIteration(root));
    }
}
