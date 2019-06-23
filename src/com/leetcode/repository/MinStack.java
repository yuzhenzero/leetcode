package com.leetcode.repository;


import java.util.Stack;

// 155#, Easy
public class MinStack {

    private Stack<Integer> dataStack;
    private Stack<Integer> minStack;
    private int min;

    /**
     * initialize your data structure here.
     */
    public MinStack () {
        dataStack = new Stack<>();
        minStack = new Stack<>();
        min = Integer.MAX_VALUE;
    }

    public void push (int x) {
        dataStack.add(x);
        min = Math.min(min, x);
        minStack.add(min);
    }

    public void pop () {
        dataStack.pop();
        minStack.pop();
        min = minStack.isEmpty() ? Integer.MAX_VALUE : minStack.peek();
    }

    public int top () {
        return dataStack.peek();
    }

    public int getMin () {
        return minStack.peek();
    }

    public static void main (String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-1);
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.top());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());

    }

}
