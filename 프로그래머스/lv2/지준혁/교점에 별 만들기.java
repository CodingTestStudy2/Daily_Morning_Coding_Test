import java.util.*;

class Solution {
    public String[] solution(int[][] line) {
        int n = line.length;
        
        List<int[]> meet = new ArrayList<>();
 
        int minX = Integer.MAX_VALUE;
        int maxX = Integer.MIN_VALUE;
        int minY = Integer.MAX_VALUE;
        int maxY = Integer.MIN_VALUE;
        for (int i = 0; i < n - 1; ++i) {
            for (int j = i + 1; j < n; ++j) {
                int A = line[i][0];
                int B = line[i][1];
                int E = line[i][2];
                int C = line[j][0];
                int D = line[j][1];
                int F = line[j][2];
                
                double deltaY = A * D - B * C;
                double deltaX1 = B * F - E * D;
                double deltaX2 = E * C - A * F;
                if (deltaY == 0) continue; 
                double x = deltaX1 / deltaY;
                double y = deltaX2 / deltaY;
                if (x == (int)x && y == (int)y) {
                    meet.add(new int[]{(int)x, (int)y});
                    minX = Math.min(minX, (int)x);
                    maxX = Math.max(maxX, (int)x);
                    minY = Math.min(minY, (int)y);
                    maxY = Math.max(maxY, (int)y);
                }
            }
        }
        int xLen = maxX - minX + 1;
        int yLen = maxY - minY + 1;
        char[][] board = new char[xLen][yLen];
        for (int i = 0; i < xLen; ++i) 
            Arrays.fill(board[i], '.');

        for (var e : meet) {
            int x = e[0] - minX;
            int y = maxY - e[1];
            board[x][y] = '*';
        }

        String[] ans = new String[xLen];
        for (int i = 0; i < xLen; ++i) {
            ans[i] = new String(board[i]);
        }
        return ans;
    }
}
