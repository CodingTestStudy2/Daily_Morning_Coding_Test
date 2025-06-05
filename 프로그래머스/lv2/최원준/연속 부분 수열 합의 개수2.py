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
    public int solution(int[] elements) {
        int n = elements.length;
        Set<Integer> totals = new HashSet<>();
        for (int i=0; i<n; i++){
            int curr = 0;
            for (int j=i; j<i+n; j++){
                curr += elements[j%n];
                totals.add(curr);
            }
        }
        return totals.size();
    }
}

'''


