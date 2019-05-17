package com.leetcode;

import com.leetcode.repository.TreeNode;
import com.leetcode.repository.TreeNodeWrapper;

import java.util.*;

// 102#, Medium
public class BinaryTreeLevelOrderTraversal {
    // 常规思路
    public List<List<Integer>> levelOrder (TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        if (root == null)
            return ans;
        q.add(root);
        list.add(root.val);
        ans.add(list);
        while (q.size() > 0) {
            list = new ArrayList<Integer>();
            int s = q.size();
            for (int i = 0; i < s; i++) {
                TreeNode tn = q.remove();
                if (tn.left != null) q.add(tn.left);
                if (tn.right != null) q.add(tn.right);
                if (tn.left != null) list.add(tn.left.val);
                if (tn.right != null) list.add(tn.right.val);
            }
            if (list.size() > 0) {
                ans.add(list);
            }
        }
        return ans;
    }

    // 递归法
    public List<List<Integer>> levelOrder_1 (TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        levelOrderHelper(ans,root,0);
        return ans;

    }

    private void levelOrderHelper (List<List<Integer>> ans, TreeNode root, int height) {
        if (root == null) return;
        if (height >= ans.size()) {
            ans.add(new ArrayList<Integer>());
        }
        ans.get(height).add(root.val);
        levelOrderHelper(ans, root.left, height + 1);
        levelOrderHelper(ans, root.right, height + 1);

    }

    public static void main (String[] args) {
        BinaryTreeLevelOrderTraversal btlot = new BinaryTreeLevelOrderTraversal();
        String tn_str = "[1,2,3,4,5]";
        TreeNode tn = TreeNodeWrapper.stringToTreeNode(tn_str);
        TreeNodeWrapper.prettyPrintTree(tn);
        System.out.println(btlot.levelOrder(tn));
        System.out.println(btlot.levelOrder_1(tn));
    }
}
