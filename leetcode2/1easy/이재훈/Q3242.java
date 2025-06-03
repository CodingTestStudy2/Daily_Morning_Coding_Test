package Leetcode.이재훈;

/*
1. 아이디어 :

2. 시간복잡도 :
O( n**2 )
3. 자료구조/알고리즘 :
- / 완전탐색
 */

public class Q3242 {
    class NeighborSum {

        int[][] grid;

        public NeighborSum(int[][] grid) {
            this.grid = grid;
        }

        public int adjacentSum(int value) {
            int rowLength = grid.length;
            int colLength = grid[0].length;
            int row = 0;
            int col = 0;

            outerLoop:
            for(int i = 0; i<rowLength; i++) {
                for(int j = 0; j<colLength;j++) {
                    if(value == grid[i][j]) {
                        row = i;
                        col = j;
                        break outerLoop;
                    }
                }
            }


            int[] rows = {-1,0,1,0};
            int[] cols = {0,1,0,-1};
            int res =0;
            for(int i = 0; i<4;i++) {
                int r = row + rows[i];
                int c = col + cols[i];

                if(r >= 0 && r <rowLength && c >=0 && c<colLength) {
                    res += grid[r][c];
                }
            }
            return res;
        }

        public int diagonalSum(int value) {
            int rowLength = grid.length;
            int colLength = grid[0].length;
            int row = 0;
            int col = 0;
            outerLoop:
            for(int i = 0; i<rowLength; i++) {
                for(int j = 0; j<colLength;j++) {
                    if(value == grid[i][j]) {
                        row = i;
                        col = j;
                        break outerLoop;
                    }
                }
            }

            int[] rows = {-1,-1,1,1};
            int[] cols = {-1,1,1,-1};
            int res =0;

            for(int i = 0; i<4;i++) {
                int r = row + rows[i];
                int c = col + cols[i];

                if(r >= 0 && r <rowLength && c >=0 && c<colLength) {
                    res += grid[r][c];
                }
            }
            return res;
        }
    }

/**
 * Your NeighborSum object will be instantiated and called as such:
 * NeighborSum obj = new NeighborSum(grid);
 * int param_1 = obj.adjacentSum(value);
 * int param_2 = obj.diagonalSum(value);
 */
}