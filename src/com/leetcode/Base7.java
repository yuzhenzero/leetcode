package com.leetcode;

/**
 * 2019-07-24 21:43
 * 504, Easy
 *
 * @author Yu Zhen
 **/
public class Base7 {
    public String convertToBase7 (int num) {
        if (num == 0) {
            return "0";
        }
        boolean isNegative = num < 0;
        if (isNegative) {
            num = -num;
        }
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.append(num % 7);
            num /= 7;
        }
        String ans = sb.reverse().toString();
        return isNegative ? "-" + ans : ans;
    }

    public static void main (String[] args) {
        Base7 test = new Base7();
        int num = 100;
        System.out.println(test.convertToBase7(num));
    }
}
