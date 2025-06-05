class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1) return -1;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0});
        grid[0][0] = 1;
        int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
        int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int x = now[0], y = now[1];

            for (int i = 0; i < 8; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && grid[nx][ny] == 0) {
                    grid[nx][ny] = grid[x][y] + 1;
                    queue.offer(new int[] {nx, ny});
                }
            }
        }

        return grid[n - 1][m - 1] != 0 ? grid[n - 1][m - 1] : -1;
    }
}