# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;
class Solution {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int rows = m, cols = n;
        int[][][] dp = new int[rows][cols][2]; // right, down
        dp[0][0] = new int[]{1,1};

        for (int row=1; row<rows; row++) {
            if (cityMap[row][0] == 1) break;
            dp[row][0][1] = 1;
            dp[row][0][0] = cityMap[row][0] == 2 ? 0: 1;
        }
        for (int col=1; col<cols; col++) {
            if (cityMap[0][col] == 1) break;
            dp[0][col][0] = 1;
            dp[0][col][1] = cityMap[0][col] == 2 ? 0: 1;
        }

        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                if (cityMap[row][col] == 1) continue;
                if (cityMap[row][col] == 2) {
                    dp[row][col][0] = dp[row][col-1][0] % MOD;
                    dp[row][col][1] = dp[row-1][col][1] % MOD;
                } else {
                    dp[row][col][0] = (dp[row][col-1][0] + dp[row-1][col][1]) % MOD;
                    dp[row][col][1] = (dp[row][col-1][0] + dp[row-1][col][1]) % MOD;
                }
            }
        }
        return (dp[rows-1][cols-1][0]) % MOD;
    }
}

'''


