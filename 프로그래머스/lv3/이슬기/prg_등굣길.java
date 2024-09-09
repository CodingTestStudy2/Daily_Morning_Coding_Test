/**
* BFS -> 물이 잠기지 않은 지역을 피하면 됨
* -> 시간초과
*
* DP로 다시 품
*/
class Solution {
    public int solution(int m, int n, int[][] puddles) {
        boolean[][] map = new boolean[n+1][m+1];
        int[][] dp = new int[n+1][m+1];
        
        for (int j=0; j<puddles.length; j++) {
            map[puddles[j][1]][puddles[j][0]] = true;
        }
        
        dp[1][1] = 1;
        
        for (int i=1; i<n+1; i++) {
            for (int j=1; j<m+1; j++) {
                if (i==1 && j==1 || map[i][j]) continue;
                
                dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000007;
            }
        }
        //System.out.println(Arrays.deepToString(dp));
        
        return dp[n][m];
    }
}