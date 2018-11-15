package com.leetcode;


import java.util.Arrays;

public class Test {
    public static void main(String[] args)
    {
        int[] a = new int[] {3,9,20,2,1,15,7};
        String line = Arrays.toString(a);
        TreeNode root = TreeNodeWrapper.stringToTreeNode(line);
        TreeNodeWrapper.prettyPrintTree(root);
    }

}