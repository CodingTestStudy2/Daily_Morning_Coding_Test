# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

class Leetcode.이재훈.Solution {
    public int solution(int[][] m) {
        int n = m.length;
        int[][] dp = new int[n][n];

        for (int length=1; length<n; length++) {
            for (int i=0; i<n-length; i++) {
                int j = i+length;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k=i; k<j; k++) {
                    int cost = dp[i][k] + dp[k+1][j] + m[i][0] * m[k][1] * m[j][1];
                    // int cost = dp[i][k] + dp[k+1][j] + m[i][0] * m[k+1][0] * m[j][1];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        return dp[0][n-1];
    }
}
'''



