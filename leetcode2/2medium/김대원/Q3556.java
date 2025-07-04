class Solution {

    public long sumOfLargestPrimes(String s) {
        long answer = 0;
        int n = s.length();
        Set<Long> primes = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j <= n; j++) {
                String str = s.substring(i, j);
                long num = Long.parseLong(str);
                if (isPrime(num)) primes.add(num);
            }
        }

        List<Long> result = new ArrayList<>(primes);
        Collections.sort(result, Collections.reverseOrder());
        int size = Math.min(result.size(), 3);
        for (int i = 0; i < size; i++) {
            answer += result.get(i);
        }

        return answer;
    }

    private boolean isPrime(long num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }

        return true;
    }
}
