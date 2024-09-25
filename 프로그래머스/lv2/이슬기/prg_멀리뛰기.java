/**
* 멀리뛰기
4 1칸, 또는 2칸
= 1 + 1 + 1 + 1
= 1 + 1 + 2
= 1 + 2 + 1
= 2 + 1 + 1
= 2 + 2
1234567을 나눈 함수.. -> DP?
[1, 1+1, 1+2, 1+3+1, 1+4+3, 1+5+5+1]
     1    1     2      3       4
5
= 1 + 1 + 1 + 1 + 1
= 1 + 1 + 1 + 2 (4개)
= 1 + 2 + 2 (3개)

6
= 1 + 1 + 1 + 1 + 1 + 1
= 1 + 1 + 1 + 1 + 2 (5개)
= 1 + 1 + 2 + 2 (5개)
= 2 + 2 + 2 (1개)
*/
import java.util.*;

class Solution {
    public long solution(int n) {
        long answer = 0;
        int[] dp = new int[n+1];
        dp[0] = dp[1] = 1;
        
        for (int i=2; i<n+1; i++) {
            dp[i] = (dp[i-1] + dp[i-2]) % 1234567;
        }
        
        //System.out.println(Arrays.toString(dp));
        
        return dp[n];
    }
}