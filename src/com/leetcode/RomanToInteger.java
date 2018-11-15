package com.leetcode;

// 13#, Easy
public class RomanToInteger {
    public int romanToInt (String s) {
        int sum = 0;
        if (s.contains("IV")) sum -= 2;
        if (s.contains("IX")) sum -= 2;
        if (s.contains("XL")) sum -= 20;
        if (s.contains("XC")) sum -= 20;
        if (s.contains("CD")) sum -= 200;
        if (s.contains("CM")) sum -= 200;

        char[] chars = s.toCharArray();
        for (char aChar : chars) {
            if (aChar == 'I') sum += 1;
            if (aChar == 'V') sum += 5;
            if (aChar == 'X') sum += 10;
            if (aChar == 'L') sum += 50;
            if (aChar == 'C') sum += 100;
            if (aChar == 'D') sum += 500;
            if (aChar == 'M') sum += 1000;
        }
        return sum;
    }

    public static void main (String[] args) {
        RomanToInteger rti = new RomanToInteger();
        System.out.println(rti.romanToInt("MCMXCIV"));
    }
}
