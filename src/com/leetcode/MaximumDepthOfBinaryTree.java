package com.leetcode;

import com.leetcode.repository.TreeNode;
import com.leetcode.repository.TreeNodeWrapper;
import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;
import javafx.util.Pair;
import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

// 104#, Easy
public class MaximumDepthOfBinaryTree {
    // 递归法
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int left_height = maxDepth(root.left);
            int right_height = maxDepth(root.right);
            return Math.max(left_height, right_height) + 1;
        }
    }

    // 迭代法待更
    public int maxDepth2 (TreeNode root) {
        Queue<Pair<TreeNode, Integer>> stack = new LinkedList<>();
        if (root != null) {
            stack.add(new Pair<>(root, 1));
        }

        int depth = 0;
        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> cur = stack.poll();
            root = cur.getKey();
            int cur_depth = cur.getValue();
            if (root != null) {
                depth = Math.max(depth, cur_depth);
                stack.add(new Pair<>(root.left, cur_depth + 1));
                stack.add(new Pair<>(root.right, cur_depth + 1));
            }
        }
        return depth;
    }


    public static void main(String[] args)
    {
        MaximumDepthOfBinaryTree mdobt = new MaximumDepthOfBinaryTree();
        String root_string = "[3,9,20,null,null,15,7]";
        TreeNode root = TreeNodeWrapper.stringToTreeNode(root_string);
        System.out.println(mdobt.maxDepth(root));
        System.out.println(mdobt.maxDepth2(root));

    }
}
