package com.leetcode;

// 204#, Easy
public class CountPrimes {
    public int countPrimes (int n) {
        boolean[] not_prime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!not_prime[i])
                count++;
            for (int j = 2; i * j < n; j++) {
                not_prime[i*j] = true;
            }
        }
        return count;
    }

    public static void main (String[] args) {
        CountPrimes cp = new CountPrimes();
        System.out.println(cp.countPrimes(10));
    }
}
