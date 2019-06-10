package com.leetcode;

import com.leetcode.repository.TreeNode;
import com.leetcode.repository.TreeNodeWrapper;

/**
 * 2019-06-10 20:52
 * 337, Medium
 * @author Yu Zhen
 **/
public class HouseRobber3 {
    public int rob(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int var1 = root.val;
        if (root.left != null) {
            var1 += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            var1 += rob(root.right.left) + rob(root.right.right);
        }
        int var2 = rob(root.left) + rob(root.right);
        return Math.max(var1, var2);
    }

    public static void main (String[] args) {
        HouseRobber3 houseRobber3 = new HouseRobber3();
        TreeNode root = TreeNodeWrapper.stringToTreeNode("[3,4,5,1,3,null,1]");
        System.out.println(houseRobber3.rob(root));
    }
}
