package com.leetcode;

/**
 * 2019-07-25 20:04
 * 415, Easy
 *
 * @author Yu Zhen
 **/
public class AddStrings {
    public String addStrings (String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        int i = num1.length() - 1, j = num2.length() - 1;
        while (i >= 0 || j >= 0 || carry == 1) {
            int x = i < 0 ? 0 : num1.charAt(i--) - '0';
            int y = j < 0 ? 0 : num2.charAt(j--) - '0';
            sb.append((x + y + carry) % 10);
            carry = (x + y + carry) / 10;
        }
        return sb.reverse().toString();
    }

    public static void main (String[] args) {
        AddStrings test = new AddStrings();
        String num1 = "123";
        String num2 = "789";
        System.out.println(test.addStrings(num1, num2));
    }
}
