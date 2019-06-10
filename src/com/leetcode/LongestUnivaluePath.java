package com.leetcode;

import com.leetcode.repository.TreeNode;
import com.leetcode.repository.TreeNodeWrapper;

/**
 * 2019-06-10 19:37
 * 687, Easy
 *
 * @author Yu Zhen
 **/
public class LongestUnivaluePath {
    private int longestPath;
    public int longestUnivaluePath(TreeNode root) {
        arrowLength(root);
        return longestPath;
    }

    private int arrowLength (TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = arrowLength(root.left);
        int right = arrowLength(root.right);

        int leftArrowLength = root.left != null && root.left.val == root.val ? left + 1 : 0;
        int rightArrowLength = root.right != null && root.right.val == root.val ? right + 1 : 0;
        longestPath = Math.max(leftArrowLength + rightArrowLength, longestPath);

        return Math.max(leftArrowLength, rightArrowLength);
    }

    public static void main (String[] args) {
        LongestUnivaluePath longestUnivaluePath = new LongestUnivaluePath();
        TreeNode root = TreeNodeWrapper.stringToTreeNode("[5,4,5,1,1,5]");
        System.out.println(longestUnivaluePath.longestUnivaluePath(root));
    }
}
