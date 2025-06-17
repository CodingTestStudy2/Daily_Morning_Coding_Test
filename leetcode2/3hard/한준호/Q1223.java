package 한준호;

class Solution {
    public static long MOD = 1_000_000_007L;
    public int dieSimulator(int n, int[] rollMax) {
        long[][][] dp = new long [5001][7][16];
        for(int i = 1; i<=6; i++)dp[1][i][1] = 1;
        for(int i = 1; i<n; i++){
            for(int nowDice = 1; nowDice<=6; nowDice++){
                for(int nowDup = 1; nowDup <= rollMax[nowDice-1]; nowDup++){
                    for(int nextDice = 1; nextDice<=6; nextDice++){
                        if(nowDice == nextDice){
                            if(nowDup == rollMax[nowDice - 1]) continue;
                            dp[i+1][nextDice][nowDup+1] += dp[i][nowDice][nowDup];
                            dp[i+1][nextDice][nowDup+1] %= MOD;
                        }else{
                            dp[i+1][nextDice][1] += dp[i][nowDice][nowDup];
                            dp[i+1][nextDice][1] %= MOD;
                        }
                    }
                }
            }
        }
        int ans = 0;
        for(int i = 0; i<= 6; i++){
            for(int j = 0; j<=15; j++){
                ans+= dp[n][i][j];
                ans%=MOD;
            }
        }
        return ans;
    }
}