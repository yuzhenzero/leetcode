package com.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

// 20#, Easy
public class ValidParentheses {
    private Map<Character, Character> map;

    public ValidParentheses () {
        this.map = new HashMap<>();
        this.map.put(')', '(');
        this.map.put(']', '[');
        this.map.put('}', '{');

    }

    public boolean isValid (String s) {
        Stack<Character> stack = new Stack<>();

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

    public boolean isValid2 (String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char cPop = stack.pop();
                boolean b1 = cPop != '(' && c == ')';
                boolean b2 = cPop != '[' && c == ']';
                boolean b3 = cPop != '{' && c == '}';
                if (b1 || b2 || b3) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main (String[] args) {
        ValidParentheses vp = new ValidParentheses();
        System.out.println(vp.isValid2("()[]{}"));
    }

}
