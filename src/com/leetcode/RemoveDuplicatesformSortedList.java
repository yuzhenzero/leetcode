package com.leetcode;
// 83#, Easy
public class RemoveDuplicatesformSortedList {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x)
        {
            val = x;
        }
    }

    public ListNode deleteDuplicates(ListNode head)
    {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.val == current.next.val)
                current.next = current.next.next;
            else
                current = current.next;
        }

        return head;
    }

}
