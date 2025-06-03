# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

'''


'''
import java.util.*;
class Leetcode.이재훈.Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (Integer work:works) {
            pq.offer(work);
        }
        while (n>0) {
            pq.offer(pq.poll()-1);
            n--;
        }
        long ans = 0;
        while (!pq.isEmpty()) {
            long val = pq.poll();
            if (val>0) {
                ans += (long) val*val;
            }
        }
        return ans;
    }
}'''