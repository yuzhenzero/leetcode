package com.leetcode;

import java.util.ArrayList;
import java.util.List;

// 119#, Easy
public class PascalTriangle2 {
    public List<Integer> getRow(int rowIndex)
    {
        List<Integer> ans = new ArrayList<>();
        if (rowIndex < 0) {
            return ans;
        }

        for (int i = 0; i < rowIndex + 1; i++) {
            ans.add(0, 1);  // 每一次在数组的最前面加上一个元素1
            for (int j = 1; j < ans.size() - 1; j++) {
                ans.set(j, ans.get(j) + ans.get(j + 1));
            }
        }

        return ans;
    }

    public static void main(String[] args)
    {
        PascalTriangle2 pt2 = new PascalTriangle2();
        System.out.println(pt2.getRow(3));
    }
}
