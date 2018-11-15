package com.leetcode;

import java.util.ArrayList;
import java.util.List;

// 412#, Easy
public class FizzBuzz {
    public List<String> fizzBuzz (int n) {
        List<String> ans = new ArrayList<String>(n);
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                ans.add(i-1, "FizzBuzz");
            } else if (i % 3 == 0) {
                ans.add(i-1, "Fizz");
            } else if (i % 5 == 0) {
                ans.add(i-1, "Buzz");
            } else {
                ans.add(i-1,String.valueOf(i));
            }
        }
        return ans;
    }

    public static void main (String[] args) {
        FizzBuzz fb = new FizzBuzz();
        System.out.println(fb.fizzBuzz(15));
    }
}
