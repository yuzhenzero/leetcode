package com.leetcode;

import java.util.HashMap;
import java.util.Stack;

// 20#, Easy
public class ValidParentheses {
    private HashMap<Character, Character> map;

    public ValidParentheses () {
        this.map = new HashMap<Character, Character>();
        this.map.put(')', '(');
        this.map.put(']', '[');
        this.map.put('}', '{');

    }

    public boolean isValid (String s) {
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (this.map.containsKey(c)) {
                char top = stack.empty() ? '#' : stack.pop();
                if (top != this.map.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main (String[] args) {
        ValidParentheses vp = new ValidParentheses();
        System.out.println(vp.isValid("()[]{}"));
    }

}
