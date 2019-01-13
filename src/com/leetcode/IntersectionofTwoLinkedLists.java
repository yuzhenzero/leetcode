package com.leetcode;

// 160#, Easy

public class IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode (ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode p1 = headA;
        ListNode p2 = headB;
        while (p1 != p2) {
            if (p1 == null) p1 = headB;
            else p1 = p1.next;
            if (p2 == null) p2 = headA;
            else p2 = p2.next;
        }
        return p1;
    }

    public static void main (String[] args) {
        IntersectionofTwoLinkedLists itll = new IntersectionofTwoLinkedLists();
        ListNode headA = ListNodeWrapper.stringToListNode("[0,9,1,2,4]");
        ListNode headB = ListNodeWrapper.stringToListNode("[3,2,4]");
        // 实际上 headA 和 headB 虽然在 val 上有相同的部分，但是创建时属于不同的内存空间，
        // 所以无法判断相交
        ListNode ans = itll.getIntersectionNode(headA,headB);
        ListNodeWrapper.prettyPrintLinkedList(headB);
    }
}
