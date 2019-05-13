package com.leetcode;

/**
 * @author Yu Zhen
 **/
// 24#, Medium
public class SwapNodesinPairs {
    public ListNode swapPairs (ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;

        while (pre.next != null && pre.next.next != null) {
            ListNode l1 = pre.next;
            ListNode l2 = pre.next.next;
            l1.next = l2.next;
            l2.next = l1;
            pre.next = l2;

            pre = l1;
        }

        return dummy.next;
    }

    public static void main (String[] args) {
        SwapNodesinPairs snp = new SwapNodesinPairs();
        ListNode head = ListNodeWrapper.stringToListNode("[1,2,3,4,5]");
        ListNodeWrapper.prettyPrintLinkedList(snp.swapPairs(head));
    }
}
