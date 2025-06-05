# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;
<<<<<<< HEAD
class Leetcode.이재훈.이재훈.Solution {
=======
class Leetcode.이재훈.Solution {
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (a, b) -> {
            int c = a.charAt(n) - b.charAt(n);
            return c == 0? a.compareTo(b) : c;
        });
        return strings;
    }
}

'''

def solution(strings, n):
    return sorted(strings, key=lambda x: (x[n], x))
