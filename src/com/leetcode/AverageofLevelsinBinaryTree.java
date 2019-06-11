package com.leetcode;

import com.leetcode.repository.TreeNode;
import com.leetcode.repository.TreeNodeWrapper;

import java.util.*;

/**
 * 2019-06-11 10:44
 * 637, Easy
 * @author Yu Zhen
 **/
public class AverageofLevelsinBinaryTree {
    public List<Double> averageOfLevels (TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Double> ans = new ArrayList<>();
        if (root == null)
            return ans;
        q.add(root);
        while (q.size() > 0) {
            int s = q.size();
            double sum = 0;
            for (int i = 0; i < s; i++) {
                TreeNode tn = q.remove();
                if (tn.left != null) q.add(tn.left);
                if (tn.right != null) q.add(tn.right);
                sum += tn.val;
            }
            ans.add(sum / s);
        }
        return ans;
    }

    public static void main (String[] args) {
        AverageofLevelsinBinaryTree averageofLevelsinBinaryTree = new AverageofLevelsinBinaryTree();
        TreeNode root = TreeNodeWrapper.stringToTreeNode("[3,9,20,15,7]");
        System.out.println(averageofLevelsinBinaryTree.averageOfLevels(root));
    }
}
