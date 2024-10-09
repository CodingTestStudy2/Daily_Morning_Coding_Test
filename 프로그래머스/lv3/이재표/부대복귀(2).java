import java.util.*;
class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[sources.length];
        List<List<Integer>>graph=new ArrayList<>();
        for(int i=0;i<=n;i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0;i<roads.length;i++){
            graph.get(roads[i][0]).add(roads[i][1]);
            graph.get(roads[i][1]).add(roads[i][0]);
        }
        boolean[] visit=new boolean[n+1];
        int[] distance=new int[n+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
        distance[destination]=0;
        Queue<Integer>queue=new LinkedList<>();
        queue.add(destination);
        while(!queue.isEmpty()){
            int poll=queue.poll();
            visit[poll]=true;
            for(int g:graph.get(poll)){
                if(distance[g]>distance[poll]+1){
                    distance[g]=distance[poll]+1;
                }
                if(!visit[g]){
                    queue.offer(g);
                }
            }
        }
        for(int i=0;i<sources.length;i++){
            if(distance[sources[i]]!=Integer.MAX_VALUE){
                answer[i]=distance[sources[i]];
            }else{
                answer[i]=-1;
            }    
        }
        
        return answer;
    }
}
