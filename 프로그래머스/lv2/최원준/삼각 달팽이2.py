# https://www.acmicpc.net/problem/

'''
1. 아이디어 :

2. 시간복잡도 :
    O(
3. 자료구조 :

import java.util.*;
class Leetcode.이재훈.이재훈.Solution {
    public int[] solution(int n) {
        int total = 0;
        for (int i=0; i<=n; i++) {
            total += i;
        }
        int[][] py = new int[n][n];


        int row = -1;
        int col = 0;
        int dir = 0; // 0 down 1 right 2 up
        int curr = 1;

        for (int length = n; length > -1; length--) {
            for (int i = 0; i<length; i++) {
                if (dir == 0) {
                    row++;
                } else if (dir == 1) {
                    col++;
                } else {
                    row--;
                    col--;
                }
                py[row][col] = curr++;
            }
            dir = (dir+1)%3;

        }
        int[] ans = new int[total];
        int idx = 0;
        for (row=0; row<n; row++) {
            for (col=0; col<n; col++) {
                if (py[row][col] == 0) continue;
                ans[idx++] = py[row][col];
            }
        }
        return ans;
    }
}
'''



