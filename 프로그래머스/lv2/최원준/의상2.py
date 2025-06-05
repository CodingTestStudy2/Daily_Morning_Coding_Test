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
    public int solution(String[][] clothes) {
        Map<String, Integer> counter = new HashMap<>();
        for (String[] cloth : clothes) {
            counter.put(cloth[1], counter.getOrDefault(cloth[1],0)+1);
        }

        int ans = 1;
        for (int value : counter.values()){
            ans *= (value+1);
        }
        return ans-1;
    }
}

'''

from collections import defaultdict

def solution(clothes):
    c = defaultdict(int)
    for name, part in clothes: c[part] += 1
    if not c: return 0
    ans = 1
    for k, v in c.items(): ans *= (v + 1)
    return ans - 1
