import java.util.*;
class Solution {
    class Node{
        int come;
        int out;
        int cost;
        public Node(int come,int out,int cost){
            this.come=come;
            this.out=out;
            this.cost=cost;
        }
    }
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[]dist=new int[N+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[1]=0;
        List<Node>graph=new ArrayList<>();
        for(int i=0;i<road.length;i++){
            graph.add(new Node(road[i][0],road[i][1],road[i][2]));
            graph.add(new Node(road[i][1],road[i][0],road[i][2]));
        }
        int line=graph.size();
        for(int i=0;i<N;i++){
            for(int j=0;j<line;j++){
                Node node=graph.get(j);
                if(dist[node.come]!=Integer.MAX_VALUE && dist[node.out]>dist[node.come]+node.cost){
                    dist[node.out]=dist[node.come]+node.cost;
                }
            }
        }
        for(int i=1;i<=N;i++){
            if(dist[i]<=K){
                answer+=1;
            }
        }
        return answer;
    }
}
