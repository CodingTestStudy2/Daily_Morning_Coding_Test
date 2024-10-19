import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        PriorityQueue<Integer> pq= new PriorityQueue<>((o1,o2)-> o2-o1);
        
        for(int i=0; i<priorities.length; i++){
            pq.offer(priorities[i]);
        }
        
        Queue<int[]> q = new LinkedList<>();
        
        for(int i=0; i<priorities.length; i++){
            q.offer(new int[]{i, priorities[i]});
        }
        
        while(!q.isEmpty()){
            
            if(q.peek()[1] == pq.peek()){ //우선순위가 같을때
                if(q.peek()[0] == location)
                    return ++answer; //location이 같을때
                else{
                    q.poll();
                    pq.poll();
                    answer++;
                }
            }else{
                int[] poll = q.poll();
                q.offer(poll);
                
            }
            
            
            
        }
        
        return answer;
    }
}
