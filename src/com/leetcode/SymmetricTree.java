package com.leetcode;

// 101#, Easy

import com.leetcode.repository.TreeNode;
import com.leetcode.repository.TreeNodeWrapper;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
    // 递归法
    public boolean isSymmetric (TreeNode root) {
        return isSymmetric(root, root);
    }

    private boolean isSymmetric (TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return t1.val == t2.val
                && isSymmetric(t1.left, t2.right)
                && isSymmetric(t1.right, t2.left);
    }

    // 迭代法
    public boolean isSymmetric_1 (TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode t1 = q.poll();
            TreeNode t2 = q.poll();
            if (t1 == null && t2 == null)   continue;
            if (t1 == null || t2 == null) return false;
            if (t1.val != t2.val) return false;
            q.add(t1.left);
            q.add(t2.right);
            q.add(t1.right);
            q.add(t2.left);

        }
        return true;
    }

    public static void main (String[] args) {
        SymmetricTree st = new SymmetricTree();
        String t1_string = "[1,2,2,3,4,4,3]";
        String t2_string = "[1,2,2,null,3,null,3]";
        TreeNode t1 = TreeNodeWrapper.stringToTreeNode(t1_string);
        TreeNode t2 = TreeNodeWrapper.stringToTreeNode(t2_string);
        System.out.println("递归法：");
        System.out.println(st.isSymmetric(t1));
        System.out.println(st.isSymmetric(t2));
        System.out.println("迭代法：");
        System.out.println(st.isSymmetric_1(t1));
        System.out.println(st.isSymmetric_1(t2));

    }
}
