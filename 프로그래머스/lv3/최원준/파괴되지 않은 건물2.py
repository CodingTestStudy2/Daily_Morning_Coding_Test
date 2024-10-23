# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;
class Solution {
    public int solution(int[][] board, int[][] skills) {
        int n = board.length, m = board[0].length;
        int[][] dp = new int[n+2][m+2];

        for (int[] s: skills){
            int type = s[0] == 1? -1 : 1; //1:attack, 2:heal
            int r1 = s[1], c1 = s[2], r2 = s[3], c2 = s[4];
            int degree = s[5] * type;
            dp[r1+1][c1+1] += degree;
            dp[r2+2][c1+1] -= degree;
            dp[r1+1][c2+2] -= degree;
            dp[r2+2][c2+2] += degree;
        }

        for (int row = 1; row < n+2; row++) {
            int prefix = dp[row][0];
            for (int col = 1; col < m+2; col++) {
                prefix += dp[row][col];
                dp[row][col] = dp[row-1][col] + prefix;
            }
        }

        int ans = 0;
        for (int row=0; row<n; row++) {
            for (int col = 0; col<m; col++) {
                if (board[row][col] + dp[row+1][col+1] > 0) ans++;
            }
        }
        return ans;
    }
}

'''


def solution(board, skill):
    n = len(board)
    m = len(board[0])

    dp = [[0 for _ in range(m + 2)] for _ in range(n + 2)]

    for t, r1, c1, r2, c2, degree in skill:
        if t == 1:
            degree *= -1

        dp[r1 + 1][c1 + 1] += degree
        dp[r1 + 1][c2 + 2] -= degree
        dp[r2 + 2][c1 + 1] -= degree
        dp[r2 + 2][c2 + 2] += degree

    for row in range(1, n+2):
        prefix = dp[row][0];
        for col in range(1, m+2):
            prefix += dp[row][col]
            dp[row][col] = dp[row-1][col] + prefix

    ans = 0
    for row in range(n):
        for col in range(m):
            if board[row][col] + dp[row+1][col+1] > 0:
                ans += 1
    return ans

