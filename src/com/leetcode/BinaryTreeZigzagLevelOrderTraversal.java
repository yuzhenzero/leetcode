package com.leetcode;


import com.leetcode.repository.TreeNode;
import com.leetcode.repository.TreeNodeWrapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 103#, Medium
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder (TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (root== null) return ans;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        TreeNode cur = root;
        stack1.push(cur);
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            List<Integer> temp = new ArrayList<>();
            while (!stack1.isEmpty()) {
                cur = stack1.pop();
                temp.add(cur.val);
                if (cur.left !=null) stack2.push(cur.left);
                if (cur.right !=null) stack2.push(cur.right);
            }
            ans.add(temp);
            temp = new ArrayList<>();
            while (!stack2.isEmpty()) {
                cur = stack2.pop();
                temp.add(cur.val);
                if (cur.right !=null) stack1.push(cur.right);
                if (cur.left !=null) stack1.push(cur.left);
            }
            if (!temp.isEmpty()) {
                ans.add(temp);
            }
        }
        return ans;
    }

    public static void main (String[] args) {
        BinaryTreeZigzagLevelOrderTraversal btzlot =
                new BinaryTreeZigzagLevelOrderTraversal();
        TreeNode root = TreeNodeWrapper.stringToTreeNode("[1,2,3,4,null,null,5]");
        System.out.println(btzlot.zigzagLevelOrder(root));
    }
}
