package com.ajd.prep.dsa.array;

import java.util.ArrayList;
import java.util.List;

public class PrimeEnumeration {
    public List<Integer> findAllPrimesInRange(int n) {
        List<Integer> primes = new ArrayList<>();
        if(n < 2) {
            return primes;
        }

        primes.add(2);

        for(int i = 3; i<=n; i++) {
            boolean isPrime = true;
            int sqrt = (int) Math.sqrt(i);
            inner: for(int prime : primes) {
                if(prime > sqrt) {
                    break inner;
                }
                if(i % prime == 0) {
                    isPrime = false;
                    break;
                }
            }

            if(isPrime) {
                primes.add(i);
            }
        }

        return primes;
    }

    public int countPrimes(int n) {
        if(n < 3) {
            return 0;
        }

        boolean[] isPrime = new boolean[n];
        int count = 0;
        for(int i = 2; i < n; i++) {
            if(!isPrime[i]) {
                count++;
                for(int j = 2; i*j <n; j++) {
                    isPrime[i*j] = true;
                }
            }
        }

        return count;
    }
}
