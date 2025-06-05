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
    public int solution(int n, int k, int[] enemies) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);

        int i = 0;
        while (i < enemies.length && n>=0) {
            int enemy = enemies[i];
            pq.add(enemy);
            n-= enemy;
            if (n < 0) {
                if (k==0) break;
                k--;
                n += pq.poll();
            }
            i++;
        }
        return i;
    }
}
'''



