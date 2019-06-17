package com.leetcode;

import com.leetcode.repository.TreeNode;
import com.leetcode.repository.TreeNodeWrapper;

import java.util.ArrayList;
import java.util.List;

/**
 * 2019-06-17 09:42
 * 653, Easy
 *
 * @author Yu Zhen
 **/
public class TwoSum4 {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> nums = new ArrayList<>();
        inorder(root, nums);
        int l = 0, r = nums.size() - 1;
        while (l < r) {
            int sum = nums.get(l) + nums.get(r);
            if (sum < k) {
                l++;
            } else if (sum > k) {
                r--;
            } else {
                return true;
            }
        }
        return false;
    }

    private void inorder (TreeNode root, List<Integer> nums) {
        if (root == null) {
            return;
        }
        inorder(root.left, nums);
        nums.add(root.val);
        inorder(root.right, nums);
    }

    public static void main (String[] args) {
        TwoSum4 twoSum4 = new TwoSum4();
        TreeNode root = TreeNodeWrapper.stringToTreeNode("[5,3,6,2,4,null,7]");
        int k = 8;
        System.out.println(twoSum4.findTarget(root,k));
    }

}
