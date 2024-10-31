// https://school.programmers.co.kr/learn/courses/30/lessons/42626
// 논리 구조를 정확히 이해하고 조건을 세울 것!!!
import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0, cnt = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)-> o1-o2);
        
        for(int food : scoville){
            pq.offer(food);
        }
        
        while(pq.size()>1 && pq.peek() < K){
            cnt++;
            int first = pq.poll();
            int second = pq.poll();
            pq.offer(first + second*2);
        }
        

        return (pq.peek() < K) ? -1 : cnt;
    }
}
