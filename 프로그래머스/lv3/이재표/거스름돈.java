import java.util.*;
class Solution {
    public int solution(int n, int[] money) {
        int[] dp=new int[n+1];
        dp[0]=1;
        for (int i = 0; i < money.length; i++) {
        for (int m = money[i]; m <= n; m++) {
            dp[m] = (dp[m] + dp[m - money[i]]) % 1000000007;
        }
    }
        return dp[n];
    }
}
