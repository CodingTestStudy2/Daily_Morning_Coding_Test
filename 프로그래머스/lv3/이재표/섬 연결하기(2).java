import java.util.*;
class Solution {
    public int solution(int n, int[][] costs) {
        int answer = 0;
        PriorityQueue<int[]>pq=new PriorityQueue<>((o1,o2)->o1[1]-o2[1]);
        int[][]arr=new int[n][n];
        for(int i=0;i<costs.length;i++){
            arr[costs[i][0]][costs[i][1]]=costs[i][2];
            arr[costs[i][1]][costs[i][0]]=costs[i][2];
        }
        boolean[]visit=new boolean[n];
        pq.offer(new int[]{0,0});
        while(!pq.isEmpty()){
            int[]poll=pq.poll();
            if(visit[poll[0]]){
                continue;
            }
            
            visit[poll[0]]=true;
            answer+=poll[1];
            
            for(int i=0;i<n;i++){
                if(arr[poll[0]][i]!=0){
                    pq.offer(new int[]{i,arr[poll[0]][i]});
                }
            }
            
        }
        
        
        return answer;
    }
}
