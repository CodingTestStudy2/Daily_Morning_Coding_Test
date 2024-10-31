/*
행 m, 열 n 
오른쪽 또는 아래로만 이동 가능 
1 -> 통행 금지 
2 -> 이동 방향 회전 금지 
이동 가능한 전체 경로 수 출력 
*/
class Solution {
    int answer = 0;
    int MOD = 20170805;
    
    public int solution(int m, int n, int[][] cityMap) {
        // (i, j)로 이동 가능한 경로의 수 저장 (방향 포함)
        int[][][] dp = new int[m + 1][n + 1][2];
        
        // 0: 아래쪽으로 이동 
        // 1: 오른쪽으로 이동 
        dp[1][1][0] = 1;
        dp[1][1][1] = 1;
        
        for(int i = 1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                if(cityMap[i - 1][j - 1] == 0){
                    // 위에서 아래로 or 왼쪽에서 오른쪽으로 
                    dp[i][j][0] += (dp[i-1][j][0] + dp[i][j-1][1]) % MOD; 
                    dp[i][j][1] += (dp[i-1][j][0] + dp[i][j-1][1]) % MOD; 
                }else if(cityMap[i - 1][j - 1] == 1){
                    dp[i][j][0] = 0;
                    dp[i][j][1] = 0;
                }else{
                    // 위에서 아래로 이동
                    dp[i][j][0] += dp[i-1][j][0];
                    
                    // 왼쪽에서 오른쪽으로 이동 
                    dp[i][j][1] += dp[i][j-1][1]; 
                }
            }
        }
        
        return dp[m][n][0];
    }
}
