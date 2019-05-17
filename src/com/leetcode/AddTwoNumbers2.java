package com.leetcode;

import com.leetcode.repository.ListNode;
import com.leetcode.repository.ListNodeWrapper;

import java.util.Stack;

/**
 * @author Yu Zhen
 **/

// 445#, Medium
public class AddTwoNumbers2 {
    public ListNode addTwoNumbers (ListNode l1, ListNode l2) {
        Stack<Integer> l1Stack = listNodetoStack(l1);
        Stack<Integer> l2Stack = listNodetoStack(l2);
        int carry = 0;
        ListNode head = new ListNode(-1);
        while (!l1Stack.isEmpty() || !l2Stack.isEmpty() || carry != 0) {
            int x = l1Stack.isEmpty() ? 0 : l1Stack.pop();
            int y = l2Stack.isEmpty() ? 0 : l2Stack.pop();
            int sum = x + y + carry;
            ListNode node = new ListNode(sum % 10);
            carry = sum / 10;
            node.next = head.next;
            head.next = node;
        }
        return head.next;
    }

    private Stack<Integer> listNodetoStack (ListNode head) {
        Stack<Integer> stack = new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;
        }
        return stack;
    }

    public static void main (String[] args) {
        AddTwoNumbers2 atn2 = new AddTwoNumbers2();
        ListNode l1 = ListNodeWrapper.stringToListNode("[7,2,4,3]");
        ListNode l2 = ListNodeWrapper.stringToListNode("[5,6,4]");
        ListNodeWrapper.prettyPrintLinkedList(atn2.addTwoNumbers(l1, l2));
    }
}
