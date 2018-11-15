package com.leetcode;
// 14#, Easy
public class LongestCommonPrefix {
    // 方法1：横向扫描法
    public String longestCommonPrefix(String[] strs)
    {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i<strs.length;i++)
        {
            while (strs[i].indexOf(prefix) != 0)
            {
                prefix = prefix.substring(0,prefix.length()-1);
                if (prefix.isEmpty())   return "";
            }
        }
        return prefix;
    }

    // 方法2： 纵向扫描法
    public String longestCommonPrefix_2(String[] strs)
    {
        if (strs.length == 0)   return "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || c != strs[j].charAt(i)) {
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0]; // 第一个元素比其他的元素都短
    }

    // 方法3： 分治法
    // 方法4： 二分搜索法

    public static void main(String[] args)
    {
        LongestCommonPrefix lcp = new LongestCommonPrefix();
        String[] a = {"flower", "flow", "flight"};
        String[] b = {"dog", "racecar", "car"};
        System.out.println(lcp.longestCommonPrefix_2(a));
        System.out.println(lcp.longestCommonPrefix_2(b));
    }

}
