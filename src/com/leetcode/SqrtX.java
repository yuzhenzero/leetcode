package com.leetcode;

// 69#, Easy
public class SqrtX {
    public int mySqrt (int x) {
        if (x <= 1)
            return x;
        int l = 1, h = x;
        while (l <= h) {
            int mid = l + (h - l) / 2;
            int sqrt = x / mid;
            if (mid == sqrt) {
                return mid;
            } else if (mid > sqrt) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return h;
    }

    public static void main (String[] args) {
        SqrtX sx = new SqrtX();
        int x = 8;
        System.out.println(sx.mySqrt(x));
    }
}
