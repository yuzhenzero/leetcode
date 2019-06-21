package com.leetcode;


import java.util.Arrays;

public class Test {



    public static void main (String[] args) {

        String s = "ab cd efg";
        int[] test = new int[256];
        test['a'] = 1;
        test['b'] = 2;
        for (int i = 0; i < test.length; i++) {
            if (test[i] == 1) {
                System.out.println(i);
            }
        }
        System.out.println('a');
        System.out.println(Arrays.toString(test));


    }



}