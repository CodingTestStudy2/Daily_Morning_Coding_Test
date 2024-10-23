import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int len = priorities.length;
        int process[][] = new int[len][2];
        PriorityQueue<int[]> pq = new PriorityQueue<>((q1,q2)-> q2[1]-q1[1]);
        Queue<int[]> queue = new LinkedList<>();
        
        for(int i=0; i<len; i++){
            process[i][0]=i; 
            process[i][1]=priorities[i];
            queue.offer(process[i]);
            pq.offer(process[i]);
        }
        
        int index=0;
        while(!queue.isEmpty()){
            int[] node = queue.poll();
            int[] pqNode = pq.peek();
            if(pqNode[1]>node[1]){
                queue.offer(node);
            }
            else{
                index++;
                pq.poll();
                if(location==node[0])
                    return index;
            }
        }
        
        return 0;
    }
}