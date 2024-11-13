import java.util.*;
class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<scoville.length; i++){
            pq.offer(scoville[i]);
        }
        
        int cnt = 0;
        while(pq.peek()<K&&pq.size()>=2){  
            int first = pq.poll();
            int second = pq.poll();
            
            pq.offer(first+second*2);
            cnt++;
        }
        
        if(pq.peek()>=K) return cnt;
        else return -1;
        
    }
}