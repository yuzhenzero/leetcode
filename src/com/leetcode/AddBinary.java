package com.leetcode;
// 67#, Easy
public class AddBinary {
    public String addBinary(String a , String b)
    {
        StringBuffer sb = new StringBuffer();
        int i = a.length() - 1, j = b.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0)
        {
            int sum = carry;
            if (i >= 0)
                sum += a.charAt(i--) - '0';
            if (j >= 0)
                sum += b.charAt(j--) - '0';
            sb.append(sum % 2);
            carry = sum / 2;

        }
        if (carry != 0)
            sb.append(carry);
        return sb.reverse().toString();

    }

    public static void main(String[] args)
    {
        AddBinary ab = new AddBinary();
        String a = new String("11");
        String b = new String("111");
        String c = ab.addBinary(a,b);
        System.out.println(c);

    }
}
