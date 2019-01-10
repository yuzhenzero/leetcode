package com.leetcode;

// 2#, Medium
public class AddTwoNumbers {
    public ListNode addTwoNumbers (ListNode l1, ListNode l2) {
        int flag = 0;
        ListNode ans = new ListNode(0); // 实际上是一个哑节点
        ListNode cur = ans;
        while (l1 != null || l2 != null) {
            int x = l1 != null ? l1.val : 0;
            int y = l2 != null ? l2.val : 0;
            int sum = x + y + flag;

            cur.next = new ListNode(sum % 10);
            flag = sum / 10;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
            cur = cur.next;
        }
        if (flag != 0) {
            cur.next = new ListNode(flag);
        }
        return ans.next;
    }

    public static void main (String[] args) {
        AddTwoNumbers atn = new AddTwoNumbers();
        String s1 = "[2,4,3]";
        String s2 = "[5,6,4]";

        ListNode node1 = ListNodeWrapper.stringToListNode(s1);
        ListNode node2 = ListNodeWrapper.stringToListNode(s2);
        ListNode ans = atn.addTwoNumbers(node1,node2);
        ListNodeWrapper.prettyPrintLinkedList(ans);
    }
}
