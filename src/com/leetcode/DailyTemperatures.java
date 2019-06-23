package com.leetcode;

import java.util.Arrays;
import java.util.Stack;

/**
 * 2019-06-23 14:21
 * 739, Medium
 * @author Yu Zhen
 **/
public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        int n = T.length;
        Stack<Integer> index = new Stack<>();
        int[] ans = new int[n];
        for (int curIndex = 0; curIndex < n; curIndex++) {
            while (!index.isEmpty() && T[curIndex] > T[index.peek()]) {
                int preIndex = index.pop();
                ans[preIndex] = curIndex - preIndex;
            }
            index.add(curIndex);
        }
        return ans;
    }

    public static void main (String[] args) {
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
        System.out.println(Arrays.toString(dailyTemperatures.dailyTemperatures(T)));
    }
}
