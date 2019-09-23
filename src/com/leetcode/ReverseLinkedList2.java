package com.leetcode;

import com.leetcode.repository.ListNode;

/**
 * 2019-08-29 11:03
 *
 * @author Yu Zhen
 **/
public class ReverseLinkedList2 {
    public ListNode reverseBetween (ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }
        ListNode node = null;
        ListNode cur = pre.next;
        for (int i = 0; i < n - m - 1; i++) {
            ListNode tmp = cur.next;
            cur.next = node;
            node = cur;
            cur = tmp;
        }
        pre.next.next = cur;
        pre.next = node;
        return dummy.next;
    }
}
