import java.util.*;
class Solution {
    int max=0;
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        boolean[]visit=new boolean[dungeons.length];
        dfs(k,dungeons,visit,0);
        return max;
    }
    public void dfs(int k,int[][]dungeons,boolean[]visit,int cnt){
        for(int i=0;i<dungeons.length;i++){
            if(!visit[i] && k>=dungeons[i][0]){
                visit[i]=true;
                dfs(k-dungeons[i][1],dungeons,visit,cnt+1);
                visit[i]=false;
            }
        }
        max=Math.max(cnt,max);
        return;
    }
}
