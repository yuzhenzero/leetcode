package com.leetcode;

import java.util.ArrayList;
import java.util.List;

// 118#, Easy
public class PascalTriangle {
    public List<List<Integer>> generate (int numRows) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();

        if (numRows == 0) return ans;

        ans.add(new ArrayList<>()); // 杨辉三角第一行为1
        ans.get(0).add(1);          // 要先使用get()方法获取第一行的数组，再对其进行操作

        for (int rowNum = 1; rowNum < numRows; rowNum++) {
            List<Integer> row = new ArrayList<>();
            List<Integer> preRow = ans.get(rowNum - 1);

            row.add(1); // 每行的第一个元素都是1

            for (int i = 1; i < rowNum; i++) {
                row.add(preRow.get(i - 1) + preRow.get(i));
            }

            row.add(1); // 每行的最后一个元素都是1

            ans.add(row);
        }
        return ans;
    }

    public List<List<Integer>> generate_2 (int numRows) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>(numRows);
        if (numRows==0) return ans;
        ans.add(new ArrayList<>());
        ans.get(0).add(1);
        for (int i = 1; i < numRows; i++) {
            List<Integer> current = new ArrayList<>(numRows);
            List<Integer> pre = ans.get(i-1);
            current.add(1);
            for (int j = 1; j < i; j++) {
                current.add(pre.get(j-1) + pre.get(j));
            }
            current.add(1);
            ans.add(current);
        }
        return ans;
    }


    public static void main (String[] args) {
        PascalTriangle pt = new PascalTriangle();
        System.out.println(pt.generate_2(5));
    }
}
