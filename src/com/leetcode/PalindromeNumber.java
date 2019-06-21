package com.leetcode;

/**
 * 2019-06-21 15:40
 * 9, Easy
 * @author Yu Zhen
 **/
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x == 0) {
            return true;
        }
        if (x < 0 || x % 10 == 0) {
            return false;
        }

        int right = 0;
        while (x > right) {
            right = x % 10 + right * 10;
            x /= 10;
        }
        return x == right || x == right / 10;
    }

    public static void main (String[] args) {
        PalindromeNumber palindromeNumber = new PalindromeNumber();
        int x = 1234321;
        System.out.println(palindromeNumber.isPalindrome(x));
    }
}
