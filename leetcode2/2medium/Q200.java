package Leetcode;

/*
1. 아이디어 :

- dfs로 각 1로 나누어진 섬들 카운트

2. 시간복잡도 :
O( n + m)
3. 자료구조/알고리즘 :
- / dfs
 */

public class Q200 {
    class Solution {
        class Coodination {
            int x;
            int y;

            public Coodination(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }

        public List<Coodination> findNeigbours(Coodination coodination, char[][] grid) {
            int rowLength = grid.length;
            int colLength = grid[0].length;

            int[] dx = {-1, 0, 1, 0};
            int[] dy = {0,1, 0, -1};

            List<Coodination> result = new ArrayList<>();

            for(int i = 0; i < dx.length; i++) {
                int row = coodination.x + dx[i];
                int col = coodination.y + dy[i];

                if(row >= 0 && row < rowLength && col >= 0 && col < colLength) {
                    if(grid[row][col] == '1') {
                        result.add(new Coodination(row, col));
                    }
                }
            }
            return result;
        }

        static int n;
        static int m;
        static boolean[][] visited;
        public int numIslands(char[][] grid) {
            n = grid.length;
            m = grid[0].length;
            visited = new boolean[n][m];
            int count = 0;
            for(int i = 0; i<n; i++) {
                for(int j = 0; j<m;j++) {
                    if(!visited[i][j] && grid[i][j]=='1') {
                        countIsland(i, j, grid);
                        count += 1;
                    }
                }
            }

            return count;
        }

        public void countIsland(int x, int y, char[][] grid) {
            Coodination coodination = new Coodination(x, y);
            for(Coodination c : findNeigbours(coodination, grid)) {
                if(visited[c.x][c.y]) continue;
                visited[c.x][c.y] = true;
                countIsland(c.x, c.y, grid);
            }
        }

        // public void countIsland(int x, int y, char[][] grid) {
        //     Queue<Coodination> queue = new LinkedList<>();

        //     visited[x][y] = true;
        //     queue.add(new Coodination(x,y));

        //     while(!queue.isEmpty()) {
        //         int size = queue.size();
        //         for(int i = 0; i < size; i++) {
        //             Coodination coodination = queue.poll();
        //             visited[coodination.x][coodination.y] = true;
        //             for(Coodination c : findNeigbours(coodination, grid)) {
        //                 if(visited[c.x][c.y]) continue;
        //                 visited[c.x][c.y] = true;
        //                 queue.add(new Coodination(c.x, c.y));
        //             }
        //         }
        //     }
        // }
    }
}