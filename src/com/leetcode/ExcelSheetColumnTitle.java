package com.leetcode;

/**
 * 2019-07-25 09:26
 * 168, Easy
 *
 * @author Yu Zhen
 **/
public class ExcelSheetColumnTitle {
    public String convertToTitle (int n) {
        if (n == 0) {
            return "";
        }
        n--;
        return convertToTitle(n / 26) + (char) (n % 26 + 'A');
    }

    public static void main (String[] args) {
        ExcelSheetColumnTitle test = new ExcelSheetColumnTitle();
        int n = 27;
        System.out.println(test.convertToTitle(n));
    }
}
