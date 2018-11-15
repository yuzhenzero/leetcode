package com.leetcode;
// 8#, Medium
public class StringtoInteger {
    public int myAtoi(String str) {
        if (str.isEmpty())
            return 0;

        str = str.trim();
        if (str.isEmpty()) {
            return 0;
        }
        int i = 0,ans = 0, sign = 1, len = str.length();
        if (str.charAt(0) == '-' || str.charAt(0) == '+') {
            sign = str.charAt(i++) == '+'?1:-1;
        }
        for (; i < len; i++)
        {
            int temp = str.charAt(i) - '0';
            if (temp > 9 || temp < 0)
                break;
            if (ans > Integer.MAX_VALUE / 10
                    || (ans == Integer.MAX_VALUE / 10 && temp > Integer.MAX_VALUE % 10))
                return sign == 1 ? Integer.MAX_VALUE: Integer.MIN_VALUE;
            else
                ans = ans * 10 + temp;
        }

        return sign * ans;

    }

    public static void main(String[] args)
    {
        StringtoInteger si = new StringtoInteger();
        String s = "-91283472332";
        System.out.println(si.myAtoi(s));
    }
}
