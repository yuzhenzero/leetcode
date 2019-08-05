package com.leetcode;

import java.util.Hashtable;

/**
 * 2019-08-05 16:40
 * 146, Medium
 *
 * @author Yu Zhen
 **/
public class LRUCache {
    private Hashtable<Integer, DLinkedNode> cache = new Hashtable<>();
    private int size;
    private int capacity;
    private DLinkedNode head, tail;

    class DLinkedNode {
        int key;
        int value;
        DLinkedNode prev;
        DLinkedNode next;
    }

    /**
     * 在链表头插入新节点
     *
     * @param node 待插入的节点
     */
    private void addNode (DLinkedNode node) {
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
    }

    /**
     * 删除链表中的一个节点
     *
     * @param node 待删除的节点
     */
    private void removeNode (DLinkedNode node) {
        DLinkedNode prev = node.prev;
        DLinkedNode next = node.next;

        prev.next = next;
        next.prev = prev;
    }

    /**
     * 将一个节点移动到头部
     *
     * @param node 待移动的节点
     */
    private void moveToHead (DLinkedNode node) {
        removeNode(node);
        addNode(node);
    }

    /**
     * 获取尾部的节点，并删除
     *
     * @return 尾部的节点
     */
    private DLinkedNode popTail () {
        DLinkedNode node = tail.prev;
        removeNode(node);
        return node;
    }


    public LRUCache (int capacity) {
        this.size = 0;
        this.capacity = capacity;

        head = new DLinkedNode();
        tail = new DLinkedNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get (int key) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put (int key, int value) {
        DLinkedNode node = cache.get(key);
        if (node == null) {
            DLinkedNode newNode = new DLinkedNode();
            newNode.key = key;
            newNode.value = value;

            cache.put(key, newNode);
            addNode(newNode);

            ++size;
            if (size > capacity) {
                DLinkedNode tail = popTail();
                cache.remove(tail.key);
                --size;
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }
}
