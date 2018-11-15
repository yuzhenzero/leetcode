package com.leetcode;
// 151#, Medium
public class ReverseWords {
    public String reverseWords(String s)
    {
        String[] s_split = s.trim().split(" +");

        for (int i = 0; i < s_split.length; i++) {
            System.out.println(s_split[i]);
        }
        StringBuffer ans = new StringBuffer();

        for (int i = s_split.length - 1; i >= 1; i--) {
            ans.append(s_split[i] + " ");
        }
        ans.append(s_split[0]);

        return new String(ans);
    }

    public static void main(String[] args)
    {
        String a = "  the sky is blue  ";
        ReverseWords rw = new ReverseWords();
        System.out.println(a);
        System.out.println(rw.reverseWords(a));

    }
}
