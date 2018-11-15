package com.leetcode;
// 38#, Easy
public class CountAndSay {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String pre = countAndSay(n-1);
        StringBuilder ans = new StringBuilder();
        int i = 0;
        while (i < pre.length())
        {
            char cur = pre.charAt(i);
            int j = 0;
            while (i+j < pre.length() && pre.charAt(i+j) == cur)
                j++;
            ans.append(j);
            ans.append(cur);
            i += j;
        }
        return ans.toString();

    }

    public static void main(String[] args)
    {
        CountAndSay cas = new CountAndSay();
        System.out.println(cas.countAndSay(6));

    }
}
