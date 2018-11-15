package com.leetcode;

// 108#, Easy
public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums.length == 0) return null;

        TreeNode root = put(nums, 0, nums.length - 1);

        return root;
    }

    private TreeNode put (int[] nums, int low, int high) {
        if (low > high) return null;

        int mid = (low + high) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = put(nums,low, mid - 1);
        root.right = put(nums, mid + 1, high);

        return root;

    }

    public static void main (String[] args) {
        ConvertSortedArrayToBinarySearchTree csatbst = new ConvertSortedArrayToBinarySearchTree();
        int[] bst_array = new int[] {0,1,2,3,4,5};
        TreeNode root = csatbst.sortedArrayToBST(bst_array);
        TreeNodeWrapper.prettyPrintTree(root);
    }
}
