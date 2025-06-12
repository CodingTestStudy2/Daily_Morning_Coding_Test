package 한준호;

class Solution {
    public int waysToReachTarget(int target, int[][] types) {
        long[] dp = new long[target+1];
        dp[0] = 1L;
        for(int i = 0; i<types.length; i++){
            for(int now = target; now>=0; now--){
                for(int k = 1; k<=types[i][0]; k++){
                    int plusVal = k*types[i][1];
                    if(now + plusVal > target) continue;
                    dp[now+plusVal] += dp[now];
                    dp[now+plusVal] %= 1000000007L;
                }
            }
        }
        return (int) dp[target];
    }
}


/**
 count <= 50
 BFS?
 뒤에서부터 하면 DP도 가능
 */