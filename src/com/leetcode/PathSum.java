package com.leetcode;

import com.leetcode.repository.TreeNode;
import com.leetcode.repository.TreeNodeWrapper;

/**
 * 112, Easy
 *
 * @author Yu Zhen
 **/
public class PathSum {
    public boolean hasPathSum (TreeNode root, int sum) {
        if (root == null) {
            return false;
        }
        if (root.left == null && root.right == null && root.val == sum) {
            return true;
        }

        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public static void main (String[] args) {
        PathSum ps = new PathSum();
        TreeNode root = TreeNodeWrapper.stringToTreeNode("[5,4,8,11,null,13,4,7,2,null,null,null,1]");
        System.out.println(ps.hasPathSum(root,22));
    }


}
