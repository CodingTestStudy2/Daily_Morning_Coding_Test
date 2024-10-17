class Solution {
    static int max = 0;
    static int visited[] = new int[8];
    static void dfs(int cnt, int limit, int[][] dungeons){
        int flag = 0;
        for(int i=0; i<dungeons.length; i++){
            if(visited[i]==0&&limit>=dungeons[i][0]){ 
                flag = 1;
                visited[i]=1;
                dfs(cnt+1,limit-dungeons[i][1],dungeons);
                visited[i]=0;
            }
        }
        if(flag==0)
            max = Math.max(cnt,max);
    }
    public int solution(int k, int[][] dungeons) {
        dfs(0,k,dungeons);
        return max;
    }
}