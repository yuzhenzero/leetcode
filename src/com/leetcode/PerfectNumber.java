package com.leetcode;
// #507
public class PerfectNumber {
    public int pn(int p)
    {
        return ((1 <<(p - 1)) * ((1<<p)-1));
    }

    public boolean checkPerfectNumber(int num)
    {
        int[] primes = new int[] {2,3,5,7,13,17,19,31};
        for (int prime :
                primes) {
            if (pn(prime) == num)
                return true;
        }
        return false;

    }

    public static void main(String[] args)
    {
        PerfectNumber pn1 = new PerfectNumber();
        System.out.println(pn1.checkPerfectNumber(28));
        System.out.println(pn1.checkPerfectNumber(27));
    }
}
