package PACKAGE_NAME;

import java.util.Arrays;

public class LC1175 {
    public static final int MODULO = (int) Math.pow(10, 9) + 7;
    public static final int PRIME_SIZE = 100;

    public int numPrimeArrangements(int n) {
        boolean[] primes = new boolean[PRIME_SIZE + 1];
        initPrimes(primes);

        int primeCount = 0;
        for (int i = 1; i <= n; i++) {
            if (primes[i]) {
                primeCount++;
            }
        }

        return (int) ((factorial(primeCount) * factorial(n - primeCount)) % MODULO);
    }

    private long factorial(int n) {
        long ret = 1;
        for (int i = 2; i <= n; i++) {
            ret = ret * i;
            ret %= MODULO;
        }
        return ret;
    }

    private void initPrimes(boolean[] primes) {
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;
        for (int i = 2; i <= PRIME_SIZE; i++) {
            if (!primes[i]) {
                continue;
            }
            for (int j = 2 * i; j <= PRIME_SIZE; j += i) {
                primes[j] = false;
            }
        }
    }
}
