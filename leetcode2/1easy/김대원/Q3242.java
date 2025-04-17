class NeighborSum {

  int[][] grid;
  Map<Integer, int[]> table;

  public NeighborSum(int[][] grid) {
    this.grid = grid.clone();
    table = new HashMap<>();
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        int value = grid[i][j];
        table.put(value, new int[] {i, j});
      }
    }

    table.put(-1, new int[] {-1, 0, 1, 0});
    table.put(-2, new int[] {0, 1, 0, -1});
    table.put(-3, new int[] {-1, -1, 1, 1});
    table.put(-4, new int[] {-1, 1, 1, -1});
  }

  public int adjacentSum(int value) {
    return getResult(value, -1);
  }

  public int diagonalSum(int value) {
    return getResult(value, -3);
  }

  private int getResult(int value, int type) {
    int[] pos = table.get(value);
    int[] dx = table.get(type);
    int[] dy = table.get(type - 1);

    int result = 0;
    for (int i = 0; i < dx.length; i++) {
      int nx = pos[0] + dx[i];
      int ny = pos[1] + dy[i];

      if (validPos(nx, ny)) result += this.grid[nx][ny];
    }

    return result;
  }

  private boolean validPos(int x, int y) {
    if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length) return true;
    return false;
  }
}

/**
 * Your NeighborSum object will be instantiated and called as such:
 * NeighborSum obj = new NeighborSum(grid);
 * int param_1 = obj.adjacentSum(value);
 * int param_2 = obj.diagonalSum(value);
 */