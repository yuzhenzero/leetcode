package com.leetcode;

import com.leetcode.repository.ListNode;
import com.leetcode.repository.ListNodeWrapper;

/**
 * @author Yu Zhen
 **/
//234#, Easy
public class PalindromeLinkedList {
    public boolean isPalindrome (ListNode head) {
        if (head == null || head.next == null) return true;
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        slow = slow.next;
        slow = reverse(slow);

        while (slow != null) {
            if (head.val == slow.val) {
                head = head.next;
                slow = slow.next;
            } else
                return false;
        }
        return true;

    }

    private ListNode reverse (ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode nextNode = head.next;
            head.next = newHead;
            newHead = head;
            head = nextNode;
        }
        return newHead;
    }


    public static void main (String[] args) {
        PalindromeLinkedList pll = new PalindromeLinkedList();
        ListNode head = ListNodeWrapper.stringToListNode("[1,2,3,2,1]");
        System.out.println(pll.isPalindrome(head));
    }
}
