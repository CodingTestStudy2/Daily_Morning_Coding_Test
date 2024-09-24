class Solution {
    public int solution(int sticker[]) {
        int ans = 0;
        int n = sticker.length;
        
        // 크기가 1인 경우 예외 처리 
        if(n == 1) return sticker[0];
        
        int[] dp = new int[n];
        
        // 첫번째 스티커를 떼는 경우 
        dp[0] = sticker[0];
        dp[1] = dp[0];
        for(int i = 2; i < n - 1; i++){
            dp[i] = Math.max(dp[i - 2] + sticker[i], dp[i - 1]);
        }
        ans = Math.max(ans, dp[n - 2]);
        
        // 첫번째 스티커를 떼지 않는 경우
        dp[0] = 0;
        dp[1] = sticker[1];
        for(int i = 2; i < n; i++){
            dp[i] = Math.max(dp[i - 2] + sticker[i], dp[i - 1]);
        }
        ans = Math.max(ans, dp[n - 1]);
        
        return ans;
    }
}