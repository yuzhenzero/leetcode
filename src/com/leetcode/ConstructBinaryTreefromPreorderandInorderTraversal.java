package com.leetcode;

import java.util.ArrayList;

// 105#, Medium
public class ConstructBinaryTreefromPreorderandInorderTraversal {
    public TreeNode buildTree (int[] preorder, int[] inorder) {
        return help(0,0,inorder.length - 1,preorder,inorder);
    }

    private TreeNode help(int startPre, int startIn,int endIn,int[] preorder, int[] inorder) {
        if (startPre > preorder.length - 1 || startIn > endIn) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[startPre]);
        int curInIndex = 0;
        for (int i = startIn; i <= endIn; i++) {
            if (root.val == inorder[i]) {
                curInIndex = i;
            }
        }
        root.left = help(startPre + 1,startIn,curInIndex - 1,preorder,inorder);
        root.right = help(startPre + curInIndex - startIn + 1, curInIndex + 1, endIn, preorder, inorder);
        return root;
    }

    public static void main (String[] args) {
        ConstructBinaryTreefromPreorderandInorderTraversal cbtpit =
                new ConstructBinaryTreefromPreorderandInorderTraversal();
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode root = cbtpit.buildTree(preorder,inorder);
        TreeNodeWrapper.prettyPrintTree(root);
    }


}
