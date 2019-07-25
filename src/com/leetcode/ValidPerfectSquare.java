package com.leetcode;

/**
 * 2019-07-25 20:19
 * 367, Easy
 *
 * @author Yu Zhen
 **/
public class ValidPerfectSquare {
    public boolean isPerfectSquare (int num) {
        int delta = 1;
        while (num > 0) {
            num -= delta;
            delta += 2;
        }
        return num == 0;
    }

    public boolean isPerfectSquare2 (int num) {
        long left = 1, right = num;
        if (num == 1) {
            return true;
        }
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (mid * mid == num) {
                return true;
            } else if (mid * mid > num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main (String[] args) {
        ValidPerfectSquare test = new ValidPerfectSquare();
        int num = 16;
        System.out.println(test.isPerfectSquare2(num));
    }
}
