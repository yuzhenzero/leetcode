package com.leetcode;

import com.leetcode.repository.TreeNode;
import com.leetcode.repository.TreeNodeWrapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * 2019-06-12 09:50
 * 145, Hard
 *
 * @author Yu Zhen
 **/
public class BinaryTreePostorderTraversal {
    // 递归法
    public List<Integer> postorderTraversal (TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        if (root.left != null) ans.addAll(postorderTraversal(root.left));
        if (root.right != null) ans.addAll(postorderTraversal(root.right));
        ans.add(root.val);
        return ans;
    }

    // 迭代法
    public List<Integer> postorderTraversalByIteration (TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node == null) {
                continue;
            }
            ans.add(node.val);
            stack.push(node.left);
            stack.push(node.right);
        }
        Collections.reverse(ans);
        return ans;
    }


    public static void main (String[] args) {
        BinaryTreePostorderTraversal binaryTreePostorderTraversal = new BinaryTreePostorderTraversal();
        TreeNode root = TreeNodeWrapper.stringToTreeNode("[1,2,3]");
        System.out.println(binaryTreePostorderTraversal.postorderTraversal(root));
    }
}
