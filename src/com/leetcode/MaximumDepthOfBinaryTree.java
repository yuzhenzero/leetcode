package com.leetcode;

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


    public static void main(String[] args)
    {
        MaximumDepthOfBinaryTree mdobt = new MaximumDepthOfBinaryTree();
        String root_string = "[3,9,20,null,null,15,7]";
        TreeNode root = TreeNodeWrapper.stringToTreeNode(root_string);
        System.out.println(mdobt.maxDepth(root));
    }
}
