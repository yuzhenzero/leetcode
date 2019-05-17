package com.leetcode;

import com.leetcode.repository.ListNode;
import com.leetcode.repository.ListNodeWrapper;

/**
 * @author Yu Zhen
 **/

// 725#, Medium
public class SplitLinkedListinParts {
    public ListNode[] splitListToParts (ListNode root, int k) {
        ListNode cur = root;
        int len = 0;
        while (cur != null) {
            cur = cur.next;
            len++;
        }

        int mod = len % k;
        int size = len / k;
        cur = root;
        ListNode[] ans = new ListNode[k];
        for (int i = 0; cur != null && i < k; i++) {
            ans[i] = cur;
            int curSize = size + (mod-- > 0 ? 1 : 0);
            for (int j = 0; j < curSize - 1; j++) {
                cur = cur.next;
            }
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
        }
        return ans;
    }

    public static void main (String[] args) {
        SplitLinkedListinParts sllp = new SplitLinkedListinParts();
        ListNode root = ListNodeWrapper.stringToListNode("[1, 2, 3, 4, 5, 6, 7, 8, 9, 10]");
        int k = 3;
        for (ListNode listNode : sllp.splitListToParts(root, k)) {
            ListNodeWrapper.prettyPrintLinkedList(listNode);
        }

    }
}
