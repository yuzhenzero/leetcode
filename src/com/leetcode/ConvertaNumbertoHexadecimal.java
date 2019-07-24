package com.leetcode;

/**
 * 2019-07-24 21:54
 * 405, Easy
 *
 * @author Yu Zhen
 **/
public class ConvertaNumbertoHexadecimal {
    public String toHex (int num) {
        char[] map = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};
        if (num == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            sb.append(map[num & 0b1111]);
            num >>>= 4;
        }
        return sb.reverse().toString();
    }

    public static void main (String[] args) {
        ConvertaNumbertoHexadecimal test = new ConvertaNumbertoHexadecimal();
        int num = 26;
        System.out.println(test.toHex(num));
    }
}
