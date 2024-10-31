# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int ans = 0;
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (int s : scoville) pq.offer((long) s);

        while (pq.size() > 1 && pq.peek() < K) {
            pq.offer(pq.poll() + pq.poll() * 2);
            ans++;
        }

        return pq.peek() >= K ? ans : -1;
    }
}


'''


