// 작성 중 시간...
class Solution {
    
    int dp[504][504];
    public int solution(int[][] triangle) {
        
        dp[0][0] = triangle[0][0];
        for (int i = 1; i <= n; ++i) {
            for (int j = 0; j <= i; ++j) {
                if (j == 0) dp[i][j] = dp[i - 1][j] + triangle[i][j];
                else if (j == i) dp[i][j] = dp[i - 1][j - 1] + triangle[i][j];
                else 
            }
        }
        return answer;
    }
}
