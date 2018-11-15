package com.leetcode;
// 28#, Easy
/*
本来可以用一行代码搞定的，对String 的API还不是很熟悉
indexOf(String value) 	int 	搜索字符串 value 第一次出现的索引
 */
public class ImplementstrStr {
    public int strStr(String haystack, String needle)
    {
        if (needle.length() == 0)
            return 0;
        int haystack_len = haystack.length();
        int needle_len = needle.length();
        for (int i = 0;i <= haystack_len - needle_len; i++)
        {
            if (haystack.substring(i, i + needle_len).equals(needle))
                return i;
        }
        return -1;
    }

    public static void main(String[] args)
    {
        ImplementstrStr iss = new ImplementstrStr();
        String a = "ll";
        String b = "hello";
        String c = "lll";
        System.out.println(iss.strStr(b,a));
        System.out.println(iss.strStr(b,c));
    }
}
