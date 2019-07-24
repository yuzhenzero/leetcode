package com.leetcode;

// 204#, Easy
public class CountPrimes {
    public int countPrimes (int n) {
        boolean[] not_prime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (not_prime[i])
                continue;
            count++;
            for (int j = i * i; j < n; j += i) {
                not_prime[j] = true;
            }
        }
        return count;
    }

    public static void main (String[] args) {
        CountPrimes cp = new CountPrimes();
        System.out.println(cp.countPrimes(10));
    }
}
