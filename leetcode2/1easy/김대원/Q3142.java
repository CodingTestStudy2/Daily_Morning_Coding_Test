class Solution {
    public boolean satisfiesConditions(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int w = grid[i][j];
                if ((check(i + 1, j, n, m) && w != grid[i + 1][j]) ||
                        (check(i, j + 1, n, m) && w == grid[i][j + 1])
                ) {
                    return false;
                }
            }
        }

        return true;
    }

    private boolean check(int x, int y, int n, int m) {
        return x >= 0 && x < n && y >= 0 && y < m;
    }
}