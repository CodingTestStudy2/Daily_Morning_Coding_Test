package 이재훈;

/*
1. 아이디어 :

- 8 방향으로 0,0 에서 n-1,n-1 까지의 최소 거리를 구함
- 0,0 또는 n-1,n-1이 1인경우 갈수가 없으므로 -1
- n-1,n-1까지 못갔는데 큐의 멈추면 -1
- 큐에서 돌다가 n-1,n-1까지 도착했을때 움직일때마다 카운트 + 1 했던 값을 반환

2. 시간복잡도 :
O( n  )
3. 자료구조/알고리즘 :
- / BFS
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Q1091 {
    class Solution {

        class Coord {
            int x;
            int y;

            public Coord(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        public List<Coord> getNeighbour(Coord coord, int[][] grid) {
            int rowLength = grid.length;
            int colLength = grid[0].length;

            List<Coord> res = new ArrayList<>();

            int[] rows ={-1,-1,-0,1,1,1,0,-1};
            int[] cols ={0,1,1,1,0,-1,-1,-1};

            for(int i = 0; i<8; i++) {
                int row = rows[i] + coord.x;
                int col = cols[i] + coord.y;

                if(row>=0 && row < rowLength && col >=0 && col < colLength) {
                    if(grid[row][col] != 1) res.add(new Coord(row, col));
                }
            }
            return res;
        }
        public int shortestPathBinaryMatrix(int[][] grid) {
            int n = grid.length;
            if(grid[0][0] == 1 || grid[n-1][n-1] == 1) return -1;

            boolean[][] visited = new boolean[n][n];

            Queue<Coord> q = new LinkedList<>();

            q.add(new Coord(0,0));
            visited[0][0] = true;
            int count = 0;
            boolean isFlag = false;

            loop :
            while(!q.isEmpty()) {
                int size = q.size();

                for(int i = 0; i<size;i++) {
                    Coord coordination = q.poll();
                    if(coordination.x == n-1 && coordination.y == n-1) {
                        count++;
                        isFlag = true;
                        break loop;
                    }
                    for(Coord co : getNeighbour(coordination, grid)) {
                        int x = co.x;
                        int y = co.y;

                        if(visited[x][y]) continue;
                        visited[x][y] = true;
                        q.add(new Coord(x,y));
                    }
                }

                count++;
            }

            return isFlag ? count : -1;
        }
    }
}