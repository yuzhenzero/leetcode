package com.leetcode;

import java.util.*;

// 49#, Medium
public class GroupAnagrams {
    public List<List<String>> groupAnagrams (String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List> ans = new HashMap<>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String k = String.valueOf(ca);
            if (!ans.containsKey(k)) {
                ans.put(k, new ArrayList());
            }
            ans.get(k).add(s);
        }
        return new ArrayList(ans.values());
    }

    public static void main (String[] args) {
        GroupAnagrams ga = new GroupAnagrams();
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(ga.groupAnagrams(strs));
    }
}
