class Solution {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) Arrays.fill(grid[i], 1);
        for (int i = 0; i < mines.length; i++) {
            int[] mine = mines[i];
            grid[mine[0]][mine[1]] = 0;
        }

        int answer= 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) answer = Math.max(answer, getMax(i, j, grid));
            }
        }

        return answer;
    }

    private int getMax(int x, int y, int[][] grid) {
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, -1, 0, 1};
        int result = 1;
        int n = grid.length;
        int[] nx = new int[4];
        int[] ny = new int[4];
        Arrays.fill(nx, x);
        Arrays.fill(ny, y);

        while (true) {
            boolean flag = true;
            for (int i = 0; i < 4; i++) {
                nx[i] += dx[i];
                ny[i] += dy[i];

                if (!canNext(nx[i], ny[i], grid, n)) {
                    flag = false;
                    break;
                }
            }

            if (flag) result++;
            else break;
        }

        return result;
    }

    private boolean canNext(int nx, int ny, int[][] grid, int n) {
        return nx >= 0 && nx < n && ny >= 0 && ny < n && grid[nx][ny] == 1;
    }
}