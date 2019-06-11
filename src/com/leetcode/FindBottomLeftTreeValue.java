package com.leetcode;

import com.leetcode.repository.TreeNode;
import com.leetcode.repository.TreeNodeWrapper;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 2019-06-11 11:22
 *
 * @author Yu Zhen
 **/
public class FindBottomLeftTreeValue {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            root = queue.poll();
            if (root.right != null) {
                queue.add(root.right);
            }
            if (root.left != null) {
                queue.add(root.left);
            }
        }
        return root.val;
    }

    public static void main (String[] args) {
        FindBottomLeftTreeValue findBottomLeftTreeValue = new FindBottomLeftTreeValue();
        TreeNode root = TreeNodeWrapper.stringToTreeNode("[2,1,3]");
        System.out.println(findBottomLeftTreeValue.findBottomLeftValue(root));
    }
}
