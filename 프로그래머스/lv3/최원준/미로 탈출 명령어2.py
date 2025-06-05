# https://www.acmicpc.net/problem/

'''
1. 아이디어 :
    dfs를 사용.
    우선순위가 높은 d, l, r, u 순으로 이동.
    possible을 통해 이동 가능한지 확인.
2. 시간복잡도 :
    O( 4 ** k)
3. 자료구조 :
    배열

import java.util.*;
<<<<<<< HEAD
class Leetcode.이재훈.이재훈.Solution {
=======
class Leetcode.이재훈.Solution {
>>>>>>> ab7f46f73d8f18bcd38c5cf06ecabae64f53a424
    ArrayList<String[]> directions = new ArrayList<>();

    public boolean possible(int n, int m, int row, int col, int r, int c, int kRemain) {
        return Math.abs(row-r) + Math.abs(col-c) <= kRemain && 1<= row && row <= n && 1<= col && col <= m;
    }

    public String dfs(int n, int m, int row, int col, int r, int c, int kRemain, String path) {
        if (kRemain == 0) return path;
        for (var dir : directions) {
            int xMove = Integer.parseInt(dir[1]), yMove = Integer.parseInt(dir[2]);
            if (possible(n, m, row+xMove, col+yMove, r, c, kRemain-1)) {
                return dfs(n, m, row+xMove, col+yMove, r, c, kRemain-1, path + dir[0]);
            }
        }
        return "impossible";
    }

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        directions.add(new String[]{"d", "1", "0"});
        directions.add(new String[]{"l", "0", "-1"});
        directions.add(new String[]{"r", "0", "1"});
        directions.add(new String[]{"u", "-1", "0"});

        int totalDistance = Math.abs(x-r) + Math.abs(y-c);
        int additionalMoves = k - totalDistance; // /2 True
        if (additionalMoves % 2 == 1) return "impossible";
        return dfs(n, m, x, y, r, c, k, "");
    }
}
'''


import sys
sys.setrecursionlimit(10000)
def solution(n, m, x, y, r, c, k):
    directions = []
    directions.append(['d',1, 0])
    directions.append(['l',0,-1])
    directions.append(['r',0, 1])
    directions.append(['u',-1, 0])
    total_distance = abs(x - r) + abs(y - c)
    if total_distance > k or (k - total_distance) % 2 == 1:
        return "impossible"

    def possible(row, col, k_remain):
        return abs(row - r) + abs(col - c) <= k_remain and 1 <= row <= n and 1 <= col <= m

    def dfs(row, col, k_remain, path):
        if k_remain == 0: return path

        for direction, x_move, y_move in directions:
            new_row, new_col = row + x_move, col + y_move
            if possible(new_row, new_col, k_remain - 1):
                return dfs(new_row, new_col, k_remain - 1, path + direction)
        return "impossible"

    return dfs(x, y, k, "")

