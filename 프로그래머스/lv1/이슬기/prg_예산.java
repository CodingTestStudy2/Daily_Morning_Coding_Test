/**
* 물품 지원
{1, 2, 3, 4, 5}
작은 예산부터 지원해주는 것
*/
import java.util.*;

class Solution {
    public int solution(int[] d, int budget) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (var i=0; i<d.length; i++) {
            pq.offer(d[i]);
        }
        
        int cost = 0;
        
        while (!pq.isEmpty()) {
            int now = pq.poll();
            if (cost + now > budget) {
                break;
            }
            cost += now;
            answer++;
        }
        
        return answer;
    }
}