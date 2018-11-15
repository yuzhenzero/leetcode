package com.leetcode;
// 557#, Easy
public class ReverseWords3 {
    public String reverseWords(String s)
    {
        String[] words = s.split(" ");
        StringBuilder reverse_String = new StringBuilder();
        for (String word :
                words) {
            reverse_String.append(new StringBuffer(word).reverse().toString() + " ");
        }

        return reverse_String.toString().trim();
    }

    public static void main(String[] args)
    {
        ReverseWords3 rw3 = new ReverseWords3();
        String s = "Let's take LeetCode contest";
        System.out.println(rw3.reverseWords(s));
    }
}
