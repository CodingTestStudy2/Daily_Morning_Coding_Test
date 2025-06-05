# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

'''


'''
import java.util.*;
<<<<<<< HEAD
class Leetcode.이재훈.이재훈.Solution {
=======
class Leetcode.이재훈.Solution {
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
    public int solution(int m, int n, int[][] puddles) {
        boolean[][] pds = new boolean[n][m];
        for (int[] puddle : puddles) {
            pds[puddle[1] - 1][puddle[0] - 1] = true;
        }
        
        int[][] board = new int[n][m];
        for (int row=0; row<n; row++) {
            if (pds[row][0]) break;
            board[row][0] = 1;
        }
        for (int col=0; col<m; col++) {
            if (pds[0][col]) break;
            board[0][col] = 1;
        }
        
        for (int row=1; row<n; row++) {
            for (int col=1; col<m; col++) {
                if (pds[row][col]) continue;
                board[row][col] = (board[row-1][col] + board[row][col-1]) % 1000000007;
            }
        }
        return board[n-1][m-1];
    }
}'''
