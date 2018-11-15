package com.leetcode;

public class MyDoubleLinkedList {

    int length;
    Node head;

    static class Node {
        int val;
        Node pre;
        Node next;

        Node(int x)
        {
            this.val = x;

        }
    }

    /**
     * Initialize your data structure here.
     */
    public MyDoubleLinkedList()
    {
        this.length = 0;
        this.head = null;
    }

    /**
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1.
     */
    public int get(int index)
    {
        if (index < 0 || index >= this.length)
            return -1;
        else {
            int count = 0;
            Node current = head;
            while (count != index) {
                current = current.next;
                count++;
            }
            return current.val;
        }
    }

    /**
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list.
     */
    public void addAtHead(int val)
    {
        if (this.length == 0) {
            head = new Node(val);
            this.length++;
            return;
        }
        Node oldfirst = head;
        head = new Node(val);
        head.next = oldfirst;
        oldfirst.pre = head;
        this.length++;
    }

    /**
     * Append a node of value val to the last element of the linked list.
     */
    public void addAtTail(int val)
    {
        if (this.length == 0) {
            addAtHead(val);
            this.length++;
            return;
        }
        Node last = head;
        while (last.next != null) {
            last = last.next;
        }
        Node oldlast = last;
        last = new Node(val);
        oldlast.next = last;
        last.pre = oldlast;
        this.length++;
    }

    /**
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list,
     * the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted.
     */
    public void addAtIndex(int index, int val)
    {
        if (index < 0 || index > this.length)
            return;
        if (index == 0) {
            addAtHead(val);
            return;
        }
        if (index == this.length) {
            addAtTail(val);
            return;
        }
        Node new_node = new Node(val);
        int count = 0;
        Node current = head;
        while (count != index - 1) {
            current = current.next;
            count++;
        }
        new_node.pre = current;
        new_node.next = current.next;
        current.next.pre = new_node;
        current.next = new_node;

        this.length++;
    }

    /**
     * Delete the index-th node in the linked list, if the index is valid.
     */
    public void deleteAtIndex(int index)
    {
        if (index < 0 || index >= this.length)
            return;
        Node current = head;
        int count = 0;
        while (count != index) {
            current = current.next;
            count++;
        }

        if (current.pre == null) {
            head = current.next;
        } else if (current.next == null) {
            current.pre.next = null;
        } else {
            current.pre.next = current.next;
            current.next.pre = current.pre;
        }
        this.length--;
    }

    public String toString()
    {
        String result = "";
        if (head == null)
            return result;

        Node node = head;
        while (node != null) {
            if (result == "")
                result += head.val;
            else
                result += "->" + node.val;
            node = node.next;
        }
        return result;
    }

    public static void main(String[] args)
    {
        MyDoubleLinkedList linkedList = new MyDoubleLinkedList();

        linkedList.addAtHead(1);
        System.out.println(linkedList);

        linkedList.addAtTail(3);
        System.out.println(linkedList);

        linkedList.addAtIndex(1, 2);
        System.out.println(linkedList);


        System.out.println(linkedList.get(1));

        linkedList.deleteAtIndex(1);
        System.out.println(linkedList);

        System.out.println(linkedList.get(1));
    }
}
