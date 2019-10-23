package edu.umb.cs680.hw02;

import java.util.LinkedList;

class PrimeGenerator {

    protected long from, to;
    protected LinkedList<Long> primes;

    //construcor;
    PrimeGenerator(long from, long to) {
        if (from < 1) {
            throw new IllegalArgumentException("start number should bigger than 0");
        }
        if (to < from) {
            throw new IllegalArgumentException("end number should bigger than start number");
        }
        this.from = from;
        this.to = to;
        primes = new LinkedList<Long>();
    }
    public void generatePrimes() {
        for (long i = from+1; i < to; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
    }
    public LinkedList<Long> getPrimes() { 
        return primes; 
        
    }
    
    public boolean isPrime(long n) {
        if (n <= 1) {
            return false;
        }
        for (long i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}