import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC_2039 {
    public int networkBecomesIdle(int[][] edges, int[] patience) {
        int n = patience.length;
        List<Integer>[] graph = new ArrayList[n];
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] edge:edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        // 최단거리 계산 (BFS)
        int start = 0;
        int[] sTime = new int[n];
        Arrays.fill(sTime, -1);
        sTime[start] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while(!q.isEmpty()){
            int node = q.poll();
            for(int a : graph[node]){
                // 방문 X 노드
                if(sTime[a] == -1){
                    sTime[a] = sTime[node]+1;
                    q.add(a);
                }
            }
        }

        // 각 소요시간 계산
        int maxTime = -1;
        for(int i = 1; i<n; i++){
            // 마지막 전송 시점
            int lastSend = ((sTime[i]*2 -1) / patience[i]) * patience[i]; 
            maxTime = Math.max(maxTime, lastSend + sTime[i]*2);
        }
        return maxTime+1;
    }
}