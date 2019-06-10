package com.leetcode;

import com.leetcode.repository.TreeNode;
import com.leetcode.repository.TreeNodeWrapper;

/**
 * 437, Easy
 *
 * @author Yu Zhen
 **/
public class PathSum3 {
    public int pathSum (TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }

        return pathSumStartWithNode(root, sum)
                + pathSum(root.left, sum)
                + pathSum(root.right, sum);
    }

    private int pathSumStartWithNode (TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }
        int ans = 0;
        if (node.val == sum) ans++;
        ans += pathSumStartWithNode(node.left, sum - node.val)
                + pathSumStartWithNode(node.right, sum - node.val);
        return ans;
    }

    public static void main (String[] args) {
        PathSum3 ps3 = new PathSum3();
        TreeNode root = TreeNodeWrapper.stringToTreeNode("[1,null,2,null,3,null,4,null,5]");
        int sum = 3;
        System.out.println(ps3.pathSum(root, sum));
    }
}
