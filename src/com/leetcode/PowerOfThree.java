package com.leetcode;

// 326#, Easy
public class PowerOfThree {
    public boolean isPowerOfThree (int n) {
        if (n >= 6 && n % 3 != 0)
            return false;
        if (n == 0) return false;
        if (n == 1) return true;
        if (n == 3) return true;
        if (n == 2 || n == 4 || n == 5) return false;
        return isPowerOfThree(n / 3);
    }

    public static void main (String[] args) {
        PowerOfThree pt = new PowerOfThree();
        System.out.println(pt.isPowerOfThree(27));
    }
}
