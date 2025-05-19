class Solution {
    public int surfaceArea(int[][] grid) {
        int total = 0;
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                total += grid[i][j] * 4 + 2;
                pq.offer(new int[] {i, j, grid[i][j]});
            }
        }

        int gap = 0;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        while (!pq.isEmpty()) {
            int[] now = pq.poll();
            int x = now[0];
            int y = now[1];
            int val = now[2];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if (val > grid[nx][ny]) gap += (val - grid[nx][ny]);
                }
            }
        }

        return total - gap;
    }
}