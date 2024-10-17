class Solution {
    static int answer = 0;
    public int solution(int k, int[][] dungeons) {
       solve(dungeons, new boolean[dungeons.length], k, 0);
        return answer;
    }
    
    public void solve(int[][] dungeons, boolean[] visited, int hp, int sum){
        answer = Math.max(answer, sum);
        if(sum == dungeons.length || hp <= 0){
            return;
        }
        
        
        for(int i=0; i<dungeons.length; i++){
            int[] d = dungeons[i]; //최소 필요 피로도, 소모 피로도
            
            if(hp >= d[0] && !visited[i]){
                visited[i] = true;
                solve(dungeons, visited, hp-d[1], sum+1);
                visited[i] = false;
            }
        }
    }
}
