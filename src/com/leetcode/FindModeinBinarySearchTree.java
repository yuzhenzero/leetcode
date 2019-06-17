package com.leetcode;

import com.leetcode.repository.TreeNode;
import com.leetcode.repository.TreeNodeWrapper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2019-06-17 10:34
 * 501, Easy
 * @author Yu Zhen
 **/
public class FindModeinBinarySearchTree {
    private int curCnt = 1;
    private int maxCnt = 1;
    TreeNode pre = null;

    public int[] findMode(TreeNode root) {
        List<Integer> nums = new ArrayList<>();
        inorder(root, nums);
        int[] ans = new int[nums.size()];
        int index = 0;
        for (Integer num : nums) {
            ans[index++] = num;
        }
        return ans;
    }

    private void inorder (TreeNode node, List<Integer> nums) {
        if (node == null) {
            return;
        }
        inorder(node.left, nums);
        if (pre != null) {
            if (pre.val == node.val) curCnt++;
            else curCnt = 1;
        }
        if (curCnt > maxCnt) {
            maxCnt = curCnt;
            nums.clear();
            nums.add(node.val);
        } else if (curCnt == maxCnt) {
            nums.add(node.val);
        }
        pre  = node;
        inorder(node.right, nums);
    }

    public static void main (String[] args) {
        FindModeinBinarySearchTree findModeinBinarySearchTree = new FindModeinBinarySearchTree();
        TreeNode root = TreeNodeWrapper.stringToTreeNode("[1,null,2,2]");
        System.out.println(Arrays.toString(findModeinBinarySearchTree.findMode(root)));
    }
}
