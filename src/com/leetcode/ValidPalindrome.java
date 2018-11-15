package com.leetcode;
// 125#, Easy
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        String temp = s.replaceAll("\\W", ""); // Java中反斜杠本身需要转义
        temp = temp.toLowerCase();
        String temp_reverse = new StringBuffer(temp).reverse().toString();

        return temp.equals(temp_reverse);

    }

    public static void main(String[] args)
    {
        ValidPalindrome vp = new ValidPalindrome();
        String s = "race a car";

        System.out.println(vp.isPalindrome(s));
    }
}
