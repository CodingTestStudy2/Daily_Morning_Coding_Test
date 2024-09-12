import java.util.Arrays;

class Solution {
    public int solution(int n) {
        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);

        prime[0] = false;
        prime[1] = false;

        // 2부터 n의 제곱근까지 모든 수를 확인하며
        for (int i = 2; i * i <= n; i++) {
            if (prime[i]) {
                // i 자신을 제외한 i의 배수 모두 지우기 
                for(int j = 2 * i; j <= n; j += i){ 
                    prime[j] = false;
                }
            }
        }

        int cnt = 0;
        for (int i = 2; i <= n; i++) {
            if (prime[i]) cnt++;
        }

        return cnt;
    }
}