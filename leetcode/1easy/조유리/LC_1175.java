public class LC_1175 {
    class Solution {
        public int numPrimeArrangements(int n) {
            int MOD = (int)(1e9 + 7);
            int primes = countPrimes(n);
            int nonPrimes = n - primes;
            
            long ans = 1;
            for(int i=1; i<=primes; i++){
                ans = ans * i % MOD;
            }
            for(int i=1; i<=nonPrimes; i++){
                ans = ans * i % MOD;
            }
            return (int)ans;
        }
    
        public int countPrimes(int n){
            int cnt = 0;
            for(int i=2; i<=n; i++){
                if(isPrime(i)){
                    cnt++;
                }
            }
            return cnt;
        }
    
        public boolean isPrime(int num){
            boolean isPrime = true;
            for(int i=2; i<=Math.sqrt(num); i++){
                if(num%i == 0){
                    isPrime = false;
                    break;
                }
            }
            return isPrime;
        }
    }
}