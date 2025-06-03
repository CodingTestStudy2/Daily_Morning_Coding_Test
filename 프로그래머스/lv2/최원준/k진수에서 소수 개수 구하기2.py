# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;

class Leetcode.이재훈.Solution {
    public String toNBin(int n, int k) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            sb.append(n % k);
            n /= k;
        }
        return sb.reverse().toString();
    }

    public boolean isPrime(long n) {
        if (n <= 1) return false;

        for (long i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public int solution(int n, int k) {
        Map<Long, Boolean> cache = new HashMap<>();
        String sNum = toNBin(n, k);

        int ans = 0;
        for (String candid : sNum.split("0+")) {
            if (candid.isEmpty()) continue;
            long number = Long.parseLong(candid);
            cache.put(number, cache.getOrDefault(number, isPrime(number)));
            if (cache.get(number)) ans++;
        }
        return ans;
    }
}


'''


