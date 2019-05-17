package com.leetcode;

import com.leetcode.repository.ListNode;
import com.leetcode.repository.ListNodeWrapper;

// 328#, Medium
public class OddEvenLinkedList {
    public ListNode oddEvenList (ListNode head) {
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }

    public static void main (String[] args) {
        OddEvenLinkedList oell = new OddEvenLinkedList();
        ListNode head = ListNodeWrapper.stringToListNode("[1,2,3,4,5]");
        head = oell.oddEvenList(head);
        ListNodeWrapper.prettyPrintLinkedList(head);
    }
}
