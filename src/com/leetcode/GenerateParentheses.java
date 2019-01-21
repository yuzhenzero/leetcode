package com.leetcode;

import java.util.ArrayList;
import java.util.List;

// 22#, Medium
public class GenerateParentheses {
    public List<String> generateParenthesis (int n) {
        List<String> ans = new ArrayList<>();
        backtrack(ans, "", 0, 0, n);
        return ans;
    }

    private void backtrack (List<String> ans, String cur, int l, int r, int max) {
        if (cur.length() == 2 * max) {
            ans.add(cur);
            return;
        }

        if (l < max)
            backtrack(ans, cur + "(", l + 1, r, max);
        if (r < l) // 保证平衡
            backtrack(ans, cur + ")", l, r + 1, max);
    }

    public static void main (String[] args) {
        GenerateParentheses gp = new GenerateParentheses();
        System.out.println(gp.generateParenthesis(3));
    }
}
