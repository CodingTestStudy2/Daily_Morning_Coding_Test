class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] ch = new int[n][m];

        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (ch[i][j] == 0 && grid[i][j] == '1') {
                    answer++;
                    search(ch, grid, i, j);
                }
            }
        }

        return answer;
    }

    public void search(int[][] ch, char[][] grid, int x, int y) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x, y});
        ch[x][y] = 1;
        while (!queue.isEmpty()) {
            int[] pos = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = pos[0] + dx[i];
                int ny = pos[1] + dy[i];

                if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length) {
                    if (grid[nx][ny] == '1' && ch[nx][ny] == 0) {
                        ch[nx][ny] = 1;
                        queue.offer(new int[] {nx, ny});
                    }
                }
            }
        }
    }
}

