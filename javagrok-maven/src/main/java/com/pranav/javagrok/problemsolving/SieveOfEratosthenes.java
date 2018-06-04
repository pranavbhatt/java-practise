package com.pranav.javagrok.problemsolving;

/**
 * https://leetcode.com/problems/count-primes/description/
 * @author pbhatt
 *
 */
public class SieveOfEratosthenes {
	public int countPrimes(int n) {
        if(n < 2) return 0;
        boolean[] sieve = new boolean[n];
        int c = 0;
        for(int i=2;i<n;i++){
            if(!sieve[i]){
                //this number is prime
                c++;
                int j = 2;
                while(i*j < n){
                    sieve[i*j] = true;
                    j++;
                }
            }
        }
        return c;
    }
}
