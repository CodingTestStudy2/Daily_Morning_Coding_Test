/*
least + (second least * 2)
모든 음식의 스코빌 지수 >= K 될 때까지 
음식을 섞은 횟수의 최솟값 구하기 

N <= 100만 -> 최소 힙 이용 (정렬 상태 유지)
K <= 10억 
scoville[i] <= 100만 -> 합은 long 
*/
import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        boolean success = false;
        
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for(int e: scoville){
            pq.offer(new Long(e));
        }
        
        while(!pq.isEmpty()){
            if(pq.peek() >= K){
                success = true; 
                break;
            }
            
            // poll에 대한 예외 처리 필수! 
            if(pq.size() == 1){ 
                break; 
            }
            
            Long first = pq.poll();
            Long second = pq.poll(); 
            pq.offer(first + (second * 2));
            answer++;
        }
        
        if(success) return answer;
        else return -1;
    }
}