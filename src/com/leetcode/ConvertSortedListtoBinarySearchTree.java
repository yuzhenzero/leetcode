package com.leetcode;

import com.leetcode.repository.ListNode;
import com.leetcode.repository.ListNodeWrapper;
import com.leetcode.repository.TreeNode;
import com.leetcode.repository.TreeNodeWrapper;

/**
 * 2019-06-17 11:28
 * 109, Medium
 * @author Yu Zhen
 **/
public class ConvertSortedListtoBinarySearchTree {
    private ListNode head;
    public TreeNode sortedListToBST(ListNode head) {
        int size = getSize(head);
        this.head = head;
        return convertListNode2BST( 0, size - 1);

    }

    private TreeNode convertListNode2BST (int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = (l + r) / 2;
        TreeNode left = convertListNode2BST( l, mid - 1);
        TreeNode node = new TreeNode(head.val);
        node.left = left;
        head = head.next;
        node.right = convertListNode2BST( mid + 1, r);
        return node;
    }

    private int getSize (ListNode head) {
        ListNode node = head;
        int size = 0;
        while (node != null) {
            node = node.next;
            size++;
        }
        return size;
    }

    public static void main (String[] args) {
        ConvertSortedListtoBinarySearchTree c = new ConvertSortedListtoBinarySearchTree();
        ListNode head = ListNodeWrapper.stringToListNode("[-10,-3,0,5,9]");
        TreeNode root = c.sortedListToBST(head);
        System.out.println(TreeNodeWrapper.treeNodeToString(root));

    }


}
