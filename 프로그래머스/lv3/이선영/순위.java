import java.util.*;

class Solution {
    static List<Integer>[] list, out;
    public int solution(int n, int[][] results) {
        int answer = 0;
        list = new ArrayList[n+1];
        out = new ArrayList[n+1];
        for(int i=0; i<list.length; i++){
            list[i] = new ArrayList<Integer>();
            out[i] = new ArrayList<Integer>();
        }
        
        
        for(int i=0; i<results.length; i++){
            int winner = results[i][0];
            int loser = results[i][1];   
            list[loser].add(winner);
            out[winner].add(loser);
        }
        
        int[] cnt = new int[n+1];
        for(int i=1; i<=n; i++){
            
            boolean[] visited = new boolean[n+1];
            if( n-1 == (solve(list, i, visited)+solve(out, i , visited))) {
                answer++;
            }
        }
        return answer;
    }
    
    public int solve(List<Integer>[] list, int now, boolean[] visited){
        int cnt = 0;
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(now);
        
        while(!q.isEmpty()){
            
            int cur = q.poll();
            
            for(int i=0; i<list[cur].size(); i++){
                if(!visited[list[cur].get(i)]){
                    q.offer(list[cur].get(i));
                    visited[list[cur].get(i)] = true;
                    cnt++;
                }
            }
        }
        
        return cnt;
    }
}
