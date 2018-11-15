package com.leetcode;

import java.util.Arrays;
// 66#, Easy
public class PlusOne {
    public int[] plusOne(int[] digits)
    {
        int length = digits.length;
        for (int i = length -1; i >=0; i--)
        {
            if (digits[i] < 9)
            {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }

        int[] temp = new int[length + 1];
        temp[0] = 1;
        return temp;
    }

    public static void main(String[] args)
    {
        PlusOne po = new PlusOne();
        int[] a = new int[] {1,2,3};
        int[] b = po.plusOne(a);
//        System.out.println(b);
//        这里的参数不能直接使用b, 这样打印出来的是b数组的地址。
        System.out.println(Arrays.toString(b));

    }
}
