# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

'''


'''
import java.util.*;
<<<<<<< HEAD
class Leetcode.이재훈.이재훈.Solution {
=======
class Leetcode.이재훈.Solution {
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
    public int solution(int n) {
        var sieve = new boolean[n+1];
        var start = 2;

        var m = (int) Math.sqrt(n+1);
        for (int i = 2; i <= m; i++) {
            if (!sieve[i]) {
                for (int j = i + i; j < n+1; j += i) {
                    sieve[j] = true;
                }
            }
        }
        var count = 0;
        for (int i = start; i < n+1; i++) {
            if (!sieve[i]) count++;
        }
        return count;
    }
}'''
